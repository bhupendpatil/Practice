"use client"

import { useState, useMemo, useEffect } from "react"
import { RiCakeLine } from "react-icons/ri"
import {
    useChainId,
    useWriteContract,
    useAccount,
    useWaitForTransactionReceipt,
    useReadContract,
} from "wagmi"
import { cakeAbi, chainsToContracts } from "@/constants"
import { CgSpinner } from "react-icons/cg"
import { InputForm } from "./ui/InputField"

interface NFTContractFormProps {
    // If you want to pass a contract address directly (optional)
    contractAddress?: `0x${string}`
}

export default function NFTContractForm({ contractAddress }: NFTContractFormProps) {
    const account = useAccount()
    const chainId = useChainId()

    const cakeContractAddress = useMemo(() => {
        if (contractAddress) return contractAddress
        return (chainsToContracts[chainId]?.cakeNft as `0x${string}`) || null
    }, [chainId, contractAddress])

    const [tokenId, setTokenId] = useState("")
    const [myTokenIds, setMyTokenIds] = useState<string[]>([])
    const [nftImageUrl, setNftImageUrl] = useState<string | null>(null)
    const [lastMintedTokenId, setLastMintedTokenId] = useState<string | null>(null)

    // Contract writing for baking a cake (minting NFT)
    const {
        data: bakeCakeHash,
        isPending: isBakePending,
        error: bakeCakeError,
        writeContractAsync: writeBakeCakeAsync,
    } = useWriteContract()

    // Transaction receipt for cake baking
    const {
        isLoading: isBakeConfirming,
        isSuccess: isBakeConfirmed,
        isError: isBakeError,
        data: dataFromBakeReceipt,
    } = useWaitForTransactionReceipt({
        confirmations: 1,
        hash: bakeCakeHash,
    })

    // Read contract for tokenURI
    const {
        data: tokenURIData,
        isLoading: isTokenURILoading,
        error: tokenURIError,
    } = useReadContract({
        abi: cakeAbi,
        address: cakeContractAddress as `0x${string}`,
        functionName: "tokenURI",
        args: [tokenId ? BigInt(tokenId) : undefined],
        query: {
            enabled: !!tokenId,
        },
    })

    // Function to bake a cake (mint NFT)
    async function handleBakeCake() {
        try {
            const txHash = await writeBakeCakeAsync({
                abi: cakeAbi,
                address: cakeContractAddress as `0x${string}`,
                functionName: "bakeCake",
                args: [],
            })
            console.log("Bake cake transaction submitted:", txHash)
        } catch (error) {
            console.error("Error baking cake:", error)
        }
    }

    // Function to fetch all NFTs owned by this wallet
    async function fetchMyNFTs() {
        // Logic to fetch NFTs owned by the wallet
        // This is left blank as requested
        console.log("Fetching NFTs for address:", account.address)

        // Mock implementation - would be replaced with actual logic
        setMyTokenIds(["Sample implementation - Replace with actual NFT fetching logic"])
    }

    // Effect to process tokenURI data when it changes
    useEffect(() => {
        if (tokenURIData && !isTokenURILoading) {
            const fetchMetadata = async () => {
                try {
                    // Handle both HTTP and IPFS URIs
                    const uri = tokenURIData as string
                    let url = uri

                    const response = await fetch(url)
                    const metadata = await response.json()

                    // Get image URL from metadata
                    let imageUrl = metadata.image

                    setNftImageUrl(imageUrl)
                } catch (error) {
                    console.error("Error fetching metadata:", error)
                }
            }

            fetchMetadata()
        }
    }, [tokenURIData, isTokenURILoading])

    // Effect to persist input values in localStorage
    useEffect(() => {
        const savedTokenId = localStorage.getItem("nftTokenId")
        if (savedTokenId) setTokenId(savedTokenId)
    }, [])

    useEffect(() => {
        localStorage.setItem("nftTokenId", tokenId)
    }, [tokenId])

    // Effect to track the minted NFT from transaction receipt
    useEffect(() => {
        console.dir(dataFromBakeReceipt)
        if (isBakeConfirmed && bakeCakeHash) {
            const hexTokenIdFromReceipt = dataFromBakeReceipt.logs[1].topics[1]
            const intTokenIdFromReceipt = parseInt(hexTokenIdFromReceipt!, 16)
            setLastMintedTokenId(`TokenID: ${intTokenIdFromReceipt}`)
        }
    }, [isBakeConfirmed, bakeCakeHash])

    // Helper function for button content
    function getBakeCakeButtonContent() {
        if (isBakePending)
            return (
                <div className="flex items-center justify-center gap-2 w-full">
                    <CgSpinner className="animate-spin" size={20} />
                    <span>Confirming in wallet...</span>
                </div>
            )
        if (isBakeConfirming)
            return (
                <div className="flex items-center justify-center gap-2 w-full">
                    <CgSpinner className="animate-spin" size={20} />
                    <span>Baking your cake NFT...</span>
                </div>
            )
        if (bakeCakeError || isBakeError) {
            console.log(bakeCakeError)
            return (
                <div className="flex items-center justify-center gap-2 w-full">
                    <span>Error baking cake, see console.</span>
                </div>
            )
        }
        if (isBakeConfirmed) {
            return "Cake NFT baked successfully!"
        }
        return (
            <div className="flex items-center justify-center gap-2">
                <RiCakeLine size={20} />
                <span>Bake a Cake NFT</span>
            </div>
        )
    }

    return (
        <div className="max-w-2xl min-w-full xl:min-w-lg w-full lg:mx-auto p-6 flex flex-col gap-6 bg-white rounded-xl ring-[4px] border-2 border-pink-500 ring-pink-500/25">
            <div className="flex items-center justify-between">
                <h2 className="text-xl font-semibold text-zinc-900">Cake NFT Bakery</h2>
            </div>

            <div className="space-y-6">
                <div className="bg-white border border-zinc-300 rounded-lg p-4">
                    <h3 className="text-sm font-medium text-zinc-900 mb-3">Bake a New Cake NFT</h3>

                    <button
                        className="cursor-pointer flex items-center justify-center w-full py-3 rounded-[9px] text-white transition-colors font-semibold relative border bg-pink-500 hover:bg-pink-600 border-pink-500"
                        onClick={handleBakeCake}
                        disabled={isBakePending || isBakeConfirming}
                    >
                        {/* Gradient */}
                        <div className="absolute w-full inset-0 bg-gradient-to-b from-white/25 via-80% to-transparent mix-blend-overlay z-10 rounded-lg" />
                        {/* Inner shadow */}
                        <div className="absolute w-full inset-0 mix-blend-overlay z-10 inner-shadow rounded-lg" />
                        {/* White inner border */}
                        <div className="absolute w-full inset-0 mix-blend-overlay z-10 border-[1.5px] border-white/20 rounded-lg" />
                        {getBakeCakeButtonContent()}
                    </button>

                    {lastMintedTokenId && (
                        <div className="mt-4 p-3 bg-green-50 border border-green-200 rounded-lg">
                            <p className="text-sm text-green-700">
                                <span className="font-medium">Successfully minted!</span>
                                <br />
                                {lastMintedTokenId}
                            </p>
                        </div>
                    )}
                </div>

                {/* Section 3: Show NFT by tokenId */}
                <div className="bg-white border border-zinc-300 rounded-lg p-4">
                    <h3 className="text-sm font-medium text-zinc-900 mb-3">View an NFT</h3>

                    <div className="flex gap-3">
                        <div className="flex-grow">
                            <InputForm
                                label="Token ID"
                                placeholder="Enter token ID"
                                value={tokenId}
                                onChange={e => setTokenId(e.target.value)}
                            />
                        </div>
                    </div>

                    {nftImageUrl && (
                        <div className="mt-4">
                            <div className="overflow-hidden rounded-lg border border-zinc-200">
                                <img
                                    src={nftImageUrl}
                                    alt={`NFT #${tokenId}`}
                                    className="w-full h-auto max-h-96 object-contain bg-zinc-50"
                                    onError={() => {
                                        console.error("Error loading NFT image")
                                    }}
                                />
                            </div>
                            <p className="text-sm text-zinc-500 mt-2 text-center">
                                NFT #{tokenId}
                            </p>
                        </div>
                    )}

                    {tokenURIError && (
                        <div className="mt-4 p-3 bg-red-50 border border-red-200 rounded-lg">
                            <p className="text-sm text-red-700">
                                <span className="font-medium">Error:</span> Could not find NFT with
                                this token ID
                            </p>
                        </div>
                    )}
                </div>
            </div>
        </div>
    )
}
