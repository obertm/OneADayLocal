# Euler018 — Maximum path sum I (triangle)

Given a small triangle of numbers, find the maximum total from top to bottom.

## Dynamic programming you can reuse

1) Bottom-up DP
- Starting from the second last row up to the top: each cell becomes itself + max(children).
- Finally, the top cell is the maximum path sum.

2) Complexity
- O(N) over all cells; in-place updates reduce space to O(width) or O(1) if mutating.

## Real-world analogues and impact
- Decision trees and staged choices with additive scores.
  - Impact: Simple DP yields optimal policies fast.

## Takeaways
- Bottom-up DP on DAG-like structures; choose best child and accumulate.
