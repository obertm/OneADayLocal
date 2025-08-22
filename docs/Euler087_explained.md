# Euler087 — Prime power triples

Count numbers below N expressible as p^2 + q^3 + r^4 with primes p,q,r.

## Method

- Sieve primes up to N^{1/2}, N^{1/3}, N^{1/4} respectively.
- Triple-loop with pruning: for each r^4 < N, for each q^3 < N−r^4, for each p^2 < N−r^4−q^3, insert sum into a boolean array or set.
- Count distinct sums.

## Edge Cases
- Duplicate sums: Different (p,q,r) may yield same sum; need set/bitset dedupe.
- Prime generation limits: Ensure prime list covers largest root needed for each exponent; separate bounds for square, cube, fourth powers.
- Overflow: p^2, q^3, r^4 within 64-bit for limits; compute powers using long.
- Memory: BitSet sized N may be large; if memory tight, use hash set tradeoff speed vs memory.
- Performance: Loop ordering from largest exponent outward minimizes iterations via early breaks.

## Complexity
- Small loop counts thanks to steep powers; near-linear in #sums.

## Practical examples and business impact
- Mixed exponent feature generation with boundary constraints.
- Cryptography experiments: sum of prime power components enumeration.
- Sparse signal synthesis: constructing values from heterogeneous powered bases.

## Key Takeaways
- Precompute prime powers; nested loops with early breaks and bitset dedupe.

## Java implementation (Euler087.java)
- Optional CLI limit (default 50,000,000).
- Sieves primes up to sqrt(limit), then builds three increasing arrays/lists:
	- squares p² < limit, cubes p³ < limit, fourths p⁴ < limit.
- Triple-loop with early breaks using the increasing order; marks sums in a `BitSet` to deduplicate.
- Prints the bitset cardinality.
- Time: practical because the lists are short; memory: O(limit/wordSize) for the bitset.
