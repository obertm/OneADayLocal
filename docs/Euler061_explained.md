# Euler061 — Cyclical figurate numbers

Find a set of six 4-digit figurate numbers (triangle, square, pentagonal, hexagonal, heptagonal, octagonal) that form a cycle such that the last two digits of each number are the first two digits of the next, and all six types are used exactly once.

## Strategy

- Precompute 4-digit figurate numbers for each type; filter numbers whose two-digit suffix/prefix don’t end/start with 0.
- Build maps from prefix→list of numbers per type.
- Backtracking DFS: pick an ordering of types (or fix one as start), choose a start number, then chain by matching suffix→prefix, ensuring one from each distinct type; close the cycle by matching last suffix to start prefix.
- Return sum once a cycle is found.

## Complexity
- Small search with strong pruning; thousands of states max.

## Real-world analogues and impact
- Cycle cover in a typed graph with exact cover constraints.
  - Impact: Backtracking with adjacency maps solves constrained routing cleanly.

## Takeaways
- Precompute per-type lists and prefix maps; DFS across types with suffix/prefix matching and cycle closure.


## Java implementation (Euler061.java)

- Class: `Euler061`
- Precompute: For each figurate type 3..8, generate 4-digit values with non-zero middle (suffix>=10). Bucket by 2-digit prefix in a map: type → prefix → list of values.
- DFS:
  - Try any start value/type, track used values to avoid duplicates.
  - Recurse over remaining types by matching previous suffix to next prefix.
  - When one type remains, enforce that its suffix closes the cycle to the starting prefix; on success, return the sum.
- Output: The sum of the six numbers in the unique cycle.
