# Euler031 — Coin sums

Count the ways to make a target amount using unlimited coins of given denominations (UK coins in the problem).

## Approach

- Use 1D DP for combinations (order-agnostic): ways[0]=1; for each coin c: for s=c..target: ways[s]+=ways[s-c].
- Ensures each combination is counted once by iterating coins outermost.

## Complexity
- O(target × #coins) time, O(target) space.

## Real-world analogues and impact
- Change-making, knapsack-like count of combinations, pricing bundles.
  - Impact: Fast counts for product mix and promotions planning.

## Takeaways
- Outer loop coins, inner loop sums ascending for combination counts.


## Java implementation (Euler031.java)

- Class: `Euler031`
- Entry point: `public static void main(String[] args)`
  - Default target is 200 (i.e., £2). You can override by passing an integer: `java Euler031 500`.
- Core logic: a 1D DP array where `ways[s]` is the number of ways to make sum `s`.
  - Initialize: `long[] ways = new long[target + 1]; ways[0] = 1;`
  - For each coin `c` in `{1,2,5,10,20,50,100,200}`:
    - For `i` from `c` to `target`: `ways[i] += ways[i - c];`
- Why this order matters: Coin-outer and ascending-sum ensures combinations (order-independent) rather than permutations.
- Output: Prints `ways[target]`.
