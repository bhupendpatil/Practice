# NFT Marketplace 

The final project for the Cyfrin Web3 Full Stack crash course, where we introduce:

1. Indexing (rindexer)
2. Fleek CLI
4. Compliance Engine
5. USDC payment
6. Gashawk

A full-stack NFT marketplace with listing, buying, and compliance features built with Next.js, TypeScript, and Wagmi.

# STARTING CODEBASE!

We will need to implement:
- Update the home page
  - Add all recently listed NFTs
  - Indexer
- Compliance Engine

If you wish to see what the final product looks like, head over to the `main` branch!


# Table of Contents

- [NFT Marketplace](#nft-marketplace)
- [STARTING CODEBASE!](#starting-codebase)
- [Table of Contents](#table-of-contents)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
    - [Environment Variables](#environment-variables)
  - [Setup](#setup)
    - [Add Anvil to your metamask](#add-anvil-to-your-metamask)
    - [Add Anvil accounts to your Metamask](#add-anvil-accounts-to-your-metamask)
    - [Docker .env](#docker-env)
  - [Running the Application](#running-the-application)
- [Database Reset](#database-reset)
- [Features](#features)
- [Addresses for testing](#addresses-for-testing)

# Getting Started

## Requirements

- [node](https://nodejs.org/en/download)
    - You'll know you've installed it right if you can run `node --version` and get a response like `v18.0.0`
- [pnpm](https://pnpm.io/)
    - You'll know you've installed it right if you can run `pnpm --version` and get a response like `8.0.0`
- [git](https://git-scm.com/downloads)
    - You'll know you've installed it right if you can run `git --version` and get a response like `git version 2.33.0`
- [foundry/anvil](https://book.getfoundry.sh/)
    - You'll know you've installed it right if you can run `anvil --version` and get a response like `anvil Version: 1.0.0-stable`
- [docker](https://www.docker.com/get-started/)
    - You'll know you've installed it right if you can run `docker --version` and get a response like `Docker version 27.4.0, build bde2b89`
- [rindexer](https://github.com/joshstevens19/rindexer)
    - ou'll know you've installed it right if you can run `rindexer --version` and get a response like `rindexer 0.15.2`

### Environment Variables

Create a `.env.local` file with the following environment variables:

```
NEXT_PUBLIC_WALLETCONNECT_PROJECT_ID=your_project_id
GRAPHQL_API_URL=http://localhost:3001/graphql
ENABLE_COMPLIANCE_CHECK=false
CIRCLE_API_KEY=TEST_API_KEY
```

- `NEXT_PUBLIC_WALLETCONNECT_PROJECT_ID`: Get this from [WalletConnect Cloud](https://cloud.walletconnect.com/)
- `GRAPHQL_API_URL`: Points to your local indexer GraphQL endpoint
- `ENABLE_COMPLIANCE_CHECK`: To enable compliance checks, set this to `true`. If you set this to false, you don't need the `CIRCLE_API_KEY`
- `CIRCLE_API_KEY`: Get this from [Circle Developer Portal](https://console.circle.com/api-keys)

## Setup

```bash
git clone https://github.com/cyfrin/ts-nft-marketplace-cu
cd nft-marketplace
pnpm install
```

### Add Anvil to your metamask

Add the following network to your metamask:
- Name: Anvil
- RPC URL: http://127.0.0.1:8545
- Chain ID: 31337
- Currency Symbol: ETH

### Add Anvil accounts to your Metamask

```
Private Keys
==================

(0) 0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80 # This one
(9) 0x2a871d0798f97d79848a013d4936a73bf4cc922c825d33c1cf7073dff6d409c6 # This one
```

Add private keys `0` and `9` to your Metamask, these will have NFTs already loaded when you run `pnpm anvil` later. 

### Docker .env

For working with a postgres DB, add a `.env` file to `./marketplaceIndexer/.env`:

```
DATABASE_URL=postgresql://postgres:rindexer@localhost:5440/postgres
POSTGRES_PASSWORD=rindexer
```

This will work with the default commands we run below. If you wish to change your database, you may change your endpoints.

## Running the Application

The application requires three components running in parallel:

- Local Ethereum blockchain (anvil), this will come with some blockchain state already loaded. Including contracts, tokens, and NFTs in the accounts you added to Metamask above.
- Blockchain indexer
- Next.js application

```bash
pnpm anvil
pnpm indexer
pnpm run dev
```

In your Metamask now, select account 0 which you imported from the step above, and add the following NFT with tokenID 0:

```
0x9fE46736679d2D9a65F0992F2272dE9f3c7fa6e0
```

You should see the NFT in your metamask. Note: This will only work while `pnpm anvil` is running!

# Database Reset
If you need to reset the indexer database:

```bash
pnpm run reset-indexer
```

This will stop the indexer, remove the volume, and restart it.

# Features

- NFT Minting: Create new NFTs with the CakeNFT contract
- NFT Listing: List your NFTs for sale on the marketplace
- NFT Buying: Purchase NFTs that others have listed
- Recently Listed NFTs: View the most recent NFTs available for purchase
- Address Compliance: Integrated with Circle's compliance API to screen addresses
- Wallet Integration: Connect with MetaMask, Rainbow, and other wallets via WalletConnect

# Addresses for testing

- usdc: "0x5FbDB2315678afecb367f032d93F642f64180aa3"
- nftMarketplace: "0xe7f1725E7734CE288F8367e1Bb143E90bb3F0512"
- cakeNft: "0x9fE46736679d2D9a65F0992F2272dE9f3c7fa6e0"
- moodNft: "0xCf7Ed3AccA5a467e9e704C703E8D87F634fB0Fc9"