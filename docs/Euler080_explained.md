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
