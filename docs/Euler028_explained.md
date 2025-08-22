# Euler028 — Number spiral diagonals

## Problem statement

Sum the numbers on both diagonals in an n×n spiral formed by starting at 1 in the center and moving to the right in a clockwise spiral (n is odd).

## Step-by-step reasoning

## Approach

Sum per-layer spiral corner contributions using closed-form 4s^2 − 6(s−1) over layers up to radius (n−1)/2; add center 1.

1) Corner formula per layer
- For layer k with side length s = 2k + 1, the four corner values sum to 4s^2 − 6(s − 1).

2) Sum across layers
- For n = 2m + 1, total = 1 + Σ_{k=1..m} [4(2k+1)^2 − 6·(2k)]. This yields an O(m) loop, or a closed-form polynomial if desired.

3) Complexity
- O(m) arithmetic, m ≈ n/2. Negligible cost for typical n.

## Complexity

- Time: O(n) with small constant (≈ n/2 iterations) or O(1) if further algebraically simplified.
- Space: O(1).

## Edge Cases

- Even n: Spiral definition assumes odd n; decide to reject or adjust (nearest odd).
- n = 1: Sum is 1; loop should skip gracefully.
- Overflow: For very large n, corner formula values exceed 32-bit; use long or BigInteger if scaling beyond Euler range.
- Closed-form correctness: Algebraic simplification errors can silently skew results; keep tested iterative fallback.
- Input validation: Negative or zero n invalid; guard early.

## Reusable template (for layered grid sums)

- Identify layer-wise patterns and express per-layer contribution.
- Sum contributions rather than simulating the whole grid.
- Optionally algebraically simplify to a polynomial.

## Practical examples and business impact

- Structured data analytics: when values follow a pattern, compute aggregates analytically instead of iterating all cells.
- Performance: Avoids O(n^2) grid work by exploiting geometry.

## Key Takeaways

- Use the corner formula per layer; summing layers is simple and precise.

## Java implementation (Euler028.java)

We accumulate corner values layer by layer.

- Core: `diagonalSum(int n)` maintains `current` and adds four corners per layer with step = 2·layer.
- Start from sum=1 at the center; loop layer=1..(n-1)/2 and add four corners each time.
- CLI reads odd n (default 1001) and prints the diagonal sum.
