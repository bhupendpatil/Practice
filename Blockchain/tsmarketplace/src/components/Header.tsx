"use client"

import { ConnectButton } from "@rainbow-me/rainbowkit"
import { FaGithub } from "react-icons/fa"
import Image from "next/image"

export default function Header() {
    return (
        <nav
            className="px-8 py-4.5 border-b-[1px] border-zinc-100 flex flex-row justify-between items-center xl:min-h-[77px]"
            style={{ backgroundColor: "#f7eed8" }}
        >
            <div className="flex items-center gap-2.5 md:gap-6">
                <a href="/" className="flex items-center gap-1 text-zinc-800">
                    <Image
                        src="/nft-marketplace.png"
                        alt="nft marketplace"
                        width={36}
                        height={36}
                    />
                    <h1 className="font-bold text-2xl hidden md:block">NFT Marketplace</h1>
                </a>
                <a
                    href="https://github.com/cyfrin/ts-nft-marketplace-cu"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="p-1 rounded-lg bg-zinc-900 hover:bg-zinc-800 transition-colors border-2 border-zinc-600 hover:border-zinc-500 cursor-alias hidden md:block"
                >
                    <FaGithub className="h-5 w-5 text-white" />
                </a>
            </div>
            <h3 className="italic text-left hidden text-zinc-500 lg:block">
                A non-custodial, permissionless NFT Marketplace
            </h3>
            <a href="/cake-nft" className="flex items-center gap-1 text-zinc-800">
                <h1 className="flex items-center justify-center gap-1 px-4 py-2 bg-zinc-100 hover:bg-zinc-200 text-zinc-800 rounded-md shadow-sm transition-colors duration-200 border border-zinc-300">
                    Cake NFT
                </h1>
            </a>
            <div className="flex items-center gap-4">
                <ConnectButton />
            </div>
        </nav>
    )
}
