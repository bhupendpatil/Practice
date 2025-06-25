// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import {ERC721} from "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import {ERC20} from "@openzeppelin/contracts/token/ERC20/ERC20.sol";

/**
 * @title MockERC721
 * @dev Simple ERC721 implementation for testing
 */
contract MockERC721 is ERC721 {
    constructor(string memory name, string memory symbol) ERC721(name, symbol) {}

    function mint(address to, uint256 tokenId) external {
        _mint(to, tokenId);
    }
}

/**
 * @title MockERC20
 * @dev Simple ERC20 implementation for testing
 */
contract MockERC20 is ERC20 {
    constructor(string memory name, string memory symbol) ERC20(name, symbol) {}

    function mint(address to, uint256 amount) external {
        _mint(to, amount);
    }
}

/**
 * @title MockFailingERC20
 * @dev ERC20 implementation that fails on transfer for testing error scenarios
 */
contract MockFailingERC20 is ERC20 {
    constructor(string memory name, string memory symbol) ERC20(name, symbol) {}

    function mint(address to, uint256 amount) external {
        _mint(to, amount);
    }

    function transfer(address, /*to*/ uint256 /*amount*/ ) public pure override returns (bool) {
        return false; // Always fail
    }

    function transferFrom(address, /*from*/ address, /*to*/ uint256 /*amount*/ ) public pure override returns (bool) {
        return false; // Always fail
    }
}

/**
 * @title MockNonReceiver
 * @dev Contract that cannot receive ERC721 tokens correctly
 */
contract MockNonReceiver {
    // This contract intentionally does not implement IERC721Receiver

    // Fallback function to receive ETH
    receive() external payable {}
}
