# Euler014 — Longest Collatz sequence under N

For each starting number < N, compute the Collatz chain length; return the start with the longest chain.

## Problem statement

Given a positive integer N, for each 1 ≤ s < N compute the Collatz sequence length L(s) (steps to reach 1 under x→x/2 if even else 3x+1). Return the s with maximal L(s) (if ties, smallest s).

## Step-by-step reasoning

1) Collatz rule and length
- Define f(x) = x/2 if even, else 3x+1. Length L(1)=1; L(x)=1+L(f(x)).

2) Memoization to avoid recomputation
- Use a map/array to cache L(x). While walking from s, store the visited sequence; when a cached x is found, back-propagate lengths to all visited nodes.
- Use long during iteration to prevent overflow in 3x+1 even if s fits in int.

3) Implementation outline
- Pre-seed cache with L(1)=1.
- For s in [1..N): compute length with memoization; update best.

4) Complexity
- With memoization, nearly O(N) amortized; each x’s length is computed once.

5) Edge cases
- Ensure no negative/zero inputs; N=1 → no candidates; define return accordingly (often 1).
- Cap long if needed; for Euler bounds, 64-bit is safe.

6) Testing mindset
- Spot check: N=10 → longest at 9.
- Validate memo hits by counting cache size vs N.

## Reusable template (for similar problems)

For iterative processes with overlapping subproblems:
- Define the recurrence for the cost/length.
- Cache results; when traversing from a start, stop at first cached node and backfill.
- Use wider types for intermediate states.

## Practical examples and business impact

- Workflow DAGs with repeated subpaths
  - Memoize path lengths/costs to avoid recomputing shared tails.
  - Impact: Large speedups in schedulers and ETL planners.

- Caching in rule engines
  - Many rules reduce to previously seen states; cache to short-circuit evaluation.
  - Impact: Lower latency and compute cost.

## Key takeaways

- Memoization turns a heavy brute-force loop into near-linear time.
- Use 64-bit for intermediate values; backfill lengths to reuse work.
