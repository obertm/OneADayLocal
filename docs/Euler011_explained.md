# Euler011 — Largest product in a grid

Given a 2D grid of integers and a window length k, find the maximum product of k adjacent numbers in any of the four directions: right (→), down (↓), down-right (↘), and down-left (↙).

## Reproducible approach

1) Inputs/outputs
- Input: matrix `g[h][w]` and window size `k` (in Euler, h=w=20, k=4).
- Output: max product over all valid k-step lines in the 4 directions.

2) Deterministic scan
- For each cell (r, c):
  - If c + k ≤ w, compute product to the right.
  - If r + k ≤ h, compute product downward.
  - If r + k ≤ h and c + k ≤ w, compute product down-right.
  - If r + k ≤ h and c − k ≥ −1, compute product down-left.
- Track the maximum across all.

3) Complexity
- O(h·w·k) multiplications (k is small, e.g., 4), space O(1).

4) Practical tips
- Guard bounds before multiplying to avoid index errors.
- If the grid can contain zeros/negatives, consider early break or segmenting by zeros for micro-optimizations.

## Real-world echoes and impact
- Sliding-window feature extraction on grids (images, heatmaps) → like small convolutions.
  - Impact: Efficient O(n)ish scans per direction enable real-time analytics on 2D data.
- Risk streaks in time×category matrices (e.g., outages) → detect strongest contiguous streaks.
  - Impact: Early detection with controllable compute.

## Takeaways
- Enumerate directions explicitly; check bounds first; compute product; track max.
