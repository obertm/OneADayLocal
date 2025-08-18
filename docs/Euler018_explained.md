# Euler018 — Maximum path sum I (triangle)

Given a small triangle of numbers, find the maximum total from top to bottom.

## Problem statement

Given a triangle with R rows (R ~ 15), choose a path from the top to bottom by moving to adjacent numbers on the row below, maximizing the sum.

## Step-by-step reasoning

1) Bottom-up dynamic programming
- Starting from the second last row up to the top: each cell becomes `cell += max(child_left, child_right)`.
- Finally, the top cell is the maximum path sum.

2) Why bottom-up
- Each parent only depends on two children; evaluating once bottom-up ensures O(N) total work over N cells.

3) Complexity
- Time O(N) where N is number of cells; space O(width) with a rolling array or O(1) if in-place.

4) Edge cases
- Negative numbers: still works because we take maxima locally.
- Empty triangle: define sum 0.

## Reusable template (for similar problems)

For DAG-like layered structures with local choices:
- Work from the base layer upward aggregating optimal substructure.
- Replace each node’s value with best achievable total from that node.

## Practical examples and business impact

- Decision trees and staged investment choices
  - Choose paths with maximum return under adjacency constraints.
  - Impact: Simple DP yields optimal policies quickly and explainably.

- Routing with limited branching
  - Aggregating costs along constrained paths in grids or trees.
  - Impact: Efficient route selection without heavy solvers.

## Key takeaways

- Bottom-up DP on triangles/lattices gives linear-time optimal solutions.
- In-place updates minimize memory and simplify code.

## Java implementation (Euler018.java)

We compute the maximum path sum using bottom-up dynamic programming.

- Data: `int[][] TRIANGLE` constant encodes the Euler triangle.
- Core: `maxPathSum(int[][] tri)`
  - Let `n = tri.length`. Create `int[][] dp = new int[n][]`.
  - Initialize base: `dp[n-1] = tri[n-1].clone()`.
  - For each row i from n-2 down to 0:
    - For each column j, set `dp[i][j] = tri[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);`.
  - Return `dp[0][0]` as the answer.
- CLI: `main(String[] args)` prints `maxPathSum(TRIANGLE)`.

Classroom notes:
- Why clone the last row? It preserves the original triangle and provides the base of the DP without side effects.
- Complexity: Each cell is processed once; memory is O(n) rows. A 1D rolling array optimization is possible but less explicit for teaching.
- This exact technique scales to larger triangles (see Euler067) when data is read from a file.
