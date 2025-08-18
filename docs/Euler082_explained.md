# Euler082 — Path sum: three ways

Find the minimal path sum from any cell in the left column to any in the right column, moving only up, down, and right.

## Approach

- Column DP: let best[r] hold min cost to reach (r, currentCol). Initialize best with left column values.
- For each next column:
  - Start with best[r] + matrix[r][c] (assuming straight right move).
  - Sweep down: best[r] = min(best[r], best[r-1] + matrix[r][c]).
  - Sweep up: best[r] = min(best[r], best[r+1] + matrix[r][c]).
- Result is min_r best[r] at the last column.

## Complexity
- O(n·m) time, O(n) space; no priority queue needed.

## Real-world impact
- Columnar DP for constrained vertical movement (routing with limited turns).
