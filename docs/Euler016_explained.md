# Euler016 — Power digit sum (2^n)

Compute the sum of digits of 2^n.

## Problem statement

Given n ≥ 0, compute S(n) = sum of decimal digits of 2^n.

## Step-by-step reasoning

1) Exact power computation
- Use BigInteger: `BigInteger.ONE.shiftLeft(n)` or `BigInteger.valueOf(2).pow(n)` to compute 2^n exactly.

2) Sum digits
- Convert to string and accumulate `c - '0'`, or repeatedly divide by 10 using `divideAndRemainder` to avoid building the whole string.

3) Complexity
- O(d) where d ≈ n·log10(2) is the number of digits; memory O(d) if using strings.

4) Edge cases
- n=0 → 1 → sum=1.
- Very large n → prefer divideAndRemainder to reduce peak memory.

5) Testing mindset
- Small checks: n=0→1; n=15→32768→sum=3+2+7+6+8=26; Euler asks n=1000.

## Reusable template (for similar problems)

When summing digits of huge exact integers:
- Compute the value with BigInteger or chunked arrays; avoid floating point.
- Extract digits via string or repeated mod/div by base.

## Practical examples and business impact

- Checksums for giant identifiers or hashes
  - Derive human-auditable summaries by summing digits.
  - Impact: Lightweight integrity checks without additional systems.

- Auditable reporting of exponential growth metrics
  - Compute exact values and then summarize for dashboards.
  - Impact: Accuracy preserves trust in finance/ops.

## Key takeaways

- BigInteger keeps results exact; digit sum is linear in number length.
- Choose digit extraction method based on memory constraints.
