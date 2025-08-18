# Euler023 — Non-abundant sums

Find the sum of all positive integers ≤ 28123 that cannot be written as the sum of two abundant numbers.

## Problem statement

Compute S = sum of all n ≤ LIMIT such that there do not exist abundant a,b with a+b = n. Euler uses LIMIT=28123.

## Step-by-step reasoning

1) Classify numbers
- Compute sum of proper divisors for 1..LIMIT via a sieve; mark abundant if sum > n.

2) Reachable sums
- Use a boolean array `can[ ]`; for all i ≤ j over abundant list, mark can[i+j]=true when i+j ≤ LIMIT; break inner loop early when sums exceed LIMIT.

3) Sum complement
- Answer = sum of all n where can[n] is false.

4) Complexity
- Divisor-sum sieve ~ O(L log L); marking sums ~ O(A^2) where A is #abundants (manageable here).

## Reusable template (for similar problems)

Feasibility via pairwise reachability:
- Precompute a set of special numbers (e.g., abundant) and mark all pair-sums up to a cap.
- Aggregate the complement set.

## Practical examples and business impact

- Budgeting with two funding sources
  - Check which costs cannot be covered as a sum of two available grants.
  - Impact: Identifies gaps quickly without exhaustive search over all costs.

- Two-resource allocation feasibility
  - Determine which tasks cannot be formed by pairing two resource bundles.
  - Impact: Fast feasibility analysis guides procurement.

## Key takeaways

- Precompute special numbers; mark sums efficiently with early breaks.
- Summing the complement answers the question directly.
