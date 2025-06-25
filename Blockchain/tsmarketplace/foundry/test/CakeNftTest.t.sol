// SPDX-License-Identifier: MIT

pragma solidity ^0.8.19;

import {CakeNft} from "../src/CakeNft.sol";
import {Test, console2} from "forge-std/Test.sol";

contract BasicNftTest is Test {
    CakeNft public cakeNft;
    address public user;

    function setUp() public {
        cakeNft = new CakeNft();
        user = makeAddr("user");
    }

    function testBakeCake() public {
        vm.prank(user);
        cakeNft.bakeCake();

        console2.log(cakeNft.tokenURI(0));

        string memory svg = cakeNft.createSvgCakeFromSeed(55);
        console2.log(svg);
    }
}
