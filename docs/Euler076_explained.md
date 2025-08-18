# Euler076 — Counting summations

Number of ways to write 100 as a sum of at least two positive integers.

## Solution

- This is integer partitions p(100) excluding the single-part case → p(100)−1.
- Use coin-change DP with coins 1..99 (order-agnostic): ways[0]=1; for coin c from 1..99: for s=c..100: ways[s]+=ways[s−c]. Answer=ways[100].

## Complexity
- O(target × #coins) with small constants.

## Real-world analogues and impact
- Partition counts in budgeting or resource splits.
  - Impact: Fast counts for planning and what-if analysis.

## Takeaways
- Standard combinations DP for partitions; subtract 1 if excluding the single-term partition.


## Java implementation (Euler076.java)

- Class: `Euler076`
- Coin-change DP with coins 1..100: ways[0]=1; for each coin, add ways to targets ≥ coin. Answer is `ways[100]-1` to exclude the single-term partition.
- Output: Print the computed value.
