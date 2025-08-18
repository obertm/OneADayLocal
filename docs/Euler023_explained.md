# Euler023 — Non-abundant sums

Find the sum of all positive integers ≤ 28123 that cannot be written as the sum of two abundant numbers.

## Method

1) Classify numbers
- Compute sum of proper divisors for 1..LIMIT; mark abundant if sum > n.

2) Reachable sums
- Use a boolean array `can[ ]`; for all i≤j over abundant list, mark can[i+j]=true when i+j ≤ LIMIT.

3) Sum complement
- Answer = sum of all n where can[n] is false.

## Complexity
- Divisor-sum sieve ~ O(L log L); marking sums ~ O(A^2) where A is #abundants (manageable here).

## Real-world analogues and impact
- Feasibility via pairwise combination reachability (budgeting, two-resource allocations).
  - Impact: Quick cutoff analysis without exhaustive search over all pairs.

## Takeaways
- Precompute divisor sums; two-pointer-like nested loop for abundant sums with early breaks.
