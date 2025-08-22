# Euler011 — Largest product in a grid

Given a 2D grid of integers and a window length k, find the maximum product of k adjacent numbers in any of the four directions: right (→), down (↓), down-right (↘), and down-left (↙).

## Problem statement

Input: matrix g[h][w] and window size k (Euler: h=w=20, k=4). Output: max product over all valid k-step lines in the 4 directions.

## Step-by-step reasoning

## Approach

Brute-force directional scan: for every cell, attempt the four direction vectors (→, ↓, ↘, ↙) if the k-length window stays in bounds, compute the product, and track the maximum. k is tiny (4), so direct multiplication is fastest; no need for incremental rolling products.

1) Deterministic scan
- For each cell (r, c):
  - If c + k ≤ w, compute product to the right.
  - If r + k ≤ h, compute product downward.
  - If r + k ≤ h and c + k ≤ w, compute product down-right.
  - If r + k ≤ h and c − k ≥ −1, compute product down-left.
- Track the maximum across all.

2) Complexity
- O(h·w·k) multiplications (k is small, e.g., 4), space O(1).

## Complexity

- Time: O(h·w·k) with k constant (≈ O(h·w)).
- Space: O(1) beyond input grid.
- Early exits possible if remaining theoretical max < current best (not needed for Euler size).

3) Practical tips
- Guard bounds before multiplying to avoid index errors.
- If the grid can contain zeros/negatives, consider early break or segmenting by zeros for micro-optimizations.

## Reusable template
- Enumerate a fixed set of directions on a grid.
- For each origin, check bounds, compute the k-step aggregate, update the best.
- This generalizes to sums, mins/maxes, and other associative operations.

## Practical examples and business impact

- Image/vision kernels (mini-convolutions)
  - Problem: Extract local features (edges, corners) with small kernels.
  - Model: Fixed-direction windowed products/sums over pixels.
  - Impact: Real-time analytics with predictable cost.

- Heatmap hotspot detection
  - Problem: Find strongest contiguous k-cells horizontally/vertically/diagonally.
  - Model: Directional sliding windows across the grid.
  - Impact: Fast incident detection on KPI heatmaps.

- Reliability along routes
  - Problem: Evaluate path reliability as product of per-hop reliabilities.
  - Model: Max product over k-step lines approximates best local route segment.
  - Impact: Quick what-if analysis for network planning.

- Sports analytics (streaks)
  - Problem: Longest strong run across time×player or time×team matrices.
  - Model: Max product/sum streaks along allowed directions.
  - Impact: Simple, explainable streak metrics.

- Geospatial raster scans
  - Problem: Detect linear features (roads, rivers) in raster tiles.
  - Model: Directional window products/scores as cheap prefilter.
  - Impact: Lower-cost pipeline before heavy models.

- Bioinformatics k-mer intensity tracks
  - Problem: Identify strong consecutive k-mer signals on 2D assays.
  - Model: Sliding products across rows/cols/diagonals.
  - Impact: Rapid candidate discovery.

- Manufacturing wafer/board QA
  - Problem: Detect linear defect runs on 2D inspection grids.
  - Model: Directional k-length product/score scans; reset on zeros.
  - Impact: Early warning, reduced scrap.

- Game AI pattern finding
  - Problem: Find four-in-a-row style patterns.
  - Model: Check k-aligned cells in four directions efficiently.
  - Impact: Strong baselines and test harnesses.

- Log anomaly maps (service×minute)
  - Problem: Find high-intensity linear anomalies.
  - Model: Directional window scans with thresholds.
  - Impact: Faster incident triage.

- Financial correlation grids
  - Problem: Detect short linear clusters of high co-movement.
  - Model: Sliding products/sums per direction on correlation heatmaps.
  - Impact: Quick signals for further analysis.

## Key Takeaways
- Enumerate directions explicitly; check bounds first; compute aggregate; track max.

## Edge Cases

- Boundary windows: Skip any direction whose k-step window would exit the grid (avoid partial products). The explicit bound checks prevent index errors.
- k = 1: Result is simply the maximum single cell value; loops still work unmodified.
- Zeros: A zero inside a window forces product 0; no special handling needed, but you can micro‑opt by early abort once a zero is seen while multiplying.
- Negative numbers: If the grid were extended to include negatives, products could become larger in magnitude via even counts of negatives. Use `long` if values·k may overflow `int`.
- Overflow: For Euler (max cell 99, k=4) the max product 99^4 < 1e8 fits in 32-bit. Generalize with values up to 10^6 or larger k → switch accumulator to `long` or `BigInteger`.
- Non-square or small grids: Works for any h×w. If k > max(h,w), no products are computed; define return (commonly 0 or throw). Here we naturally return the initial best (0) if nothing evaluated.
- Input validation: Guard against null/empty grid or inconsistent row lengths before scanning.


## Java implementation (Euler011.java)

- Parser: `parseGrid(String s)` splits lines and whitespace into a 2D `int[][]`.
- Core: `maxProductInGrid(int[][] g, int k)`
  - Iterates all cells and computes products in four directions when in-bounds: right, down, down-right, down-left.
  - Tracks the best product across all origins and directions and returns it.
- Data: The 20×20 grid is stored as a multi-line string constant.
- CLI: `main(String[] args)` defaults `k = 4`; first arg overrides; parses grid and prints maximum product.
