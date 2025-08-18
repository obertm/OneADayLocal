# Euler070 — Totient permutation

Find n < 10^7 such that φ(n) is a permutation of n and n/φ(n) is minimized.

## Practical approach

- Best candidates are semiprimes n=pq with p≈q near √limit. Generate primes up to √(10^7) and a bit beyond; iterate pairs (p,q) with pq < limit and near √limit.
- For each n=pq, compute φ(n)=(p−1)(q−1); if digits(φ(n)) are a permutation of digits(n), evaluate ratio and keep the minimal.
- Return the n with the smallest ratio.

## Complexity
- O(#prime pairs near the diagonal) with cheap φ and digit-signature checks.

## Real-world analogues and impact
- Parameter search over multiplicative structures with digitwise constraints.
  - Impact: Focus on near-square semiprimes shrinks search from millions to thousands.

## Takeaways
- Search semiprimes near √limit; compare digit signatures and keep minimal ratio.
