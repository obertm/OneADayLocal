# Euler081 — Path sum: two ways

Find the minimal path sum from the top-left to the bottom-right of a matrix, moving only right and down.

## Approach

- Read the matrix from file.
- Dynamic programming: dp[r][c] = matrix[r][c] + min(dp[r-1][c], dp[r][c-1]) with edges handled by single predecessors.
- Fill row-by-row/col-by-col; answer is dp[lastRow][lastCol].

## Edge Cases
- File absence: Provide sample fallback or report missing; avoid crash.
- Large matrix: Use rolling arrays to reduce memory from O(n²) to O(n).
- Integer overflow: Sum can exceed 32-bit if values large; use long for accumulation if scaling input.
- Negative values: Algorithm still works but may need caution; problem assumes non-negative.
- Input parsing: Trailing commas or spaces can cause parse errors; robust split required.

## Complexity
- O(n·m) time and O(min(n,m)) space with rolling arrays.

## Practical examples and business impact
- Grid routing: warehouse picking paths with only right/down moves.
- Image DP: cumulative cost seam computation in restricted directions.
- Spreadsheet modeling: minimizing aggregated costs with monotone move constraints.
- Supply chain: stepwise consolidation cost minimization along two dimensions.

## Key Takeaways
- Classic 2D right/down DP; use rolling array for O(min(n,m)) space.

## Java implementation (Euler081.java)
- Loads `p081_matrix.txt` if present; otherwise uses the sample 5×5 matrix as a fallback so the program always runs.
- Builds a 2D DP table `dp[n][n]` with:
	- `dp[0][0] = a[0][0]`.
	- First row/col as cumulative sums.
	- For each cell `(i,j)`: `dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + a[i][j]`.
- Prints `dp[n-1][n-1]`.
- Complexity: O(n²) time and space; trivial for n = 80.
