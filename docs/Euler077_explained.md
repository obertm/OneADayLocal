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
