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
  - Problem: Generate integer solutions under algebraic constraints.
  - Model: Use parametric forms (like Euclid’s) instead of brute force.
  - Impact: Massive speedups.

- Signal layouts and integer grids
  - Problem: Place components on integer grids with sum constraints.
  - Model: Parametric generation + divisibility pruning.
  - Impact: Faster layout.

- Resource allocation with fixed totals
  - Problem: Find triple allocations meeting total S with structural constraints.
  - Model: Parametric solutions + scaling factor.
  - Impact: Efficient feasible‑set exploration.

- Cryptarithms and puzzles
  - Problem: Solve puzzles with algebraic patterns.
  - Model: Parameterize variables to reduce the search.
  - Impact: Faster solver runtimes.

- Computer graphics (Pythagorean triples)
  - Problem: Construct right triangles with integer edges.
  - Model: Euclid’s formula for primitive + scaled triples.
  - Impact: Deterministic geometry generation.

- Testing math libraries
  - Problem: Need large sets of Pythagorean triples.
  - Model: Use parametric enumeration; verify a^2+b^2=c^2.
  - Impact: Robust test data quickly.

- Education demos
  - Problem: Show structure behind Diophantine solutions.
  - Model: Live parametric generation.
  - Impact: Better understanding.

- Optimization warm‑starts
  - Problem: Need feasible starting points that meet constraints.
  - Model: Parametric construction to seed solvers.
  - Impact: Faster convergence.

- Embedded systems
  - Problem: Compute candidate triples under tight CPU budgets.
  - Model: Parametric formulas avoid cubic brute force.
  - Impact: Real‑time feasibility.

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
