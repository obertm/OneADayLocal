# Euler044 — Pentagon numbers

Find pentagonal numbers Pj, Pk such that Pj + Pk and |Pj − Pk| are pentagonal, minimizing the difference.

## Method

- Generate pentagonals P(n)=n(3n−1)/2; keep a HashSet for membership tests.
- For j>k over a growing range, test sum and difference for pentagonality using the set or the inverse test x= (1+√(1+24t))/6 integer.
- Track minimal difference; stop when growth ensures no smaller difference possible.

## Complexity
- Near O(N^2) with effective pruning and fast membership tests.

## Real-world analogues and impact
- Using inverse closed forms for O(1) membership checks in special sequences.
  - Impact: Turns repeated queries fast without scanning.

## Takeaways
- Precompute, store in a set, and use the integer inverse test to check pentagonality.
