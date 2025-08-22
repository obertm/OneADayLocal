# Euler066 — Diophantine equation (Pell)

For 1 < D ≤ 1000 not a perfect square, solve x^2 − D y^2 = 1 for minimal x; return D that yields the largest minimal x.

## Approach

- For each non-square D, compute continued fraction of √D; minimal solution corresponds to period parity: use convergents until a solution to Pell’s equation appears (check x^2 − D y^2 == 1).
- Track D with the largest minimal x.

## Edge Cases
- Perfect squares: Must skip immediately or loop may attempt division by zero or produce trivial x=√D,y=0 non-solution.
- BigInteger overflow avoidance: x,y escalate fast; only BigInteger safe for D up to 1000 (still manageable) but future scale demands it.
- Period parity: For odd period, doubling of sequence needed; simpler is sequential convergent testing—ensure logic handles both parities uniformly.
- Performance: Avoid rebuilding whole coefficient list each iteration; incrementally derive next term from recurrence.
- Termination: Stop at first Pell solution per D; continuing risks non-minimal x overshadowing minimal tracking.

## Complexity
- O(D · period) with BigInteger arithmetic as x,y grow.

## Practical examples and business impact
- Pell solutions via CFs appear in quadratic form optimizations.
  - Impact: Deterministic path to minimal solutions using number theory.

## Key Takeaways
- Iterate convergents of √D and test Pell; keep the D with maximal minimal x.


## Java implementation (Euler066.java)

- Class: `Euler066`
- For each non-square D≤1000, expand √D as a continued fraction; iteratively form convergents (p_k/q_k) using BigIntegers.
- After each step, test `p^2 − D q^2 == 1`; the first time it holds, that (p,q) is the minimal solution for this D.
- Track the D with largest minimal p (x) and print it.
