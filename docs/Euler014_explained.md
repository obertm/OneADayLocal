# Euler014 — Longest Collatz sequence under N

For each starting number < N, compute the Collatz chain length; return the start with the longest chain.

## Approach to replicate

1) Collatz rule
- If x is even → x/2; else → 3x+1; repeat until x = 1.

2) Memoization
- Cache computed lengths for visited x to avoid recomputation.
- While walking a chain, store sequence in a list; when a cached value is found, back-propagate lengths.

3) Implementation details
- Use `long` while iterating to avoid overflow of `3x+1`.
- A hash map or array (if bounds known) for memo; seed with length(1) = 1.

4) Complexity
- With memoization, near O(N) amortized; without memo, can be much slower.

## Real-world analogues and impact
- Path compression and caching in workflows (e.g., dependency pipelines).
  - Impact: Big speedups by reusing partial results.

## Takeaways
- Memoize chain lengths; use 64-bit arithmetic during iteration.
