# Euler085 — Counting rectangles

Find the grid dimensions m×n with a number of rectangles closest to two million.

## Insight

- Rectangles count in m×n grid: R(m,n) = m(m+1)n(n+1)/4 (choose two distinct vertical and two horizontal lines).

## Approach

- Iterate m from 1 upward; for each m, binary search or scan n to minimize |R(m,n)−2,000,000|; track best by absolute difference and area tie-break.

## Complexity
- O(M log N) with binary search; tiny in practice.

## Real-world impact
- Parameter tuning to hit a target combinatorial count (e.g., submatrix windows).
