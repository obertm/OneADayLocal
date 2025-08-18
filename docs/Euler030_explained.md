# Euler030 — Digit fifth powers

Find all numbers that can be written as the sum of the fifth powers of their digits, and return the sum of such numbers.

## Method

1) Upper bound
- For d-digit numbers, max sum is d·9^5; find smallest d where d·9^5 < 10^{d-1} to cap the search (for fifth powers, ≤ 354294).

2) Brute force with cache
- Precompute p[d] = d^5 for digits 0..9.
- Loop n from 2 to LIMIT, compute sum of p[digit(n)]; if equal to n, add to answer.

3) Complexity
- O(L · digits) with tiny constants.

## Real-world analogues and impact
- Constraint search with tight bounds and memoized digit contributions.
  - Impact: Turns exponential-looking search into a linear scan.

## Takeaways
- Derive a hard upper bound; cache digit powers; scan and compare.
