"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g = Object.create((typeof Iterator === "function" ? Iterator : Object).prototype);
    return g.next = verb(0), g["throw"] = verb(1), g["return"] = verb(2), typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.fund = fund;
exports.getBalance = getBalance;
exports.withdraw = withdraw;
var viem_1 = require("viem");
require("viem/window");
var constants_ts_1 = require("./constants-ts");
var connectButton = document.getElementById("connectButton");
var fundButton = document.getElementById("fundButton");
var balanceButton = document.getElementById("balanceButton");
var withdrawButton = document.getElementById("withdrawButton");
var ethAmountInput = document.getElementById("ethAmount");
var walletClient;
var publicClient;
function connect() {
    return __awaiter(this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    if (!(typeof window.ethereum !== "undefined")) return [3 /*break*/, 2];
                    walletClient = (0, viem_1.createWalletClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    return [4 /*yield*/, walletClient.requestAddresses()];
                case 1:
                    _a.sent();
                    connectButton.innerHTML = "Connected";
                    return [3 /*break*/, 3];
                case 2:
                    connectButton.innerHTML = "Please install MetaMask";
                    _a.label = 3;
                case 3: return [2 /*return*/];
            }
        });
    });
}
function fund() {
    return __awaiter(this, void 0, void 0, function () {
        var ethAmount, addresses, account, currentChain, request, hash, error_1;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    ethAmount = ethAmountInput.value;
                    console.log("Funding with ".concat(ethAmount, "..."));
                    if (!(typeof window.ethereum !== "undefined")) return [3 /*break*/, 8];
                    _a.label = 1;
                case 1:
                    _a.trys.push([1, 6, , 7]);
                    walletClient = (0, viem_1.createWalletClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    return [4 /*yield*/, walletClient.requestAddresses()];
                case 2:
                    addresses = _a.sent();
                    account = addresses[0];
                    return [4 /*yield*/, getCurrentChain(walletClient)];
                case 3:
                    currentChain = _a.sent();
                    console.log("Processing transaction...");
                    publicClient = (0, viem_1.createPublicClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    return [4 /*yield*/, publicClient.simulateContract({
                            address: constants_ts_1.contractAddress,
                            abi: constants_ts_1.abi,
                            functionName: "fund",
                            account: account,
                            chain: currentChain,
                            value: (0, viem_1.parseEther)(ethAmount),
                        })];
                case 4:
                    request = (_a.sent()).request;
                    return [4 /*yield*/, walletClient.writeContract(request)];
                case 5:
                    hash = _a.sent();
                    console.log("Transaction processed: ", hash);
                    return [3 /*break*/, 7];
                case 6:
                    error_1 = _a.sent();
                    console.error(error_1);
                    return [3 /*break*/, 7];
                case 7: return [3 /*break*/, 9];
                case 8:
                    fundButton.innerHTML = "Please install MetaMask";
                    _a.label = 9;
                case 9: return [2 /*return*/];
            }
        });
    });
}
function getBalance() {
    return __awaiter(this, void 0, void 0, function () {
        var balance, error_2;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    if (!(typeof window.ethereum !== "undefined")) return [3 /*break*/, 5];
                    _a.label = 1;
                case 1:
                    _a.trys.push([1, 3, , 4]);
                    publicClient = (0, viem_1.createPublicClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    return [4 /*yield*/, publicClient.getBalance({
                            address: constants_ts_1.contractAddress,
                        })];
                case 2:
                    balance = _a.sent();
                    console.log((0, viem_1.formatEther)(balance));
                    return [3 /*break*/, 4];
                case 3:
                    error_2 = _a.sent();
                    console.error(error_2);
                    return [3 /*break*/, 4];
                case 4: return [3 /*break*/, 6];
                case 5:
                    balanceButton.innerHTML = "Please install MetaMask";
                    _a.label = 6;
                case 6: return [2 /*return*/];
            }
        });
    });
}
function withdraw() {
    return __awaiter(this, void 0, void 0, function () {
        var addresses, account, currentChain, request, hash, error_3;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    console.log("Withdrawing...");
                    if (!(typeof window.ethereum !== "undefined")) return [3 /*break*/, 8];
                    _a.label = 1;
                case 1:
                    _a.trys.push([1, 6, , 7]);
                    walletClient = (0, viem_1.createWalletClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    publicClient = (0, viem_1.createPublicClient)({
                        transport: (0, viem_1.custom)(window.ethereum),
                    });
                    return [4 /*yield*/, walletClient.requestAddresses()];
                case 2:
                    addresses = _a.sent();
                    account = addresses[0];
                    return [4 /*yield*/, getCurrentChain(walletClient)];
                case 3:
                    currentChain = _a.sent();
                    console.log("Processing transaction...");
                    return [4 /*yield*/, publicClient.simulateContract({
                            account: account,
                            address: constants_ts_1.contractAddress,
                            abi: constants_ts_1.abi,
                            functionName: "withdraw",
                            chain: currentChain,
                        })];
                case 4:
                    request = (_a.sent()).request;
                    return [4 /*yield*/, walletClient.writeContract(request)];
                case 5:
                    hash = _a.sent();
                    console.log("Transaction processed: ", hash);
                    return [3 /*break*/, 7];
                case 6:
                    error_3 = _a.sent();
                    console.error(error_3);
                    return [3 /*break*/, 7];
                case 7: return [3 /*break*/, 9];
                case 8:
                    withdrawButton.innerHTML = "Please install MetaMask";
                    _a.label = 9;
                case 9: return [2 /*return*/];
            }
        });
    });
}
function getCurrentChain(client) {
    return __awaiter(this, void 0, void 0, function () {
        var chainId, currentChain;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, client.getChainId()];
                case 1:
                    chainId = _a.sent();
                    currentChain = (0, viem_1.defineChain)({
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
                    return [2 /*return*/, currentChain];
            }
        });
    });
}
// Attach event listeners
connectButton.onclick = connect;
fundButton.onclick = fund;
balanceButton.onclick = getBalance;
withdrawButton.onclick = withdraw;
