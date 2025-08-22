# Euler070 — Totient permutation

Find n < 10^7 such that φ(n) is a permutation of n and n/φ(n) is minimized.

## Approach

- Best candidates are semiprimes n=pq with p≈q near √limit. Generate primes up to √(10^7) and a bit beyond; iterate pairs (p,q) with pq < limit and near √limit.
- For each n=pq, compute φ(n)=(p−1)(q−1); if digits(φ(n)) are a permutation of digits(n), evaluate ratio and keep the minimal.
- Return the n with the smallest ratio.

## Edge Cases
- Prime powers: Typically worse ratio than distinct primes; focusing on semiprimes acceptable but confirm doesn’t miss edge candidates (rare beyond search scope).
- Permutation test: Leading zeros not allowed; ensure digit counts compared, not string sorts with different lengths.
- Division precision: Compare ratios using cross multiplication (n1*φ2 < n2*φ1) to avoid double rounding error.
- Prime bounds: Need primes slightly above √limit to capture near-equal factors; insufficient bound misses candidates.
- Performance: Full n iteration infeasible; semiprime restriction critical; ensure pair loops break early when pq exceeds limit.

## Complexity
- O(#prime pairs near the diagonal) with cheap φ and digit-signature checks.

## Practical examples and business impact
- Parameter search over multiplicative structures with digitwise constraints.
  - Impact: Focus on near-square semiprimes shrinks search from millions to thousands.

## Key Takeaways
- Search semiprimes near √limit; compare digit signatures and keep minimal ratio.

## Java implementation (Euler070.java)

- Class: `Euler070`
- Generate primes up to ~100k; iterate prime pairs (p,q) with pq < 10^7, biased toward near-equal p and q.
- Compute φ(n) quickly as (p−1)(q−1); use a digit-count `isPermutation(int,int)` to test the permutation condition.
- Track the smallest ratio n/φ(n) and print n.
