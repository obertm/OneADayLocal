# Euler056 — Powerful digit sum

Find the maximum digital sum of a^b for 1 < a < 100 and 1 < b < 100.

## Approach

- Loop a,b; compute BigInteger a^b (or repeated multiply), sum digits; track maximum.
- Minor prune: a with trailing zeros won’t help maximize digit sum at high b, but full brute force is fine.

## Edge Cases
- Base / exponent bounds: Exclude a=1 or b=1 per problem; confirm loops start at 2.
- BigInteger reuse: Recomputing from scratch vs. incremental multiply; incremental multiply safer than repeated pow loops with exponent resets.
- Digit sum correctness: Convert to string; ensure Unicode digits only (BigInteger toString uses ASCII digits).
- Performance: 99×99 operations trivial; if scaled, consider pruning trailing-zero bases early.
- Overflow: Using BigInteger prevents overflow; avoid using double-based pow which would lose precision.

## Complexity
- ~10k exponentiations with small sizes; trivial.

## Practical examples and business impact

- Parameter grid search: scan (a,b) pairs to find max/min of a metric (digit sum, error, etc.).
- Hyperparameter tuning: maximize a scoring function over a grid of exponents for model selection.
- Cryptography: search for exponent pairs yielding maximal digit entropy in modular outputs.
- Simulation: sweep parameter spaces to find extreme-case outputs for stress testing.
- Data compression: find (a,b) pairs that maximize digit diversity for encoding schemes.
- Education: teach brute-force grid search and metric tracking.
- Benchmarking: compare brute-force vs. heuristic search for maxima in small spaces.
- QA: generate edge-case values with maximal digit sums for parser/validator testing.
- Visualization: plot heatmaps of (a,b) vs. digit sum to reveal structure.
- Embedded: test digit-sum routines with large, varied inputs from grid search.

## Key Takeaways
- Straight brute force with BigInteger and digit-sum helper.


## Java implementation (Euler056.java)

- Class: `Euler056`
- Loops `a` and `b` in 1..99; computes `a^b` via repeated multiply with BigInteger; sums digits from `toString()` and tracks the maximum.
- Helpers: `powBig(int,int)` and `digitSum(BigInteger)`.
- Output: Print the maximum digital sum.
