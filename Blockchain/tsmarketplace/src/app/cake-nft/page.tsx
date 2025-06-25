"use client"

import { useState } from "react"
import CakeNft from "@/components/CakeNft"
import { useAccount, useChainId } from "wagmi"
import { ConnectButton } from "@rainbow-me/rainbowkit"
import { RiCakeLine } from "react-icons/ri"
import { chainsToContracts } from "@/constants"

export default function Home() {
    const account = useAccount()
    const chainId = useChainId()
    const chainSupported =
        chainId in chainsToContracts && chainsToContracts[chainId]?.cakeNft !== undefined

    return (
        <div className="min-h-screen bg-zinc-50 flex flex-col">
            <main className="flex-1 container mx-auto px-4 py-8">
                <div className="max-w-4xl mx-auto">
                    {/* Connection Status */}
                    {!account.isConnected ? (
                        <div className="p-8 bg-white rounded-xl shadow-sm border border-zinc-200 text-center">
                            <p className="text-lg text-zinc-600 mb-4">
                                Connect your wallet to interact with the Cake NFT contract
                            </p>
                            <div className="flex justify-center">
                                <ConnectButton />
                            </div>
                        </div>
                    ) : !chainSupported ? (
                        <div className="p-8 bg-white rounded-xl shadow-sm border border-zinc-200 text-center">
                            <p className="text-lg text-red-600 mb-4">
                                The current network is not supported. Please switch to a supported
                                network.
                            </p>
                            <div className="flex justify-center">
                                <ConnectButton />
                            </div>
                        </div>
                    ) : (
                        <CakeNft />
                    )}
                </div>
            </main>

            <footer className="bg-white border-t border-zinc-200 py-4">
                <div className="container mx-auto px-4">
                    <p className="text-center text-zinc-500 text-sm">
                        Cake NFT Bakery • Built with Next.js, Wagmi, and Rainbow Kit
                    </p>
                </div>
            </footer>
        </div>
    )
}
