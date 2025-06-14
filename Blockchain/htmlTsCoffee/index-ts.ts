import {
  createWalletClient,
  custom,
  formatEther,
  parseEther,
  defineChain,
  createPublicClient,
  type WalletClient,
  type PublicClient,
} from "viem";
import "viem/window";
import { abi, contractAddress } from "./constants-ts";

const connectButton = document.getElementById("connectButton") as HTMLButtonElement;
const fundButton = document.getElementById("fundButton") as HTMLButtonElement;
const balanceButton = document.getElementById("balanceButton") as HTMLButtonElement;
const withdrawButton = document.getElementById("withdrawButton") as HTMLButtonElement;
const ethAmountInput = document.getElementById("ethAmount") as HTMLInputElement;
const addressAmountFundedInput = document.getElementById("addressamountfundedButton") as HTMLButtonElement;
const addressQueryInput = document.getElementById("addressQuery") as HTMLInputElement;

let walletClient: WalletClient;
let publicClient: PublicClient;

async function connect(): Promise<void> {
  if (typeof window.ethereum !== "undefined") {
    walletClient = createWalletClient({
      transport: custom(window.ethereum),
    });
    await walletClient.requestAddresses();
    connectButton.innerHTML = "Connected";
  } else {
    connectButton.innerHTML = "Please install MetaMask";
  }
}

export async function fund(): Promise<void> {
  const ethAmount: string = ethAmountInput.value;
  console.log(`Funding with ${ethAmount}...`);

  if (typeof window.ethereum !== "undefined") {
    try {
      walletClient = createWalletClient({
        transport: custom(window.ethereum),
      });
      const addresses = await walletClient.requestAddresses();
      const account = addresses[0] as `0x${string}`;
      const currentChain = await getCurrentChain(walletClient);

      console.log("Processing transaction...");
      publicClient = createPublicClient({
        transport: custom(window.ethereum),
      });
      const { request } = await publicClient.simulateContract({
        address: contractAddress,
        abi,
        functionName: "fund",
        account,
        chain: currentChain,
        value: parseEther(ethAmount),
      });
      const hash = await walletClient.writeContract(request);
      console.log("Transaction processed: ", hash);
    } catch (error) {
      console.error(error);
    }
  } else {
    fundButton.innerHTML = "Please install MetaMask";
  }
}

export async function getBalance(): Promise<void> {
  if (typeof window.ethereum !== "undefined") {
    try {
      publicClient = createPublicClient({
        transport: custom(window.ethereum),
      });
      const balance = await publicClient.getBalance({
        address: contractAddress,
      });
      console.log(formatEther(balance));
    } catch (error) {
      console.error(error);
    }
  } else {
    balanceButton.innerHTML = "Please install MetaMask";
  }
}

export async function withdraw(): Promise<void> {
  console.log("Withdrawing...");

  if (typeof window.ethereum !== "undefined") {
    try {
      walletClient = createWalletClient({
        transport: custom(window.ethereum),
      });
      publicClient = createPublicClient({
        transport: custom(window.ethereum),
      });
      const addresses = await walletClient.requestAddresses();
      const account = addresses[0] as `0x${string}`;
      const currentChain = await getCurrentChain(walletClient);

      console.log("Processing transaction...");
      const { request } = await publicClient.simulateContract({
        account,
        address: contractAddress,
        abi,
        functionName: "withdraw",
        chain: currentChain,
      });
      const hash = await walletClient.writeContract(request);
      console.log("Transaction processed: ", hash);
    } catch (error) {
      console.error(error);
    }
  } else {
    withdrawButton.innerHTML = "Please install MetaMask";
  }
}

async function getCurrentChain(
  client: WalletClient
): Promise<ReturnType<typeof defineChain>> {
  const chainId = await client.getChainId();
  const currentChain = defineChain({
    id: chainId,
    name: "Custom Chain",
    nativeCurrency: {
      name: "Ether",
      symbol: "ETH",
      decimals: 18,
    },
    rpcUrls: {
      default: {
        http: ["http://localhost:8545"],
      },
    },
  });
  return currentChain;
}

async function addressAmountFunded(): Promise<void> {
  const addressToQuery = addressQueryInput.value;
  console.log("Fetching address amount funded...");
  if (typeof window.ethereum !== "undefined") {
    try {
      publicClient = createPublicClient({
        transport: custom(window.ethereum),
      });
      const data = await publicClient.readContract({
        address: contractAddress,
        abi,
        functionName: "getAddressToAmountFunded",
        args: [addressToQuery],
      });
      console.log(formatEther(data as bigint));
    } catch (error) {
      console.error(error);
    }
  } else {
    fundButton.innerHTML = "Please install MetaMask";
  }
}

// Attach event listeners
connectButton.onclick = connect;
fundButton.onclick = fund;
balanceButton.onclick = getBalance;
withdrawButton.onclick = withdraw;
addressAmountFundedInput.onclick = addressAmountFunded;
