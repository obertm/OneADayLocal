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
  - Problem: Estimate variance/standard deviation from streaming data.
  - Model: Maintain sum and sum of squares; compute Δ to derive variance.
  - Impact: Accurate metrics with constant memory.

- Capacity planning and forecasting
  - Problem: Answer what‑if questions on cumulative metrics instantly.
  - Model: Use closed forms instead of scanning datasets.
  - Impact: Lower compute; faster planning.

- A/B test analysis
  - Problem: Compute pooled variance for experiment arms quickly.
  - Model: Aggregate sum/sum‑of‑squares per arm; compute Δ per arm and combined.
  - Impact: Rapid significance checks.

- Monitoring SLO drift
  - Problem: Track dispersion (variance) of latency without full histograms.
  - Model: Keep per‑window sum and sum‑of‑squares; alert on Δ changes.
  - Impact: Low‑cost observability.

- Risk budgeting
  - Problem: Approximate portfolio variance from returns stream.
  - Model: Δ over returns gives unscaled variance proxy.
  - Impact: Faster risk dashboards.

- Education/grading normalization
  - Problem: Normalize scores across classes.
  - Model: Compute mean/variance via Δ from two aggregates.
  - Impact: Fair grading with minimal data.

- Physics/engineering sums
  - Problem: Compute moments of inertia for discrete masses 1..n.
  - Model: Sum of squares closed form provides instant results.
  - Impact: Quick design iterations.

- Finance tax/progressive brackets
  - Problem: Model cumulative cost functions with polynomial pieces.
  - Model: Replace loops with closed‑form sums over ranges.
  - Impact: Faster simulations.

- ML feature engineering
  - Problem: Standardize features with mean/variance at scale.
  - Model: Track sum and sum‑of‑squares per feature.
  - Impact: Efficient preprocessing.

- Database rollups
  - Problem: Provide approximate variance in OLAP cubes.
  - Model: Store and merge sum/sum‑of‑squares; compute Δ on demand.
  - Impact: Fast BI queries.

## Key takeaways

- Translate summations to closed forms when possible.
- Keep computations in integer math; use careful ordering to avoid overflow.

## Java implementation (Euler006.java)

- Helpers: `sumFirstN(long n)` returns n(n+1)/2; `sumSquaresFirstN(long n)` returns n(n+1)(2n+1)/6.
- Core: `difference(long n)` computes `sum^2 - sumSquares` using the helpers (with long arithmetic).
- CLI: `main(String[] args)` defaults n = 100; accepts optional first arg; prints the difference.
