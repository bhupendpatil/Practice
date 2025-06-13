import {
  createWalletClient,
  custom,
  parseEther,
  defineChain,
  createPublicClient,
  formatEther,
} from "https://esm.sh/viem";
import { coffeeAbi, contractAddress } from "./constants-js.js";

const connectButton = document.getElementById("connectButton");
const fundButton = document.getElementById("fundButton");
const ethAmountInput = document.getElementById("ethAmount");
const balanceButton = document.getElementById("balanceButton");

let walletClient;
let publicClient;

async function connect() {
  if (typeof window.ethereum !== "undefined") {
    walletClient = createWalletClient({
      transport: custom(window.ethereum),
    });
    await walletClient.requestAddresses();
    console.log("Connected to wallet:", await walletClient.getAddresses());
    connectButton.innerText = "Connected";
  } else {
    connectButton.innerText = "Please install MetaMask";
  }
}

async function fund() {
  const ethAmount = ethAmountInput.value;
  console.log(`Funding with ${ethAmount}`);

  if (typeof window.ethereum !== "undefined") {
    walletClient = createWalletClient({
      transport: custom(window.ethereum),
    });
    const [accountAddress] = await walletClient.requestAddresses();
    const currentChain = await getCurrentChain(walletClient);

    publicClient = createPublicClient({
      transport: custom(window.ethereum),
    });
    const { request } = await publicClient.simulateContract({
      address: contractAddress,
      abi: coffeeAbi,
      functionName: "fund",
      account: accountAddress,
      chain: currentChain,
      value: parseEther(ethAmount),
    });
    const hash = await walletClient.writeContract(request);
    console.log(hash);
  } else {
    connectButton.innerText = "Please install MetaMask";
  }
}

async function getCurrentChain(client) {
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
        http: ["http://127.0.0.1:8545"],
      },
    },
  });
  return currentChain;
}

async function getBalance() {
  if (typeof window.ethereum !== "undefined") {
    publicClient = createPublicClient({
      transport: custom(window.ethereum),
    });
    const balance = await publicClient.getBalance({
      address: contractAddress,
    });
    console.log(formatEther(balance));
  }
}

connectButton.onclick = connect;
fundButton.onclick = fund;
balanceButton.onclick = getBalance;
