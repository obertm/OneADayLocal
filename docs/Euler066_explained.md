# Euler066 — Diophantine equation (Pell)

For 1 < D ≤ 1000 not a perfect square, solve x^2 − D y^2 = 1 for minimal x; return D that yields the largest minimal x.

## Plan

- For each non-square D, compute continued fraction of √D; minimal solution corresponds to period parity: use convergents until a solution to Pell’s equation appears (check x^2 − D y^2 == 1).
- Track D with the largest minimal x.

## Complexity
- O(D · period) with BigInteger arithmetic as x,y grow.

## Real-world analogues and impact
- Pell solutions via CFs appear in quadratic form optimizations.
  - Impact: Deterministic path to minimal solutions using number theory.

## Takeaways
- Iterate convergents of √D and test Pell; keep the D with maximal minimal x.


## Java implementation (Euler066.java)

- Class: `Euler066`
- For each non-square D≤1000, expand √D as a continued fraction; iteratively form convergents (p_k/q_k) using BigIntegers.
- After each step, test `p^2 − D q^2 == 1`; the first time it holds, that (p,q) is the minimal solution for this D.
- Track the D with largest minimal p (x) and print it.
