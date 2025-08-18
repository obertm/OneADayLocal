# Euler091 — Right triangles with integer coordinates

Count right triangles with vertices at (0,0), (x1,y1), (x2,y2) where 0 ≤ x,y ≤ N and non-degenerate.

## Approach

- Count axis-aligned right triangles: choose a point on x-axis and y-axis ⇒ N·N.
- For other right angles at P(x,y) with x,y>0: the number of q-steps along the perpendicular direction is gcd(x,y); contributions per P are 2·gcd(x,y).
- Sum over all P in the N×N lattice (excluding axes) and add axis-aligned.

## Complexity
- O(N^2) with a gcd per point.

## Real-world impact
- Counting orthogonal structures in grids via gcd-based perpendicular steps.
