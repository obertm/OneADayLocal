# Euler090 — Cube digit pairs

Count the distinct ways to place digits on two cubes so that they can display all square numbers below 100: 01,04,09,16,25,36,49,64,81 (with 6 and 9 interchangeable).

## Approach

- Choose 6 digits for cube A and 6 for cube B from {0..9}. Treat 6 and 9 as mutually substitutable: if a cube has 6 it can display 9 and vice versa.
- For each unordered pair of digit sets (A,B), check that for every required square (x,y), either x is on A and y on B, or x on B and y on A (after 6↔9 augmentation).
- Count valid unordered pairs (divide ordered counts by 2).

## Complexity
- ~C(10,6)^2/2 ~ 22k checks; trivial.

## Real-world impact
- Pair coverage tests with interchangeable symbols; careful handling of symmetry and equivalence.
