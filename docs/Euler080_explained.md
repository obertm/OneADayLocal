# Euler080 — Square root digital expansion

For N=1..100, sum the first 100 decimal digits of √N for non-square N.

## Approach

- Use digit-by-digit square root (long-hand) algorithm to compute 100 digits per N, or use BigDecimal with MathContext of 110+ digits and then parse the first 100 fractional digits.
- Sum digits across all non-square N.

## Complexity
- O(100×100) digit operations using the long-hand method; BigDecimal also fine.

## Real-world analogues and impact
- High-precision decimal expansion without floating error.
  - Impact: Exact digit extraction for numeric analysis tasks.

## Takeaways
- Implement long-division sqrt or high-precision BigDecimal; sum first 100 digits for each non-square.

## Java implementation (Euler080.java)
- Skips perfect squares quickly using integer sqrt check.
- Scales n by 10^(2·100) and computes the integer square root via a custom BigInteger `isqrt` (Newton iteration). This yields floor(sqrt(n)·10^100) as an integer, so its decimal digits are exactly the integer part plus the first 100 fractional digits.
- Sums all digits of that scaled root and accumulates across n = 1..100.
- Key pieces:
  - `isqrt(BigInteger x)`: Newton’s method with a bit-length based initial guess; ensures g^2 ≤ x before returning.
  - Scale: `scale = 10^(200)`; compute `N = n * scale`, then `s = isqrt(N)` and sum `s.toString()` digits.
- Output: the total sum for all non-squares in 1..100.
- Complexity: dominated by 100 BigInteger square roots at ~O(M^2) word ops per root for M ≈ 200 digits; fast in practice.
