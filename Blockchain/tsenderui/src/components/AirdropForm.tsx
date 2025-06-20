"use client";

import { InputForm } from "@/components/ui/InputField";
import { useState } from "react";

export default function AirdropForm() {
    const [tokenAddress, setTokenAddress] = useState("")

    return (
        <div>
            <InputForm label="token address" placeholder="0x" value={tokenAddress} onChange={e => setTokenAddress(e.target.value)} />
        </div>
    )
}