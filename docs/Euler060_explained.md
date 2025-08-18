# Euler060 — Prime pair sets

Find the lowest-sum set of five primes such that any concatenation of two primes in any order is also prime.

## Practical strategy

- Sieve primes to a limit; implement a fast concatenation primality test (cache results of concat(p,q)).
- Build an undirected graph where an edge connects p and q if both concatenations are prime.
- Search for a 5-clique via DFS with pruning: maintain candidate lists that are connected to all in the current set; sort by degree; stop when sum exceeds current best.

## Complexity
- Exponential but small with pruning and caching; feasible.

## Real-world analogues and impact
- Clique finding in compatibility graphs with expensive edge tests; memoization is key.
  - Impact: Turns a hard search tractable with graph-based pruning and caching.

## Takeaways
- Cache concat primality; grow cliques with aggressive pruning; track best sum.


## Java implementation (Euler060.java)

- Class: `Euler060`
- Status: Marked TODO in code. The planned approach: sieve primes, memoize concat-prime checks, build compatibility graph, then DFS for 5-cliques with pruning by sum and degree.
- Once implemented, the program should print the minimum total sum of such a 5-prime set.
