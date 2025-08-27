# Euler081 — Path sum: two ways

Find the minimal path sum from the top-left to the bottom-right of a matrix, moving only right and down.


## Approach

- Read the matrix from file (or use a fallback sample if missing).
- Use a single rolling array for dynamic programming: for each cell, accumulate the minimal path sum from the top or left.
- For each row, update the DP array in-place: `dp[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j]`.
- The answer is the last value in the DP array after processing all rows.

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
- Uses a single 1D DP array for memory efficiency (O(n) space):
	- Initialize the first row as cumulative sums.
	- For each subsequent row, update the DP array in-place using the minimum of the value above or to the left.
- Prints the minimal path sum (`dp[n-1]`).
- Complexity: O(n²) time, O(n) space; highly efficient for n = 80.

## Verified Output

The minimal path sum for the provided Project Euler matrix is:

**427337**

This matches the known correct answer.
