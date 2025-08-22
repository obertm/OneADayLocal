# Euler085 — Counting rectangles

Find the grid dimensions m×n with a number of rectangles closest to two million.

## Insight

- Rectangles count in m×n grid: R(m,n) = m(m+1)n(n+1)/4 (choose two distinct vertical and two horizontal lines).

## Approach

- Iterate m from 1 upward; for each m, binary search or scan n to minimize |R(m,n)−2,000,000|; track best by absolute difference and area tie-break.

## Edge Cases
- Overflow: m(m+1)n(n+1) can exceed 32-bit; use long; for larger targets watch 64-bit overflow.
- Tie-breaker: Define tie-breaking (e.g., smaller area) consistently; document it.
- Search bounds: Upper bound for n given m from R(m,1); shrink search space accordingly.
- Binary search rounding: After search, test neighboring n (n−1, n, n+1) to ensure closest captured.
- Symmetry: R(m,n)=R(n,m); scanning both redundant; restrict n ≥ m to halve work.

## Complexity
- O(M log N) with binary search; tiny in practice.

## Practical examples and business impact
- UI layout sizing to approximate target widget rectangle counts.
- Data windowing: choose grid partitioning near a target number of subregions.
- Capacity planning: select m×n shard grid matching required shard count via rectangle math.

## Key Takeaways
- Use triangular number products and search nearest target via per-m binary search.

## Java implementation (Euler085.java)
- Precomputes triangular numbers `tri[i] = i(i+1)/2` up to a safe bound.
- For each m, binary searches n to minimize |tri[m]·tri[n] − 2,000,000| and checks neighbors around the found n.
- Tracks the best by smallest absolute difference; ties broken by smaller area m·n as per conventional interpretation.
- Prints the area `m·n` for the best grid.
- Time: O(M log N); constants tiny.
