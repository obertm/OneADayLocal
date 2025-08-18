# Euler092 — Square digit chains

For n < 10 million, numbers converge to 1 or 89 by repeatedly replacing n with the sum of squares of its digits. Count how many end at 89.

## Method

- Precompute outcomes for sums up to 9^2·7=567 (max for 7 digits).
- For each n, compute its digit-square sum; reduce via memo table to 1 or 89; count 89s.

## Complexity
- O(N · digits) with memoization making inner work tiny.

## Real-world impact
- Iterated function orbits with small-state memoization.
