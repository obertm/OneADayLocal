# Euler069 — Totient maximum

For n ≤ 1,000,000, find n maximizing n/φ(n).

## Insight

- n/φ(n) is maximized by the product of distinct small primes until exceeding the limit.

## Method

- Multiply primes in order: 2×3×5×7×11×... until the product would exceed 1,000,000; return the last product ≤ limit.

## Complexity
- O(#primes up to small bound).

## Real-world analogues and impact
- Optimizing ratios derived from multiplicative functions.
  - Impact: Simple prime products achieve near-extremal properties.

## Takeaways
- Multiply consecutive primes greedily under the limit.


## Java implementation (Euler069.java)

- Class: `Euler069`
- Greedy: Multiply successive small primes 2·3·5·… while the product ≤ 1,000,000; print the last product within the limit.
- Rationale: Maximizes n/φ(n) by minimizing φ(n) relative to n via distinct prime factors.
