# Euler045 — Triangular, pentagonal, hexagonal

Find the next number that is triangular, pentagonal, and hexagonal after 40755.

## Approach

- Hexagonal numbers H(n)=n(2n−1) are a subset of triangular; iterate n>143 and generate H(n).
- Test pentagonality for H(n) via inverse check: x=(1+√(1+24H))/6 integer.
- First match after 40755 is the answer.

## Complexity
- O(k) iterations until the next match; constant-time membership test.

## Real-world analogues and impact
- Intersections of monotone sequences via generating the rarest sequence and testing membership.
  - Impact: Efficient multi-constraint filtering.

## Takeaways
- Generate hexagonals; test pentagonality; triangularity is implicit.
