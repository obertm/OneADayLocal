# Euler087 — Prime power triples

Count numbers below N expressible as p^2 + q^3 + r^4 with primes p,q,r.

## Method

- Sieve primes up to N^{1/2}, N^{1/3}, N^{1/4} respectively.
- Triple-loop with pruning: for each r^4 < N, for each q^3 < N−r^4, for each p^2 < N−r^4−q^3, insert sum into a boolean array or set.
- Count distinct sums.

## Complexity
- Small loop counts thanks to steep powers; near-linear in #sums.

## Real-world impact
- Summation sets from heterogeneous exponent bounds; dedup via bitset/boolean array.
