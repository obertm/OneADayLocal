# Euler028 — Number spiral diagonals

Sum numbers on the diagonals in an n×n spiral built by starting at 1 and moving to the right in a clockwise spiral.

## Closed form

1) Layer formula
- For layer k (side length s=2k+1), the four corners sum to 4s^2 - 6(s-1).

2) Sum layers
- Total = 1 + Σ_{k=1..m} [4(2k+1)^2 - 6·2k] where n=2m+1.

3) Complexity
- O(m) arithmetic or derive a polynomial closed form; trivial compute.

## Real-world analogues and impact
- Recognizing and exploiting structure avoids simulation.
  - Impact: Orders-of-magnitude faster computations for patterned data.

## Takeaways
- Use the corner formula per layer; sum layers; or apply the known polynomial result.
