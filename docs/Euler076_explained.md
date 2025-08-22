# Euler076 — Counting summations

Number of ways to write 100 as a sum of at least two positive integers.

## Approach

- This is integer partitions p(100) excluding the single-part case → p(100)−1.
- Use coin-change DP with coins 1..99 (order-agnostic): ways[0]=1; for coin c from 1..99: for s=c..100: ways[s]+=ways[s−c]. Answer=ways[100].

## Edge Cases
- Excluding single term: Ensure subtraction of 1 only once; do not remove other partitions erroneously.
- Coin range: Using coins up to 99 (or 100) both work; including 100 adds the single partition which you subtract later.
- Overflow: ways counts fit in 64-bit; for larger targets use BigInteger.
- Memory: 1D array length target+1 sufficient; avoid 2D DP that doubles memory.
- Order independence: Ensure loop order is coin outer / sum inner ascending to avoid permutations counting multiple times.

## Complexity
- O(target × #coins) with small constants.

## Practical examples and business impact
- Partition counts in budgeting or resource splits.
  - Impact: Fast counts for planning and what-if analysis.

## Key Takeaways
- Standard combinations DP for partitions; subtract 1 if excluding the single-term partition.


## Java implementation (Euler076.java)

- Class: `Euler076`
- Coin-change DP with coins 1..100: ways[0]=1; for each coin, add ways to targets ≥ coin. Answer is `ways[100]-1` to exclude the single-term partition.
- Output: Print the computed value.
