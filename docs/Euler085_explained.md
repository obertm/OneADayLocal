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

## Java implementation (Euler085.java)
- Precomputes triangular numbers `tri[i] = i(i+1)/2` up to a safe bound.
- For each m, binary searches n to minimize |tri[m]·tri[n] − 2,000,000| and checks neighbors around the found n.
- Tracks the best by smallest absolute difference; ties broken by smaller area m·n as per conventional interpretation.
- Prints the area `m·n` for the best grid.
- Time: O(M log N); constants tiny.
