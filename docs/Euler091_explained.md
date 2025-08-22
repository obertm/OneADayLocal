# Euler091 — Right triangles with integer coordinates

Count right triangles with vertices at (0,0), (x1,y1), (x2,y2) where 0 ≤ x,y ≤ N and non-degenerate.

## Approach

- Count axis-aligned right triangles: choose a point on x-axis and y-axis ⇒ N·N.
- For other right angles at P(x,y) with x,y>0: the number of q-steps along the perpendicular direction is gcd(x,y); contributions per P are 2·gcd(x,y).
- Sum over all P in the N×N lattice (excluding axes) and add axis-aligned.

## Edge Cases
- Degenerate triangles: Points collinear or zero area (when two points coincide) must be excluded; formula inherently ignores duplicates if loops skip identical points.
- Origin right angle: Counted in axis-aligned term only once; ensure no double count.
- GCD correctness: Use iterative gcd; ensure gcd(0,y) not used for interior points since x,y>0.
- Overflow: Accumulator should be long for larger N; N=50 safe in int but generalize.
- Performance: O(N²) fine; if N larger, precompute gcd row or use partial sums.

## Complexity
- O(N^2) with a gcd per point.

## Practical examples and business impact
- GIS: counting orthogonal right-angle plots in lattice-aligned parcel grids.
- Antenna layout: orthogonal triangle enumeration for right-angle interference zones.
- Computer graphics: lattice right-triangle counting for mesh analysis.

## Key Takeaways
- Axis-aligned + gcd-based perpendicular counts yield O(N^2) solution.

## Java implementation (Euler091.java)
- Optional CLI N (default 50).
- Initializes `total = N*N` axis-aligned right triangles with right angle at origin.
- For each lattice point (x,y) with x,y in 1..N, accumulates `gcd(x,y)` and adds twice that to the total at the end: `total += 2*sumGcd`.
- Prints `total`.
- Time: O(N²) with a fast gcd per point.
