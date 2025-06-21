"use client";

import { InputForm } from "@/components/ui/InputField";
import { useState } from "react";

export default function AirdropForm() {
  const [tokenAddress, setTokenAddress] = useState("");
  const [recipient, setRecipient] = useState("");
  const [amounts, setAmounts] = useState("");

  async function handleSubmit() {
    console.log("Airdrop initiated", { tokenAddress, recipient, amounts });
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
