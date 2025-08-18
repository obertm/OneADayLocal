# Euler077 — Prime summations

Find the least number that can be written as a sum of primes in over 5000 ways.

## Approach

- Generate primes up to a growing limit; use coin-change DP with primes as coins to count ways for each target n.
- Increase n and recompute (or extend) until ways[n] > 5000; return n.

## Complexity
- O(n × #primes) per sweep; n is small for threshold 5000.

## Real-world analogues and impact
- Ways to compose a value from prime building blocks.
  - Impact: DP gives exact counts quickly.

## Takeaways
- Coin-change DP over primes; grow n until crossing the threshold.


## Java implementation (Euler077.java)

- Class: `Euler077`
- For N from 2 upward, build the list of primes ≤ N and run coin-change DP using those primes as coin denominations; when `ways[N] > 5000`, print N.
- Output: The first N exceeding 5000 prime-sum partitions.
