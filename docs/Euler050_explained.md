# Euler050 — Consecutive prime sum

Find the prime < 1,000,000 that can be written as the longest sum of consecutive primes.

## Problem statement

Among all sums of consecutive primes p_i + p_{i+1} + … + p_j that are < 1,000,000, find the one that is itself prime and has the maximum length (j−i+1). Return that prime.

## Step-by-step reasoning

1) Inputs/outputs
- Input: limit N (Euler uses 1,000,000).
- Output: the prime < N formed by the longest run; tie-breaks don’t matter because the longest run is unique for N=1e6.

2) Precompute primes and prefix sums
- Sieve primes < N and store them in an array `primes` and a boolean `isPrime` lookup (or BitSet).
- Build prefix sums P where P[0]=0 and P[k]=sum of first k primes.
- Any run sum from i (inclusive) to j (exclusive) is S = P[j] − P[i].

3) Search longest windows efficiently
- Let K = number of primes < N.
- Start with the longest feasible window length L and decrease:
  - For i from 0 up to K−L: S = P[i+L] − P[i].
  - If S ≥ N, break (further i increases S even more).
  - If isPrime[S] is true, record S and stop (current L is maximal); optionally keep best if continuing search.

4) Why this is fast
- Each sum is O(1) via prefix sums.
- Decreasing L stops early once a valid run is found, so total work is far below O(K^2) in practice.

5) Complexity
- Sieve: O(N log log N) time, O(N) space.
- Search: worst-case O(K^2) checks but with strong pruning; practical runtime is small for N=1e6.

6) Edge cases and correctness
- Ensure prefix sums use long to avoid overflow (sum of primes below 1e6 fits in 64-bit).
- If no run of length L fits (<N), reduce L.
- isPrime lookup should handle 0..N−1; for S ≥ N skip.

7) Testing mindset
- Sanity: the answer for N=1e6 is 997651.
- Cross-check: For smaller N (e.g., N=1000), brute-force all windows and verify optimization matches.

## Reusable template (for similar problems)

When searching for the longest run with constraints over a sequence:
- Precompute the sequence and a membership test (e.g., primality) for O(1) queries.
- Use prefix sums for O(1) range sums.
- Scan by window length, from large to small, to stop early.

## Practical examples and business impact

- Longest streak analytics with membership filters
  - E.g., in event streams, find the longest consecutive subsequence whose aggregate stays below a threshold and where the aggregate meets a property.
  - Impact: Prefix sums and O(1) set membership enable near-real-time analytics without heavy infrastructure.

- Budget windows over daily costs
  - Find longest consecutive days whose cumulative spend is below cap and meets a score criterion.
  - Impact: Efficient planning and alerting with predictable compute.

## Key takeaways

- Prefix sums turn window sums into O(1).
- A fast membership test (isPrime) plus decreasing window sizes prunes most work.
- Keep sums in long; sieve once and reuse across checks.
