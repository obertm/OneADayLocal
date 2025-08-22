# Euler014 — Longest Collatz sequence under N

For each starting number < N, compute the Collatz chain length; return the start with the longest chain.

## Problem statement

Given a positive integer N, for each 1 ≤ s < N compute the Collatz sequence length L(s) (steps to reach 1 under x→x/2 if even else 3x+1). Return the s with maximal L(s) (if ties, smallest s).

## Step-by-step reasoning

## Approach

Memoize Collatz lengths: for each start s < N follow sequence using 64-bit, stop at first cached value, then backfill computed lengths; track the arg with max length. Two-tier cache (array + map) stores small and overflow values efficiently.

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

## Complexity

- Time: ~O(N) amortized; each sequence element’s length stored once.
- Space: O(N) for primary array plus O(K) transient map entries (K << N).
- Worst-case path length grows sublinearly (≈ few hundred for 1e6 bound).

## Edge Cases

- N ≤ 1: With range 1 ≤ s < N there are no candidates when N ≤ 1; decide whether to return 1, 0, or throw (document contract). Euler uses N > 1.
- 64-bit overflow: Collatz trajectories for N < 1,000,000 stay within 64-bit; for much larger N consider BigInteger or detect overflow.
- Cache bounds: Access only indices < cache.length; larger intermediate values go to the map—avoid accidental array writes.
- Cycle safety: Collatz is conjectured to reach 1; code should still guard against pathological infinite loops (cap steps if defensive).
- Performance regression: Ensure memoization actually stores results (no missed backfill) or run time degrades severely.

## Testing mindset
- Spot check: N=10 → longest start 9.
- Verify known Euler value N=1_000_000 → 837799.
- Count cache fill vs N to confirm memo usage.


## Reusable template (for similar problems)

For iterative processes with overlapping subproblems:
- Define the recurrence for the cost/length.
- Cache results; when traversing from a start, stop at first cached node and backfill.
- Use wider types for intermediate states.

## Practical examples and business impact

- Workflow DAGs with repeated subpaths
  - Problem: Recompute path lengths/costs many times.
  - Model: Memoize lengths; backfill along traversed nodes.
  - Impact: Large speedups.

- Caching in rule engines
  - Problem: Rules reduce to previously seen states.
  - Model: Cache hits short-circuit evaluation.
  - Impact: Lower latency and compute.

- Compiler common subexpression elimination (CSE)
  - Problem: Recompute same expressions during optimization.
  - Model: Cache results; reuse across passes.
  - Impact: Faster builds.

- Graph shortest paths with reuse
  - Problem: Many queries share subpaths.
  - Model: Store partial distances; reuse across queries.
  - Impact: Snappier services.

- Dynamic programming in pricing
  - Problem: Repeated subproblems in tariff/discount plans.
  - Model: Memoize sub-results by state.
  - Impact: Real-time quotes.

- Simulation checkpoints
  - Problem: Long-running chains revisit states.
  - Model: Record and reuse state costs/lengths.
  - Impact: Shorter runs.

- Caching enriched telemetry
  - Problem: Enrichment steps repeat.
  - Model: Memoization keyed by derived state.
  - Impact: Cheaper pipelines.

- Recursive API pagination
  - Problem: Fetch paths revisit offsets.
  - Model: Cache segment results by cursor.
  - Impact: Lower API calls.

- Game state evaluation
  - Problem: Recursive evaluation revisits states.
  - Model: Transposition tables (memoization).
  - Impact: Stronger AI.

- Education demos on memoization
  - Problem: Teach caching with a visual chain.
  - Model: Collatz length memoization as a clean example.
  - Impact: Immediate intuition.

## Key Takeaways

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
