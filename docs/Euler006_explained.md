# Euler006 — Sum square difference

Compute (sum_{i=1..n} i)^2 − sum_{i=1..n} i^2.

## Problem statement

Given a positive integer n, compute the difference between the square of the sum of the first n natural numbers and the sum of their squares:
Δ(n) = (1 + 2 + … + n)^2 − (1^2 + 2^2 + … + n^2).

## Step-by-step reasoning

1) Inputs/outputs
- Input: n ≥ 0 (default per Euler is 100).
- Output: a single integer Δ(n).

2) Use closed-form formulas (no loops)
- Sum of first n: S = n(n+1)/2.
- Sum of squares: Q = n(n+1)(2n+1)/6.
- Answer: Δ = S^2 − Q.

3) Why formulas
- O(1) time and O(1) space—no iteration.
- Exact with integer math; no floating point rounding.

4) Implementation details (Java)
- Use 64-bit long to avoid intermediate overflow: compute in an order that minimizes overflow (e.g., divide by 2 or 6 early when factors permit).
- For extremely large n, consider BigInteger to stay exact.

5) Complexity
- Time O(1), space O(1).

6) Edge cases
- n = 0 → 0; n = 1 → 0.
- For large n, ensure intermediate arithmetic does not overflow long.

7) Testing mindset
- Quick checks: n=0→0; n=1→0; n=2→(1+2)^2−(1+4)=9−5=4; n=10→3025−385=2640.

## Reusable template (for similar problems)

When you see sums of simple powers or polynomials over 1..n:
- Look up or derive closed forms (Faulhaber’s formulas).
- Prefer algebraic evaluation over loops when constraints allow.
- Keep everything in integer math; reduce before multiply to avoid overflow.

## Practical examples and business impact

- Analytics variance and second moments
  - Many KPIs can be derived from two aggregates: sum and sum of squares. Δ mirrors the core of variance. 
  - Impact: Maintain just two counters per stream and compute variance offline cheaply.

- Capacity planning and forecasting
  - When formulas exist for cumulative metrics, use them to produce instant what-if analyses without scanning data.
  - Impact: Lower compute costs; faster iteration with product and finance stakeholders.

## Key takeaways

- Translate summations to closed forms when possible.
- Keep computations in integer math; use careful ordering to avoid overflow.
