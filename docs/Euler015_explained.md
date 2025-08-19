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
  - Problem: Count ways to sequence unit tasks (right/down moves).
  - Model: C(2n, n) paths; size buffers/workers accordingly.
  - Impact: Instant capacity sizing without simulation.

- Combinatorial A/B test design
  - Problem: Bound experiment space with two categories of choices.
  - Model: Binomials count combinations; choose n of 2n.
  - Impact: Efficient planning.

- Warehouse picking paths
  - Problem: Estimate path counts in grid aisles.
  - Model: Right/down moves; C(2n, n) for rectangular blocks.
  - Impact: Layout optimization.

- Network packet routing in meshes
  - Problem: Count shortest paths in grid networks.
  - Model: Binomial coefficients for minimal-hop routes.
  - Impact: Capacity analysis.

- Parallel job scheduling
  - Problem: Ways to interleave two independent job streams.
  - Model: Choose positions for one stream among 2n slots.
  - Impact: Throughput estimates.

- DNA sequence alignment (toy model)
  - Problem: Count alignments with only matches and gaps.
  - Model: Combinatorial interleavings as binomials.
  - Impact: Intuition for alignment growth.

- UI testing sequences
  - Problem: Order of clicks/keystrokes with two action types.
  - Model: Number of sequences equals C(2n, n).
  - Impact: Scope realistic test coverage.

- Finance rebalancing steps
  - Problem: Ways to interleave buy/sell unit steps.
  - Model: Binomial counts of sequences.
  - Impact: Risk scenario counts.

- Education combinatorics drills
  - Problem: Teach stars‑and‑bars/choose functions.
  - Model: Multiplicative binomial computation.
  - Impact: Stronger fundamentals.

- Distributed systems retries vs work
  - Problem: Interleave retries with productive ops.
  - Model: Combinatorial placements among fixed steps.
  - Impact: Predictive sizing.

## Key takeaways

- Recognize combinatorial structure → use C(2n, n).
- Use BigInteger to keep exactness; multiplicative binomial is efficient and numerically stable.

## Java implementation (Euler015.java)

We compute C(2n, n) exactly using BigInteger and a multiplicative formula.

- Public method: `latticePaths(int n)` returns `binomial(2*n, n)`.
- Helper: `binomial(int n, int k)`
  - Handles edge cases: k < 0 or k > n → 0; k == 0 or k == n → 1.
  - Uses symmetry: replace k with `n - k` if it’s larger to minimize loop length.
  - Iteratively multiply then divide with BigInteger:
    - For i from 1..k: `res = res * (n - k + i) / i`.
  - Divisions are exact at each step by construction, so no rounding is needed.
- CLI: `main(String[] args)` defaults `n = 20`; optional first arg overrides; prints the result.

Classroom notes:
- Why multiplicative? Avoids building huge factorials; keeps intermediate values smaller and divides cleanly each step.
- Why symmetry? It ensures ≤ n/2 iterations, reducing work roughly by half.
- BigInteger division safety: We only divide by i after multiplying by a corresponding numerator factor, so intermediate is an exact multiple of i.
