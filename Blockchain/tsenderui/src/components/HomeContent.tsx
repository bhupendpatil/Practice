"use client";

import { useState } from "react";
import AirdropForm from "@/components/AirdropForm";
import { useAccount } from "wagmi";

export default function HomeContent() {
  const [isUnsafeMode, setIsUnsafeMode] = useState(false);
  const { isConnected } = useAccount();

  return (
    <main>
      {!isConnected ? (
        <div className="flex items-center justify-center">
          <h2 className="text-xl font-medium text-zinc-600">
            Please connect a wallet...
          </h2>
        </div>
      ) : (
        <div className="flex items-center justify-center p-4 md:p-6 xl:p-8">
          <AirdropForm
            isUnsafeMode={isUnsafeMode}
            onModeChange={setIsUnsafeMode}
          />
        </div>
      )}
    </main>
  );
}
