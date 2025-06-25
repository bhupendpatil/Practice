// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import {Script} from "forge-std/Script.sol";
import {NftMarketplace} from "../src/NftMarketplace.sol";

contract DeployMarketplace is Script {
    function deployMarketplace(address paymentToken) public returns (NftMarketplace) {
        vm.startBroadcast();
        NftMarketplace marketplace = new NftMarketplace(paymentToken);
        vm.stopBroadcast();
        return marketplace;
    }

    // function run() external returns (address) {
    //     NftMarketplace marketplace = deployMarketplace();
    //     return address(marketplace);
    // }
}
