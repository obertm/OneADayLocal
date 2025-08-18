# Euler053 — Combinatoric selections

Count how many nCr exceed one million for 1 ≤ n ≤ 100.

## Approaches

- Multiplicative: incrementally compute nCr without overflow using early division and break when exceeding threshold.
- Log-space: use log10 factorials or log sums to compare nCr > 1e6 without big integers.

## Complexity
- O(n^2) with tiny constants.

## Real-world analogues and impact
- Threshold counting for combinatorial explosion detection.
  - Impact: Quick capacity planning and bound checks.

## Takeaways
- Use symmetry r=min(r,n−r); stop early when crossing the threshold.


## Java implementation (Euler053.java)

- Class: `Euler053`
- Core: `combinationExceeds(n, r, 1_000_000)` computes nCr multiplicatively with doubles and stops as soon as it exceeds the threshold, avoiding overflow.
- Loop: For each n, find the smallest r where nCr > 1e6, then count all r..(n−r) by symmetry, add to total, and break to next n.
- Output: Print the total count for 1 ≤ n ≤ 100.
