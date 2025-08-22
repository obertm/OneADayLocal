# Euler030 — Digit fifth powers

## Problem statement

Find all positive integers that can be written as the sum of the p-th powers of their digits (Euler uses p=5), and return the sum of such numbers (excluding 1-digit trivialities).

## Step-by-step reasoning

## Approach

Derive an upper bound via d·9^p; precompute digit p-th powers; iterate numbers up to bound summing digit powers and compare to number; accumulate matches.

1) Upper bound
- For a d-digit number, the maximum sum of p-th powers is d·9^p. Find the smallest d where d·9^p < 10^{d-1}; search up to d·9^p.

2) Scan with cached digit powers
- Precompute pow[d] = d^p for digits 0..9.
- For n from 2 to LIMIT, sum pow of its digits; if the sum equals n, accumulate it in the answer.

3) Complexity
- O(LIMIT · digits(n)) with tiny constants; extremely fast for p=5.

## Complexity

- Time: O(B · log10 B) where B is derived bound; constant factors minimal.
- Space: O(1) beyond small power cache.

## Edge Cases

- p=1: Every number equals sum of first-power digits; problem definition usually excludes trivial p; handle gracefully.
- Single-digit numbers: Exclude 0..9 as per problem statement (trivial cases) when summing results.
- Bound miscalc: Ensure the derived LIMIT truly covers all solutions (verify increasing d until inequality fails).
- Overflow: pow[i] must fit in int/long; for large p consider BigInteger or early bound checks.
- Performance: For larger p values, LIMIT can grow; reassess feasibility before brute force.
- Negative p or zero p: Invalid/exotic; document or reject.

## Reusable template (for digit-function fixed points)

- Derive a proof-based upper bound using digit extremes.
- Cache per-digit contribution; compute per-number by decomposition.
- Compare and aggregate matches.

## Practical examples and business impact

- Check-digit and scoring systems that aggregate digit-based contributions.
- Efficiently bounding search spaces by reasoning with digit maxima minimizes compute costs.

## Key Takeaways

- Tight bounds + per-digit caching turn an intractable-looking search into a short loop.

## Java implementation (Euler030.java)

We compute an upper bound, precompute digit powers, scan, and sum matches.

- Upper bound: increase d while 10^{d-1} ≤ d·9^p; set LIMIT = d·9^p.
- Cache: `pow[0..9] = i^p`.
- Loop: for n=2..LIMIT, sum pow of digits and compare to n; if equal, add to total.
- Output: print the total sum of all such numbers.
