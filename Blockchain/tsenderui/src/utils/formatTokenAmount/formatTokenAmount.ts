export function formatTokenAmount(weiAmount: number, decimals: number): string {
  const tokenAmount = weiAmount / Math.pow(10, decimals);
  return tokenAmount.toLocaleString(undefined, {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  });
}
