# Euler080 — Square root digital expansion

For N=1..100, sum the first 100 decimal digits of √N for non-square N.

## Approach

- Use digit-by-digit square root (long-hand) algorithm to compute 100 digits per N, or use BigDecimal with MathContext of 110+ digits and then parse the first 100 fractional digits.
- Sum digits across all non-square N.

## Edge Cases
- Perfect squares: Must skip to avoid counting integer roots (they have fewer than required fractional digits considered zero-padding—problem says skip).
- Precision: Ensure at least 100 fractional digits; with BigDecimal use context > 100 to avoid rounding deficiencies; with integer scaling multiply by 10^(2*digits).
- Leading zeros in fraction: They count toward the 100 digits; ensure no trimming of leading fractional zeros.
- Performance: 100 iterations trivial; avoid O(n^2) algorithms for large precision (not needed here).
- BigInteger isqrt: Converge guarantee; ensure final correction step that root^2 ≤ N < (root+1)^2.

## Complexity
- O(100×100) digit operations using the long-hand method; BigDecimal also fine.

## Real-world analogues and impact
- High-precision decimal expansion without floating error.
  - Impact: Exact digit extraction for numeric analysis tasks.

## Key Takeaways
- Implement long-division sqrt or high-precision BigDecimal; sum first 100 digits for each non-square.

## Java implementation (Euler080.java)
- Skips perfect squares quickly using integer sqrt check.
- Uses the classical longhand (digit-by-digit) square root extraction in base 100 (pairing digits) to generate exactly the first 100 digits (integer part + 99 fractional) of √n without floating point or rounding concerns.
- For each iteration: bring down next two-digit pair (or 00 after the integer part), find the largest digit x such that (20*partialRoot + x)*x ≤ remainder, subtract, append x to the root, and add x to the running digit sum.
- Repeat for 100 digits per non-square n; accumulate the digit sums.
- Output: the total sum for all non-squares in 1..100 (expected answer 40886).
- Complexity: 100 iterations × ~100 numbers = 10,000 small BigInteger operations (fast).
