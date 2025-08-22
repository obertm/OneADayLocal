# Euler025 — 1000-digit Fibonacci index

## Problem statement

Find the index of the first Fibonacci number that contains at least D digits. In the Euler problem, D = 1000.

## Step-by-step reasoning

## Approach

Iteratively build Fibonacci numbers with BigInteger until reaching the digit threshold; optional logarithmic estimate for starting near target.

1) BigInteger iteration
- Generate Fibonacci numbers F1=1, F2=1, then repeat F(n+1)=F(n)+F(n-1) until the number of digits ≥ D.

2) Early estimate (optional)
- Using Binet’s formula, digits(F_n) ≈ floor(n·log10(φ) − log10(√5)) + 1. You can estimate n and then adjust with a short loop. Straight iteration is fast enough here.

## Edge Cases

- D = 1: Answer index is 1 (F1=1). Ensure loop accounts for smallest threshold.
- Very large D: Fibonacci index grows linearly with D; memory/time dominated by BigInteger growth; consider logarithmic estimate to jump near target.
- Overflow: Use BigInteger only; int/long overflow quickly for large D.
- Off-by-one: Ensure comparison checks >= D digits, not > D.
- Performance: For huge D, avoid converting to string each iteration by tracking log10 value incrementally; current method fine for Euler scale.

## Reusable template (for monotone threshold problems)

- Define a monotone sequence or function.
- Iterate until crossing a threshold, or binary search if evaluable by index.
- Use big integers if values exceed 64-bit range.

## Practical examples and business impact

- Capacity planning: find when a growing metric (users, rows, storage) exceeds a target.
- Financial projections: determine the period when compounded growth surpasses a threshold.

## Key Takeaways

- Simple BigInteger addition loop solves it cleanly. Log-based estimates are optional accelerators.

## Java implementation (Euler025.java)

We iterate Fibonacci numbers with BigInteger until we reach D digits.

- State: `a=1` (F1), `b=1` (F2), `idx=2`.
- Threshold: `tenPow = 10^(D-1)` as a BigInteger, compare `b` to it.
- Loop: while `b < tenPow`, do `c=a+b; a=b; b=c; idx++`.
- Output: print `idx` when `b` first reaches D digits.
