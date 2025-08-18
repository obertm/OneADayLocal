# Euler081 — Path sum: two ways

Find the minimal path sum from the top-left to the bottom-right of a matrix, moving only right and down.

## Approach

- Read the matrix from file.
- Dynamic programming: dp[r][c] = matrix[r][c] + min(dp[r-1][c], dp[r][c-1]) with edges handled by single predecessors.
- Fill row-by-row/col-by-col; answer is dp[lastRow][lastCol].

## Complexity
- O(n·m) time and O(min(n,m)) space with rolling arrays.

## Real-world impact
- Grid cost routing with axis-aligned moves (warehouses, DP on lattices).
