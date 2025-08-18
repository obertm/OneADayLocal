# Euler015 — Lattice paths in an n×n grid

Count the number of paths from top-left to bottom-right moving only right or down.

## Problem statement

For a grid of size n×n (edges, not including nodes outside), how many unique paths go from (0,0) to (n,n) with only right and down moves? Answer for n=20 is C(40,20).

## Step-by-step reasoning

1) Inputs/outputs
- Input: n ≥ 0 (Euler uses n=20).
- Output: number of paths (grows large; use BigInteger for exactness).

2) Combinatorial model
- A path is a sequence of exactly n R’s and n D’s → total moves 2n.
- Number of sequences with n R’s among 2n positions is C(2n, n) = (2n)!/(n!)^2.

3) Implementation in Java
- Use multiplicative binomial to avoid huge factorials:
  - result = Π_{i=1..n} (n+i)/i computed with BigInteger.
- Or directly compute factorials with BigInteger and divide at the end.

4) Complexity
- O(n) BigInteger multiplications/divisions; space proportional to digit count (~Θ(n)).

5) Edge cases
- n=0 → 1 path (empty path).
- Ensure division is exact at each step (choose multiply-then-divide per iteration to keep integers).

6) Testing mindset
- Small checks: n=0→1; n=1→2; n=2→6; n=3→20.
- Cross-validate multiplicative method vs factorial method.

## Reusable template (for similar problems)

When paths are constrained to unit steps on a grid with fixed counts of moves:
- Translate to choosing positions for one move type → a binomial coefficient.
- Prefer multiplicative binomial or BigInteger factorials for exact integer results.
- Avoid floating point approximations for correctness.

## Practical examples and business impact

- Routing and scheduling with unit operations
  - Model parallelizable task sequences as right/down moves; quickly compute counts to size buffers and workers.
  - Impact: Instant capacity sizing and SLA planning without simulation.

- Combinatorial A/B test design
  - Count combinations of choices (e.g., n options in two categories) via binomials to bound experiment space.
  - Impact: Controls scope and cost of experiments.

## Key takeaways

- Recognize combinatorial structure → use C(2n, n).
- Use BigInteger to keep exactness; multiplicative binomial is efficient and numerically stable.
