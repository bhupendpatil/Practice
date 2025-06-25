// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import {Test, console} from "forge-std/Test.sol";
import {NftMarketplace} from "../src/NftMarketplace.sol";
import {MockERC721, MockERC20} from "./mocks/Mocks.sol";

contract NftMarketplaceTest is Test {
    NftMarketplace marketplace;
    MockERC721 nft;
    MockERC20 paymentToken;

    address seller = makeAddr("seller");
    address buyer = makeAddr("buyer");
    address deployer = makeAddr("deployer");

    uint256 constant PRICE = 100e6;
    uint256 constant NFT_ID = 1;

    event ItemListed(address indexed seller, address indexed nftAddress, uint256 indexed tokenId, uint256 price);
    event ItemCanceled(address indexed seller, address indexed nftAddress, uint256 indexed tokenId);
    event ItemBought(address indexed buyer, address indexed nftAddress, uint256 indexed tokenId, uint256 price);

    function setUp() public {
        vm.startPrank(deployer);

        // Deploy mocks
        paymentToken = new MockERC20("Test Token", "TEST");
        nft = new MockERC721("Test NFT", "TNFT");

        // Deploy marketplace with ERC20 payment token
        marketplace = new NftMarketplace(address(paymentToken));

        vm.stopPrank();

        // Setup seller with NFT
        vm.startPrank(seller);
        nft.mint(seller, NFT_ID);
        vm.stopPrank();

        // Setup buyer with payment tokens
        vm.startPrank(deployer);
        paymentToken.mint(buyer, 1000 ether);
        vm.stopPrank();
    }

    //////////////////////////////////////////////
    //              HELPER FUNCTIONS            //
    //////////////////////////////////////////////

    function _listNft() internal {
        vm.startPrank(seller);
        nft.approve(address(marketplace), NFT_ID);
        marketplace.listItem(address(nft), NFT_ID, PRICE);
        vm.stopPrank();
    }

    function _approveAndBuyNft() internal {
        vm.startPrank(buyer);
        paymentToken.approve(address(marketplace), PRICE);
        marketplace.buyItem(address(nft), NFT_ID);
        vm.stopPrank();
    }

    //////////////////////////////////////////////
    //              LISTING TESTS               //
    //////////////////////////////////////////////
    function test_ListItem() public {
        vm.startPrank(seller);
        nft.approve(address(marketplace), NFT_ID);

        vm.expectEmit(true, true, true, true);
        emit ItemListed(seller, address(nft), NFT_ID, PRICE);

        marketplace.listItem(address(nft), NFT_ID, PRICE);
        vm.stopPrank();

        NftMarketplace.Listing memory listing = marketplace.getListing(address(nft), NFT_ID);
        assertEq(listing.price, PRICE);
        assertEq(listing.seller, seller);
    }

    function test_RevertWhen_ListItemPriceZero() public {
        vm.startPrank(seller);
        nft.approve(address(marketplace), NFT_ID);

        vm.expectRevert(NftMarketplace.PriceMustBeAboveZero.selector);
        marketplace.listItem(address(nft), NFT_ID, 0);

        vm.stopPrank();
    }

    function test_RevertWhen_ListItemNotOwner() public {
        vm.startPrank(buyer);

        vm.expectRevert(NftMarketplace.NotOwner.selector);
        marketplace.listItem(address(nft), NFT_ID, PRICE);

        vm.stopPrank();
    }

    function test_RevertWhen_ListItemNotApproved() public {
        vm.startPrank(seller);
        // Not approving NFT for marketplace

        vm.expectRevert(NftMarketplace.NotApprovedForMarketplace.selector);
        marketplace.listItem(address(nft), NFT_ID, PRICE);

        vm.stopPrank();
    }

    function test_RevertWhen_ListItemAlreadyListed() public {
        // First listing
        _listNft();

        // Try to list again
        vm.startPrank(seller);
        vm.expectRevert(abi.encodeWithSelector(NftMarketplace.AlreadyListed.selector, address(nft), NFT_ID));
        marketplace.listItem(address(nft), NFT_ID, PRICE);
        vm.stopPrank();
    }

    //////////////////////////////////////////////
    //           CANCEL LISTING TESTS           //
    //////////////////////////////////////////////

    function test_CancelListing() public {
        _listNft();

        vm.startPrank(seller);

        vm.expectEmit(true, true, true, true);
        emit ItemCanceled(seller, address(nft), NFT_ID);

        marketplace.cancelListing(address(nft), NFT_ID);
        vm.stopPrank();

        NftMarketplace.Listing memory listing = marketplace.getListing(address(nft), NFT_ID);
        assertEq(listing.price, 0);
    }

    function test_RevertWhen_CancelListingNotOwner() public {
        _listNft();

        vm.startPrank(buyer);
        vm.expectRevert(NftMarketplace.NotOwner.selector);
        marketplace.cancelListing(address(nft), NFT_ID);
        vm.stopPrank();
    }

    function test_RevertWhen_CancelListingNotListed() public {
        vm.startPrank(seller);
        vm.expectRevert(abi.encodeWithSelector(NftMarketplace.NotListed.selector, address(nft), NFT_ID));
        marketplace.cancelListing(address(nft), NFT_ID);
        vm.stopPrank();
    }

    //////////////////////////////////////////////
    //              BUYING TESTS                //
    //////////////////////////////////////////////

    function test_BuyItem() public {
        _listNft();

        vm.startPrank(buyer);
        paymentToken.approve(address(marketplace), PRICE);

        vm.expectEmit(true, true, true, true);
        emit ItemBought(buyer, address(nft), NFT_ID, PRICE);

        marketplace.buyItem(address(nft), NFT_ID);
        vm.stopPrank();

        // Verify NFT ownership transferred
        assertEq(nft.ownerOf(NFT_ID), buyer);

        // Verify listing removed
        NftMarketplace.Listing memory listing = marketplace.getListing(address(nft), NFT_ID);
        assertEq(listing.price, 0);

        // Verify proceeds recorded for seller
        assertEq(marketplace.getProceeds(seller), PRICE);
    }

    function test_RevertWhen_BuyItemNotListed() public {
        vm.startPrank(buyer);
        vm.expectRevert(abi.encodeWithSelector(NftMarketplace.NotListed.selector, address(nft), NFT_ID));
        marketplace.buyItem(address(nft), NFT_ID);
        vm.stopPrank();
    }

    function test_RevertWhen_BuyItemInsufficientAllowance() public {
        _listNft();

        vm.startPrank(buyer);
        // Not approving payment token or approving insufficient amount
        paymentToken.approve(address(marketplace), PRICE - 1);

        vm.expectRevert(); // ERC20 will revert with insufficient allowance error
        marketplace.buyItem(address(nft), NFT_ID);
        vm.stopPrank();
    }

    function test_BuyItemWithReentrancyGuard() public {
        _listNft();
        _approveAndBuyNft();

        // Verify proceeds
        assertEq(marketplace.getProceeds(seller), PRICE);
    }

    //////////////////////////////////////////////
    //            UPDATE LISTING TESTS          //
    //////////////////////////////////////////////

    function test_UpdateListing() public {
        _listNft();

        uint256 newPrice = PRICE * 2;

        vm.startPrank(seller);

        vm.expectEmit(true, true, true, true);
        emit ItemListed(seller, address(nft), NFT_ID, newPrice);

        marketplace.updateListing(address(nft), NFT_ID, newPrice);
        vm.stopPrank();

        NftMarketplace.Listing memory listing = marketplace.getListing(address(nft), NFT_ID);
        assertEq(listing.price, newPrice);
    }

    function test_RevertWhen_UpdateListingNotListed() public {
        vm.startPrank(seller);
        vm.expectRevert(abi.encodeWithSelector(NftMarketplace.NotListed.selector, address(nft), NFT_ID));
        marketplace.updateListing(address(nft), NFT_ID, PRICE);
        vm.stopPrank();
    }

    function test_RevertWhen_UpdateListingNotOwner() public {
        _listNft();

        vm.startPrank(buyer);
        vm.expectRevert(NftMarketplace.NotOwner.selector);
        marketplace.updateListing(address(nft), NFT_ID, PRICE * 2);
        vm.stopPrank();
    }

    function test_RevertWhen_UpdateListingZeroPrice() public {
        _listNft();

        vm.startPrank(seller);
        vm.expectRevert(NftMarketplace.PriceMustBeAboveZero.selector);
        marketplace.updateListing(address(nft), NFT_ID, 0);
        vm.stopPrank();
    }

    //////////////////////////////////////////////
    //          WITHDRAW PROCEEDS TESTS         //
    //////////////////////////////////////////////

    function test_WithdrawProceeds() public {
        _listNft();
        _approveAndBuyNft();

        uint256 initialBalance = paymentToken.balanceOf(seller);

        vm.startPrank(seller);
        marketplace.withdrawProceeds();
        vm.stopPrank();

        // Verify balance increased
        assertEq(paymentToken.balanceOf(seller), initialBalance + PRICE);

        // Verify proceeds reset to 0
        assertEq(marketplace.getProceeds(seller), 0);
    }

    function test_RevertWhen_WithdrawProceedsNoProceeds() public {
        vm.startPrank(seller);
        vm.expectRevert(NftMarketplace.NoProceeds.selector);
        marketplace.withdrawProceeds();
        vm.stopPrank();
    }

    function test_MultipleListingsAndSales() public {
        // List and sell first NFT
        _listNft();
        _approveAndBuyNft();

        // Create and list second NFT
        uint256 secondNftId = 2;
        uint256 secondPrice = PRICE / 2;

        vm.startPrank(seller);
        nft.mint(seller, secondNftId);
        nft.approve(address(marketplace), secondNftId);
        marketplace.listItem(address(nft), secondNftId, secondPrice);
        vm.stopPrank();

        // Buy second NFT
        vm.startPrank(buyer);
        paymentToken.approve(address(marketplace), secondPrice);
        marketplace.buyItem(address(nft), secondNftId);
        vm.stopPrank();

        // Verify total proceeds
        assertEq(marketplace.getProceeds(seller), PRICE + secondPrice);

        // Withdraw and verify
        vm.startPrank(seller);
        marketplace.withdrawProceeds();
        vm.stopPrank();

        assertEq(paymentToken.balanceOf(seller), PRICE + secondPrice);
        assertEq(marketplace.getProceeds(seller), 0);
    }
}
