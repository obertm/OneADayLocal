# Euler053 — Combinatoric selections

Count how many nCr exceed one million for 1 ≤ n ≤ 100.

## Approach

- Multiplicative: incrementally compute nCr without overflow using early division and break when exceeding threshold.
- Log-space: use log10 factorials or log sums to compare nCr > 1e6 without big integers.

## Edge Cases
- Symmetry misuse: Ensure r=min(r,n−r) each computation; forgetting doubles work.
- Threshold equality: Count only strictly greater than 1,000,000; equality is excluded.
- Overflow risk: Use early division or double accumulation; direct factorial division can overflow 64-bit.
- Floating precision: Double rounding safe at these magnitudes; for larger bounds prefer BigInteger or logs.
- Counting window: After first r where nCr > threshold found, count range r..(n−r); verify inclusive indices.

## Complexity
- O(n^2) with tiny constants.

## Practical examples and business impact

- Capacity planning: count choose values exceeding thresholds to bound search/config spaces.
- Feature selection: estimate when combinations exceed reviewable limits.
- Test-case generation: stop when nCr crosses budget to cap suites.
- Risk: identify portfolio combinations whose counts exceed a risk-screening threshold.
- Scheduling: determine when combinations of assignments explode past feasible limits.
- Education: show symmetry and early stopping to cut compute.
- Simulation: log-space comparisons to avoid overflow while counting exceedances.
- Cloud cost: bound the number of combinations worth exploring under budget caps.
- UI design: limit multi-select combinations when nCr > limit to keep UX manageable.
- Data pipelines: throttle combinatorial joins by pre-checking nCr against capacity.

## Key Takeaways
- Use symmetry r=min(r,n−r); stop early when crossing the threshold.


## Java implementation (Euler053.java)

- Class: `Euler053`
- Core: `combinationExceeds(n, r, 1_000_000)` computes nCr multiplicatively with doubles and stops as soon as it exceeds the threshold, avoiding overflow.
- Loop: For each n, find the smallest r where nCr > 1e6, then count all r..(n−r) by symmetry, add to total, and break to next n.
- Output: Print the total count for 1 ≤ n ≤ 100.
