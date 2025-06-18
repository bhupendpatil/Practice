"use client"

import { ConnectButton } from "@rainbow-me/rainbowkit"
import { FaGithub } from "react-icons/fa"
// import Image from "next/image"

export default function Header() {
    return (
        <nav className="px-8 py-4.5 border-b-[1px] border-zinc-100 flex flex-row justify-between items-center bg-white xl:min-h-[77px]">
            <div className="flex items-center gap-2.5 md:gap-6">
                <a href="/" className="flex items-center gap-1 text-zinc-800">
                    {/* <Image src="/T-Sender.svg" alt="TSender" width={36} height={36} /> */}
                    <h1 className="font-bold text-2xl hidden md:block">TSender</h1>
                </a>
                <a
                    href="https://github.com/bhupendpatil/Practice/tree/master/Blockchain/tsenderui"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="p-1 rounded-lg bg-zinc-900 hover:bg-zinc-800 transition-colors border-2 border-zinc-600 hover:border-zinc-500 cursor-alias hidden md:block"
                >
                    <FaGithub className="h-5 w-5 text-white" />
                </a>
            </div>
            <h3 className="italic text-left hidden text-zinc-500 lg:block">
                The most gas efficient airdrop contract on earth, built in huff 🐎
            </h3>
            <div className="flex items-center gap-4">
                <ConnectButton />
            </div>
        </nav>
    )
}