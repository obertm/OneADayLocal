# Euler044 — Pentagon numbers

Find pentagonal numbers Pj, Pk such that Pj + Pk and |Pj − Pk| are pentagonal, minimizing the difference.

## Approach

- Generate pentagonals P(n)=n(3n−1)/2; keep a HashSet for membership tests.
- For j>k over a growing range, test sum and difference for pentagonality using the set or the inverse test x= (1+√(1+24t))/6 integer.
- Track minimal difference; stop when growth ensures no smaller difference possible.

## Edge Cases

- Insufficient range: If search bound too small, may miss minimal difference; implement adaptive expansion based on current best difference.
- Floating precision: Inverse test uses sqrt; floating rounding can cause false negatives; compare candidate n via integer reconstruction instead.
- Overflow: P(n) grows ~1.5n^2; for large n use long/BigInteger to avoid overflow.
- Duplicate checks: Avoid redundant sum/diff tests by breaking early when difference ≥ current best.
- Negative difference: Always non-negative by ordering j>k; enforce loop ordering.
- Performance: O(N^2) growth; need break conditions when minimal difference can no longer decrease.

## Complexity
- Near O(N^2) with effective pruning and fast membership tests.

## Practical examples and business impact

- Signal processing: membership in special sequences (e.g., perfect squares/triangles) via inverse formulas for fast gating.
- DB indexing: precompute and test special-key membership in O(1) to route to specialized shards.
- Simulation filtering: discard non-members quickly when exploring pairs with sum/difference constraints.
- Quality control: detect components whose measurements must lie on special number families.
- Education: teach deriving inverse checks for figurate sequences.
- Cryptography toys: test membership in structured sequences as a proxy for algebraic constraints.
- Geometry pipelines: quickly gate candidates that satisfy sum/difference figurate constraints before geometry checks.
- Analytics: accelerate repeated “is in family?” checks via boolean arrays or inverse functions.
- Embedded systems: O(1) membership to save CPU cycles under tight loops.
- Performance profiling: show how inverse checks turn nested loops into fast filters.

## Key Takeaways
- Precompute, store in a set, and use the integer inverse test to check pentagonality.


## Java implementation (Euler044.java)

- Class: `Euler044`
- Helpers: `pent(n)` generator; `isPent(x)` via inverse formula `(1+sqrt(1+24x))/6` and integer check.
- Double loop: Increase j, iterate k<j; compute `d = Pj - Pk`. If `d >= best`, break inner loop; if both `Pj + Pk` and `d` are pentagonal, record `best = d`.
- Output: Minimal difference printed.
