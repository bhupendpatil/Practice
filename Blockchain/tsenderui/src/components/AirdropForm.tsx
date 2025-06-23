"use client";

import { InputForm } from "@/components/ui/InputField";
import { useState } from "react";
import { chainsToTSender, erc20Abi } from "@/constants";
import { useChainId, useConfig, useAccount } from "wagmi";
import { readContract } from "@wagmi/core";

export default function AirdropForm() {
  const [tokenAddress, setTokenAddress] = useState("");
  const [recipient, setRecipient] = useState("");
  const [amounts, setAmounts] = useState("");
  const chainId = useChainId();
  const config = useConfig();
  const account = useAccount();

  async function getApprovedAmount(tSenderAddress: string | null): Promise<number> {
        if (!tSenderAddress) {
            alert("This chain only has the safer version!")
            return 0
        }
        const response = await readContract(config, {
            abi: erc20Abi,
            address: tokenAddress as `0x${string}`,
            functionName: "allowance",
            args: [account.address, tSenderAddress as `0x${string}`],
        })
        return response as number
    }

  async function handleSubmit() {
    // 1. Approve our tsender conrtract to send our token
    // 1a. If already approved, move to step 2
    // 2. Call the airdrop function on the tsender contract
    // 3. Wait for the transaction to be mined
    const tSenderAddress = chainsToTSender[chainId]["tsender"];
    const approvedAmount = await getApprovedAmount(tSenderAddress);
    console.log("Approved Amount:", approvedAmount);
  }

  return (
    <div>
      <InputForm
        label="Token Address"
        placeholder="0x"
        value={tokenAddress}
        onChange={(e) => setTokenAddress(e.target.value)}
      />
      <InputForm
        label="Recipientx Address"
        placeholder="0x,0x"
        value={recipient}
        onChange={(e) => setRecipient(e.target.value)}
        large={true}
      />
      <InputForm
        label="Amount"
        placeholder="100,100,100"
        value={amounts}
        onChange={(e) => setAmounts(e.target.value)}
        large={true}
      />
      <button
        className="mt-4 bg-blue-500 text-white px-4 py-2 rounded"
        onClick={() => {
          // Handle airdrop logic here
          handleSubmit();
        }}
      >
        Send Tokens
      </button>
    </div>
  );
}
