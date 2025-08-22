# Euler069 — Totient maximum

For n ≤ 1,000,000, find n maximizing n/φ(n).

## Approach

- n/φ(n) is maximized by the product of distinct small primes until exceeding the limit.

## Step-by-step reasoning

- Multiply primes in order: 2×3×5×7×11×... until the product would exceed 1,000,000; return the last product ≤ limit.

## Edge Cases
- Limit boundary: Stop before exceeding limit; last valid product is answer even if next prime factor is small.
- Redundant factors: Adding repeated prime factors decreases ratio; ensure distinct primes only.
- Prime generation: Need primes only up to when product crosses limit; simple trial division fine.
- Overflow: Product stays within 1e6; safe in 32-bit; if generalized, switch to long.
- Off-by-one: Inclusive limit; ensure product == limit accepted.

## Complexity
- O(#primes up to small bound).

## Practical examples and business impact
- Optimizing ratios derived from multiplicative functions.
  - Impact: Simple prime products achieve near-extremal properties.

## Key Takeaways
- Multiply consecutive primes greedily under the limit.


## Java implementation (Euler069.java)

- Class: `Euler069`
- Greedy: Multiply successive small primes 2·3·5·… while the product ≤ 1,000,000; print the last product within the limit.
- Rationale: Maximizes n/φ(n) by minimizing φ(n) relative to n via distinct prime factors.
