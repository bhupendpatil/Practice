// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import {Script, console} from "forge-std/Script.sol";
import {DeployCakeNft} from "./DeployCakeNft.s.sol";
import {DeployMarketplace} from "./DeployMarketplace.s.sol";
import {DeployMoodNft} from "./DeployMoodNft.s.sol";
import {MintAndListCake} from "./MintAndListCake.s.sol";
import {MockUSDC} from "../src/MockUSDC.sol";
import {MoodNft} from "../src/MoodNft.sol";

contract SetupAnvil is Script {
    DeployMarketplace deployMarketplace;
    DeployCakeNft deployCakeNft;
    DeployMoodNft deployMoodNft;
    MintAndListCake mintAndListCake;

    function run() external {
        deployMarketplace = new DeployMarketplace();
        deployCakeNft = new DeployCakeNft();
        deployMoodNft = new DeployMoodNft();
        mintAndListCake = new MintAndListCake();

        vm.startBroadcast();
        MockUSDC usdc = new MockUSDC();
        vm.stopBroadcast();

        console.log("USDC deployed at: ", address(usdc));

        address marketplaceAddy = address(deployMarketplace.deployMarketplace(address(usdc)));
        console.log("Marketplace deployed at: ", marketplaceAddy);

        address cakeAddy = deployCakeNft.run();
        console.log("CakeNft deployed at: ", cakeAddy);

        address moodAddy = deployMoodNft.run();
        console.log("MoodNft deployed at: ", moodAddy);

        mintAndListCake.mintAndListCake(cakeAddy, marketplaceAddy);
        mintAndListCake.mintAndListCake(cakeAddy, marketplaceAddy);
        mintAndListCake.mintAndListCake(cakeAddy, marketplaceAddy);
        mintAndListCake.mintAndListCake(cakeAddy, marketplaceAddy);

        // This is to just mine another block, otherwise the current version of the indexer bugs
        mintAndListCake.justMintCake(cakeAddy);

        address ANVIL_ONE = 0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266;
        address ANVIL_TEN = 0xa0Ee7A142d267C1f36714E4a8F75612F20a79720;

        vm.startBroadcast();
        MoodNft(moodAddy).mintNftTo(ANVIL_ONE);
        MoodNft(moodAddy).mintNftTo(ANVIL_TEN);

        usdc.mint(ANVIL_ONE, 100e6);
        usdc.mint(ANVIL_TEN, 100e6);
        usdc.mint(ANVIL_ONE, 100e6);
        vm.stopBroadcast();
    }
}
