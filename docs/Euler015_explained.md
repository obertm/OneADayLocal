# Euler015 — Lattice paths in an n×n grid

Count the number of paths from top-left to bottom-right moving only right or down.

## Straight to the formula

1) Combinatorics
- Path is a sequence of n rights and n downs → total moves 2n.
- Count = C(2n, n) = (2n)! / (n!)^2.

2) Implementation
- Use multiplicative formula to compute C(2n, n) without overflow where possible, or use BigInteger for exactness.

3) Complexity
- O(n) multiplications; space O(1) or O(log n) big-int digits.

## Real-world analogues and impact
- Grid routing and scheduling with unit steps.
  - Impact: Closed-form counts enable instant capacity sizing.

## Takeaways
- Recognize combinatorial structure → use binomial coefficients.
