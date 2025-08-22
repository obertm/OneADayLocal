# Euler092 — Square digit chains

For n < 10 million, numbers converge to 1 or 89 by repeatedly replacing n with the sum of squares of its digits. Count how many end at 89.

## Method

- Precompute outcomes for sums up to 9^2·7=567 (max for 7 digits).
- For each n, compute its digit-square sum; reduce via memo table to 1 or 89; count 89s.

## Edge Cases
- Leading zeros: Implicit in shorter numbers; digit-square sum unaffected; no special handling.
- Memo coverage: Max sum formula must match digit length for limit; for 10^7−1, digits=7; ensure table sized 0..567 inclusive.
- Infinite loop risk: Always converges to 1 or 89; guard anyway with iteration cap as defensive programming.
- Performance: Avoid string conversion; use integer arithmetic for digit extraction.
- Off-by-one: Range is n < 10^7; exclude 10^7 itself.

## Complexity
- O(N · digits) with memoization making inner work tiny.

## Practical examples and business impact
- Hash chains: convergence buckets via small-state reduction.
- Workflow engines: iterative transforms converging to attractor states.
- Caching: orbit memoization to collapse repeated path computations.

## Key Takeaways
- Reduce domain to max digit-square sum; memoize outcomes for linear scan.

## Java implementation (Euler092.java)
- Optional CLI limit (default 10,000,000).
- Prepares a memo array for sums up to 567, marking 1→state=1 and 89→state=2.
- For each n, iterates the digit-square map until reaching a known memo state; backfills along the path and counts those ending at 89.
- Prints the count.
- Complexity: O(limit) small-constant work; memory O(567).
