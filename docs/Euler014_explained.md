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

## Java implementation (Euler014.java)

We compute Collatz lengths with memoization using two caches and careful types.

- Core helper: `collatzLength(long start, int[] cache, HashMap<Long,Integer> bigCache)`
  - Returns the length L(start).
  - If `start < cache.length` and `cache[start] != 0`, return cached value.
  - Otherwise, walk the sequence using a `long n` (avoid overflow) and push visited values to an `ArrayList<Long> seen` until you hit 1 or a cached value.
  - Accumulate `steps` during the walk. When stopping, backfill lengths into `cache` (for small values) or `bigCache` (for values ≥ cache.length) by decrementing from the final length.
- Driver: `longestCollatzArgUnder(int limit)`
  - Initializes `int[] cache = new int[limit+1]; cache[1] = 1;` and `HashMap<Long,Integer> bigCache`.
  - Loops i = 2..limit-1, computes length via `collatzLength`, tracks the best (longest) start value.
- CLI: `main(String[] args)` defaults `limit = 1_000_000`; optional first arg overrides; prints the start with the longest chain.

Classroom notes:
- Why two caches? `int[] cache` is O(limit) and very fast for small values; `HashMap<Long,Integer>` safely stores lengths for transient large values that appear during sequences (e.g., 3n+1 may exceed limit).
- Why `long` in the sequence variable? The sequence can exceed `Integer.MAX_VALUE` before coming down; `long` prevents overflow.
- Backfilling: When you know the terminal length, assign lengths to each visited node in reverse order so future queries end quickly.
