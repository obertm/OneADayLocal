# Euler011 — Largest product in a grid

Given a 2D grid of integers and a window length k, find the maximum product of k adjacent numbers in any of the four directions: right (→), down (↓), down-right (↘), and down-left (↙).

## Problem statement

Input: matrix g[h][w] and window size k (Euler: h=w=20, k=4). Output: max product over all valid k-step lines in the 4 directions.

## Step-by-step reasoning

1) Deterministic scan
- For each cell (r, c):
  - If c + k ≤ w, compute product to the right.
  - If r + k ≤ h, compute product downward.
  - If r + k ≤ h and c + k ≤ w, compute product down-right.
  - If r + k ≤ h and c − k ≥ −1, compute product down-left.
- Track the maximum across all.

2) Complexity
- O(h·w·k) multiplications (k is small, e.g., 4), space O(1).

3) Practical tips
- Guard bounds before multiplying to avoid index errors.
- If the grid can contain zeros/negatives, consider early break or segmenting by zeros for micro-optimizations.

## Reusable template
- Enumerate a fixed set of directions on a grid.
- For each origin, check bounds, compute the k-step aggregate, update the best.
- This generalizes to sums, mins/maxes, and other associative operations.

## Practical examples and business impact
- Sliding-window feature extraction on grids (images, heatmaps) → like small convolutions.
  - Impact: Efficient O(n)ish scans per direction enable real-time analytics on 2D data.
- Risk streaks in time×category matrices (e.g., outages) → detect strongest contiguous streaks.
  - Impact: Early detection with controllable compute.

## Key takeaways
- Enumerate directions explicitly; check bounds first; compute aggregate; track max.

## Java implementation (Euler011.java)

- Parser: `parseGrid(String s)` splits lines and whitespace into a 2D `int[][]`.
- Core: `maxProductInGrid(int[][] g, int k)`
  - Iterates all cells and computes products in four directions when in-bounds: right, down, down-right, down-left.
  - Tracks the best product across all origins and directions and returns it.
- Data: The 20×20 grid is stored as a multi-line string constant.
- CLI: `main(String[] args)` defaults `k = 4`; first arg overrides; parses grid and prints maximum product.
