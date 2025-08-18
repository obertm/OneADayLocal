# Euler009 — Special Pythagorean triplet

Find the product abc for the unique Pythagorean triplet (a < b < c) such that a + b + c = S.

## Problem statement

Given a target sum S, find a Pythagorean triple (a,b,c) with a+b+c=S and a^2 + b^2 = c^2, and return the product a·b·c.

## Step-by-step reasoning

1) Use Euclid’s formula
- Primitive triplets: a = m^2 − n^2, b = 2mn, c = m^2 + n^2 where m > n ≥ 1, gcd(m,n)=1, not both odd.
- Scaling by positive integer d gives all triplets.

2) Solve the sum constraint
- a + b + c = d · 2m(m + n) = S → d must divide S.
- Iterate m and n with 2m(m+n) ≤ S; when it divides, compute d = S / (2m(m+n)) and return product.

3) Why it’s efficient
- Search space is bounded by m up to about √S.
- Directly targets valid triplets, avoiding brute-force over a,b,c.

4) Complexity
- About O(√S) iterations; trivial for S = 1000.

## Reusable template
- Translate constraints into parametric forms (Euclid’s formula for Pythagorean triples).
- Use divisibility to prune; compute directly once parameters fit.

## Practical examples and business impact

- Geometry and lattice problems
  - Parametric generation using number-theory formulas replaces cubic brute force.
  - Impact: Orders-of-magnitude speedups in constraint generation tasks.

- Signal layouts and integer grids
  - When constraints are algebraic, derive parametric forms first.
  - Impact: Faster solvers and reduced infrastructure costs.

## Key takeaways
- Use parametric forms + divisibility to prune the search.
- Complexity drops from cubic to near-square-root.

## Java implementation (Euler009.java)

- Core: `tripletProductForSum(int sum)`
  - Iterates `m ≥ 2` with bound `2*m*(m+1) ≤ sum`; inner loop `n` from 1..m-1.
  - Checks if `sum % (2*m*(m+n)) == 0`; when true, sets `d = sum / (2*m*(m+n))`.
  - Computes `a = d*(m^2 − n^2)`, `b = d*(2mn)`, `c = d*(m^2 + n^2)` and validates Pythagorean and sum constraints; returns `a*b*c`.
  - Returns -1 if no triplet exists.
- CLI: `main(String[] args)` defaults `sum = 1000`; first arg overrides; prints the product.
