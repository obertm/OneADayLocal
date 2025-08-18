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
