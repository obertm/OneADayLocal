# Euler082 — Path sum: three ways

Find the minimal path sum from any cell in the left column to any in the right column, moving only up, down, and right.

## Approach

- Column DP: let best[r] hold min cost to reach (r, currentCol). Initialize best with left column values.
- For each next column:
  - Start with best[r] + matrix[r][c] (assuming straight right move).
  - Sweep down: best[r] = min(best[r], best[r-1] + matrix[r][c]).
  - Sweep up: best[r] = min(best[r], best[r+1] + matrix[r][c]).
- Result is min_r best[r] at the last column.

## Edge Cases
- Multiple passes: Need both downward and upward sweeps; a single pass misses paths with multiple vertical moves.
- Initialization: best array for new column must start from prior column’s best plus current cell cost; forgetting this leads to underestimation.
- Negative weights: Algorithm assumes non-negative; negative cycles not possible here but negative entries could still work; treat cautiously.
- Memory: Single column array sufficient; avoid full 2D DP for large matrices.
- File errors: Handle missing or malformed lines gracefully.

## Complexity
- O(n·m) time, O(n) space; no priority queue needed.

## Practical examples and business impact
- Network routing with lateral progression and vertical adjustments.
- Manufacturing lines: station-to-station movement with limited backtracking.
- Grid energy minimization where only forward column progress is allowed.

## Key Takeaways
- Two directional relaxation sweeps per column achieve optimal up/down/right paths.

## Java implementation (Euler082.java)
- Reads `p082_matrix.txt` if available; otherwise falls back to the same 5×5 sample as documentation.
- Maintains `dp[r][c]` but updates a column at a time:
  - Initialize first column: `dp[r][0] = a[r][0]`.
  - For each next column j:
    - Seed assuming right moves: `dp[r][j] = dp[r][j-1] + a[r][j]`.
    - Sweep top→bottom: `dp[i][j] = min(dp[i][j], dp[i-1][j] + a[i][j])`.
    - Sweep bottom→top: `dp[i][j] = min(dp[i][j], dp[i+1][j] + a[i][j])`.
- The answer is `min_r dp[r][lastCol]`.
- Runs in O(n²) time, O(n²) space in this implementation; could be O(n) space with a single array per column.
