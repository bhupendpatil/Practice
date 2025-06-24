import { describe, it, expect } from "vitest"
import { formatTokenAmount } from "./formatTokenAmount"

describe("formatTokenAmount", () => {
    it("formats whole numbers correctly", () => {
        expect(formatTokenAmount(1000000000000000000, 18)).toBe("1.00")
    })

    it("handles different decimal places", () => {
        expect(formatTokenAmount(1234000000, 6)).toBe("1,234.00")
    })

    it("handles small numbers", () => {
        expect(formatTokenAmount(100, 18)).toBe("0.00")
    })

    it("handles zero", () => {
        expect(formatTokenAmount(0, 18)).toBe("0.00")
    })

    it("handles large numbers with commas", () => {
        expect(formatTokenAmount(1234000000000000000000, 18)).toBe("1,234.00")
    })

    it("respects decimal precision", () => {
        // For a 6 decimal token like USDC
        expect(formatTokenAmount(1234567, 6)).toBe("1.23")
    })
})
