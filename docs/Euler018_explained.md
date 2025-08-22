# Euler018 — Maximum path sum I (triangle)

Given a small triangle of numbers, find the maximum total from top to bottom.

## Problem statement

Given a triangle with R rows (R ~ 15), choose a path from the top to bottom by moving to adjacent numbers on the row below, maximizing the sum.

## Step-by-step reasoning

## Approach

Bottom-up dynamic programming: starting from the penultimate row, replace each cell with its value plus max of its two children, finishing with apex containing the optimal path sum.

1) Bottom-up dynamic programming
- Starting from the second last row up to the top: each cell becomes `cell += max(child_left, child_right)`.
- Finally, the top cell is the maximum path sum.

2) Why bottom-up
- Each parent only depends on two children; evaluating once bottom-up ensures O(N) total work over N cells.

3) Complexity
- Time O(N) where N is number of cells; space O(width) with a rolling array or O(1) if in-place.

## Complexity

- Time: O(N) (each cell touched once).
- Space: O(W) for row buffer or O(1) extra if in-place mutation acceptable.

## Edge Cases

- Empty triangle: Return 0 (no path) or throw; here we treat as 0.
- Single row: Answer is the top value; DP loop naturally skips.
- Negative numbers: Algorithm still correct—local maxima incorporate negatives.
- Integer overflow: Sums may exceed 32-bit if triangle values large; use long if needed.
- Mutability: In-place modification destroys original triangle; use copy if original needed later.

## Reusable template (for similar problems)

For DAG-like layered structures with local choices:
- Work from the base layer upward aggregating optimal substructure.
- Replace each node’s value with best achievable total from that node.

## Practical examples and business impact

- Decision trees and staged investment choices
  - Problem: Maximize return across sequential choices.
  - Model: Bottom-up DP on a layered DAG.
  - Impact: Fast and explainable.

- Routing with limited branching
  - Problem: Aggregate costs along constrained paths.
  - Model: DP over layers; pick best child at each step.
  - Impact: Efficient route selection.

- Supply chain stage optimization
  - Problem: Choose best suppliers at each tier.
  - Model: Layered DP on cost triangle.
  - Impact: Lower costs.

- Career path planning (toy)
  - Problem: Maximize cumulative score across stages.
  - Model: DP on staged graph.
  - Impact: Decision support.

- Neural net layer pruning (toy)
  - Problem: Keep best connections per layer under constraints.
  - Model: DP-like reduction on layered structure.
  - Impact: Smaller models.

- Game level upgrades
  - Problem: Best upgrade path with adjacent choices.
  - Model: Triangle DP.
  - Impact: Better gameplay balance.

- Marketing funnel budgeting
  - Problem: Allocate spend per stage for max conversions.
  - Model: DP on funnel layers.
  - Impact: Improved ROI.

- Education adaptive paths
  - Problem: Choose next modules for highest mastery.
  - Model: DP over module lattice.
  - Impact: Personalized learning.

- Cloud cost reservations
  - Problem: Sequence commitments across terms.
  - Model: DP on staged options.
  - Impact: Cost savings.

- Project task sequencing
  - Problem: Maximize value with local adjacency constraints.
  - Model: DP across phases.
  - Impact: Predictable outcomes.

## Key Takeaways

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
