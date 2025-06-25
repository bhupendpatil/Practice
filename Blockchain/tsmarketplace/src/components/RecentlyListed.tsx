import { useQuery } from "@tanstack/react-query"
import { useMemo } from "react"
import NFTBox from "./NFTBox"
import Link from "next/link"

// Define types for your GraphQL response
interface NFTItem {
    rindexerId: number
    seller: string
    nftAddress: string
    tokenId: string
    price: string
    blockNumber: number
    txHash: string
    contractAddress: string
}

interface BoughtCanceledItem {
    nftAddress: string
    tokenId: string
}

interface NFTQueryResponse {
    data: {
        allItemListeds: {
            nodes: NFTItem[]
        }
        allItemBoughts: {
            nodes: BoughtCanceledItem[]
        }
        allItemCanceleds: {
            nodes: BoughtCanceledItem[]
        }
    }
}

// Type for the extracted NFT data
interface NFTData {
    tokenId: string
    contractAddress: string
    price: string
}

// GraphQL query as a string
const GET_RECENT_NFTS = `
  query GetRecentlyListedNFTs {
    allItemListeds(
      first: 20,
      orderBy: [BLOCK_NUMBER_DESC, TX_INDEX_DESC, LOG_INDEX_DESC]
    ) {
      nodes {
        rindexerId
        seller
        nftAddress
        tokenId
        price
        contractAddress
        blockNumber
        txHash
      }
    }
    
    allItemBoughts {
      nodes {
        nftAddress
        tokenId
      }
    }
    
    allItemCanceleds {
      nodes {
        nftAddress
        tokenId
      }
    }
  }
`

// Function to fetch data from GraphQL API
async function fetchNFTs(): Promise<NFTQueryResponse> {
    const response = await fetch("/api/graphql", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            query: GET_RECENT_NFTS,
        }),
    })

    if (!response.ok) {
        throw new Error("Network response was not ok")
    }

    return response.json()
}

// Custom hook for fetching and processing NFT data
function useRecentlyListedNFTs() {
    const { data, isLoading, error } = useQuery<NFTQueryResponse>({
        queryKey: ["recentNFTs"],
        queryFn: fetchNFTs,
    })

    // Use useMemo to avoid reprocessing data when it hasn't changed
    const nftDataList = useMemo(() => {
        if (!data) return []

        // Create sets of bought and canceled NFTs for quick lookup
        const boughtNFTs = new Set<string>()
        const canceledNFTs = new Set<string>()

        data.data.allItemBoughts.nodes.forEach(item => {
            if (item.nftAddress && item.tokenId) {
                boughtNFTs.add(`${item.nftAddress}-${item.tokenId}`)
            }
        })

        data.data.allItemCanceleds.nodes.forEach(item => {
            if (item.nftAddress && item.tokenId) {
                canceledNFTs.add(`${item.nftAddress}-${item.tokenId}`)
            }
        })

        // Filter listed NFTs to only include those that haven't been bought or canceled
        const availableNFTs = data.data.allItemListeds.nodes.filter(item => {
            if (!item.nftAddress || !item.tokenId) return false

            const key = `${item.nftAddress}-${item.tokenId}`
            return !boughtNFTs.has(key) && !canceledNFTs.has(key)
        })

        // Get the top 5
        const recentNFTs = availableNFTs.slice(0, 100)

        // Extract the specific data we need
        return recentNFTs.map(nft => ({
            tokenId: nft.tokenId,
            contractAddress: nft.nftAddress,
            price: nft.price,
        }))
    }, [data])

    return { isLoading, error, nftDataList }
}

// Main component that uses the custom hook
export default function RecentlyListedNFTs() {
    const { isLoading, error, nftDataList } = useRecentlyListedNFTs()

    if (isLoading) return <p>Loading...</p>
    if (error) return <p>Error: {error.message}</p>

    return (
        <div className="container mx-auto px-4 py-8">
            <div className="mt-8 text-center">
                <Link
                    href="/list-nft"
                    className="inline-block py-2 px-4 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
                >
                    List Your NFT
                </Link>
            </div>
            <h2 className="text-2xl font-bold mb-6">Recently Listed NFTs</h2>

            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-6 gap-4">
                {nftDataList.map(nft => (
                    <Link
                        key={`${nft.contractAddress}-${nft.tokenId}`}
                        href={`/buy-nft/${nft.contractAddress}/${nft.tokenId}`}
                        className="block transform transition hover:scale-105"
                    >
                        <NFTBox
                            key={`${nft.contractAddress}-${nft.tokenId}`}
                            tokenId={nft.tokenId}
                            contractAddress={nft.contractAddress}
                            price={nft.price}
                        />
                    </Link>
                ))}
            </div>

            {nftDataList.length === 0 && (
                <p className="text-center text-gray-500 my-12">No NFTs currently listed</p>
            )}
        </div>
    )
}

// If you want to export the hook for use in other components
export { useRecentlyListedNFTs }