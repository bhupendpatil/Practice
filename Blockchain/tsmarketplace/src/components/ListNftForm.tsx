// components/ListNftForm.tsx
"use client"

import { useState } from "react"
import {
    useAccount,
    useChainId,
    useWriteContract,
    useReadContract,
    useWaitForTransactionReceipt,
} from "wagmi"
import { parseEther } from "viem"
import { chainsToContracts, nftAbi, marketplaceAbi } from "@/constants"
import NFTBox from "@/components/NFTBox"
import { addDecimalsToPrice } from "../utils/formatPrice"

export default function ListNftForm() {
    const { address } = useAccount()
    const chainId = useChainId()
    const marketplaceAddress =
        (chainsToContracts[chainId]?.nftMarketplace as `0x${string}`) || "0x"

    const [nftAddress, setNftAddress] = useState("")
    const [tokenId, setTokenId] = useState("")
    const [price, setPrice] = useState("")
    const [step, setStep] = useState(1) // 1: Form Input, 2: Preview, 3: Approval, 4: Listing

    // For NFT owner verification
    const { data: ownerData } = useReadContract({
        abi: nftAbi,
        address: nftAddress as `0x${string}`,
        functionName: "ownerOf",
        args: tokenId ? [BigInt(tokenId)] : undefined,
    })

    // For NFT approval
    const {
        data: approvalHash,
        isPending: isApprovalPending,
        writeContract: approveNft,
        error: approvalError,
    } = useWriteContract()

    // For listing NFT
    const {
        data: listingHash,
        isPending: isListingPending,
        writeContract: listNft,
        error: listingError,
    } = useWriteContract()

    // Transaction receipts
    const { isSuccess: isApprovalSuccess } = useWaitForTransactionReceipt({
        hash: approvalHash,
    })

    const { isSuccess: isListingSuccess } = useWaitForTransactionReceipt({
        hash: listingHash,
    })

    // Check if user owns the NFT
    const isOwner = ownerData === address

    if (ownerData && price) {
        if (!isOwner) {
            console.log("You are not the owner, the owner is: ", ownerData)
        } else {
            console.log("You are the owner")
        }
    }

    // Handle form submission to proceed to preview
    const handlePreview = (e: React.FormEvent) => {
        e.preventDefault()
        if (nftAddress && tokenId && price) {
            setStep(2)
        }
    }

    // Handle approve NFT for marketplace
    const handleApprove = async () => {
        if (!nftAddress || !tokenId) return

        try {
            await approveNft({
                abi: nftAbi,
                address: nftAddress as `0x${string}`,
                functionName: "approve",
                args: [marketplaceAddress, BigInt(tokenId)],
            })
            setStep(3)
        } catch (error) {
            console.error("Error approving NFT:", error)
        }
    }

    // Handle list NFT
    const handleList = async () => {
        if (!nftAddress || !tokenId || !price) return

        try {
            const formattedPrice = addDecimalsToPrice(price)
            await listNft({
                abi: marketplaceAbi,
                address: marketplaceAddress,
                functionName: "listItem",
                args: [nftAddress as `0x${string}`, BigInt(tokenId), formattedPrice],
            })
            setStep(4)
        } catch (error) {
            console.error("Error listing NFT:", error)
        }
    }

    return (
        <div className="bg-white rounded-xl shadow-sm border border-zinc-200 p-6">
            {step === 1 && (
                <form onSubmit={handlePreview} className="space-y-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">
                            NFT Contract Address
                        </label>
                        <input
                            type="text"
                            className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-gray-900"
                            placeholder="0x..."
                            value={nftAddress}
                            onChange={e => setNftAddress(e.target.value)}
                            required
                        />
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">
                            Token ID
                        </label>
                        <input
                            type="text"
                            className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-gray-900"
                            placeholder="1"
                            value={tokenId}
                            onChange={e => setTokenId(e.target.value)}
                            required
                        />
                    </div>

                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">
                            Price (USDC)
                        </label>
                        <input
                            type="text"
                            className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-gray-900"
                            placeholder="0.1"
                            value={price}
                            onChange={e => setPrice(e.target.value)}
                            required
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full py-2 px-4 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                    >
                        Preview Listing
                    </button>
                </form>
            )}

            {step === 2 && (
                <div className="space-y-6">
                    <h2 className="text-xl font-semibold">Preview Your Listing</h2>

                    {!isOwner ? (
                        <div className="p-4 bg-red-50 text-red-700 rounded-md">
                            You don&apos;t own this NFT. Please make sure you entered the correct
                            contract address and token ID.
                        </div>
                    ) : (
                        <>
                            <div className="w-64 mx-auto">
                                <NFTBox
                                    tokenId={tokenId}
                                    contractAddress={nftAddress}
                                    price={addDecimalsToPrice(price)}
                                />
                            </div>

                            <div className="flex space-x-4">
                                <button
                                    onClick={() => setStep(1)}
                                    className="flex-1 py-2 px-4 bg-gray-200 text-gray-800 rounded-md hover:bg-gray-300 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2"
                                >
                                    Back
                                </button>
                                <button
                                    onClick={handleApprove}
                                    className="flex-1 py-2 px-4 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                                    disabled={isApprovalPending}
                                >
                                    {isApprovalPending ? "Approving..." : "Approve NFT"}
                                </button>
                            </div>

                            {approvalError && (
                                <div className="p-4 bg-red-50 text-red-700 rounded-md mt-4">
                                    {approvalError.message}
                                </div>
                            )}
                        </>
                    )}
                </div>
            )}

            {step === 3 && (
                <div className="space-y-6">
                    <h2 className="text-xl font-semibold">List Your NFT</h2>

                    {isApprovalSuccess ? (
                        <>
                            <div className="p-4 bg-green-50 text-green-700 rounded-md">
                                Approval successful! You can now list your NFT on the marketplace.
                            </div>

                            <div className="w-64 mx-auto">
                                <NFTBox
                                    tokenId={tokenId}
                                    contractAddress={nftAddress}
                                    price={addDecimalsToPrice(price)}
                                />
                            </div>

                            <button
                                onClick={handleList}
                                className="w-full py-2 px-4 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                                disabled={isListingPending}
                            >
                                {isListingPending ? "Listing..." : "List NFT for Sale"}
                            </button>

                            {listingError && (
                                <div className="p-4 bg-red-50 text-red-700 rounded-md mt-4">
                                    {listingError.message}
                                </div>
                            )}
                        </>
                    ) : (
                        <div className="p-4 bg-blue-50 text-blue-700 rounded-md">
                            Waiting for approval transaction to be confirmed...
                        </div>
                    )}
                </div>
            )}

            {step === 4 && (
                <div className="space-y-6">
                    <h2 className="text-xl font-semibold">NFT Listed</h2>

                    {isListingSuccess ? (
                        <>
                            <div className="p-4 bg-green-50 text-green-700 rounded-md">
                                Your NFT has been successfully listed on the marketplace!
                            </div>

                            <div className="w-64 mx-auto">
                                <NFTBox
                                    tokenId={tokenId}
                                    contractAddress={nftAddress}
                                    price={addDecimalsToPrice(price)}
                                />
                            </div>

                            <div className="flex space-x-4">
                                <button
                                    onClick={() => {
                                        setNftAddress("")
                                        setTokenId("")
                                        setPrice("")
                                        setStep(1)
                                    }}
                                    className="flex-1 py-2 px-4 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                                >
                                    List Another NFT
                                </button>
                            </div>
                        </>
                    ) : (
                        <div className="p-4 bg-blue-50 text-blue-700 rounded-md">
                            Waiting for listing transaction to be confirmed...
                        </div>
                    )}
                </div>
            )}
        </div>
    )
}
