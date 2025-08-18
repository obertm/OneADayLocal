# Euler006 — Sum square difference

Compute (sum_{i=1..n} i)^2 − sum_{i=1..n} i^2.

## Do it like this

1) Use closed-form formulas
- Sum of first n: S = n(n+1)/2
- Sum of squares: Q = n(n+1)(2n+1)/6
- Answer = S^2 − Q

2) Why formulas
- O(1) time and O(1) space—no loops needed.
- Exact for integer n; no floating point.

3) Edge cases
- n = 0 or 1 → trivially 0.
- Use 64-bit (`long`) to avoid overflow during intermediate multiplications for large n.

4) Reuse pattern
- When sums of powers appear, look up or derive closed forms (Faulhaber’s formulas). Prefer O(1) algebra when available.

## Real-world connections and impact

- Analytics variance intuition
  - Variance ∝ E[X^2] − (E[X])^2, which mirrors the structure here.
  - Impact: Recognize when aggregate metrics can be computed via two counters.

- Resource planning with aggregates
  - Precompute aggregates from formulas rather than scanning data.
  - Impact: Saves compute and simplifies pipelines.

## Key takeaways
- Translate summations to closed forms when possible.
- Favor integer math; keep it O(1).
