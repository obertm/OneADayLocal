# Euler060 — Prime pair sets

Find the lowest-sum set of five primes such that any concatenation of two primes in any order is also prime.

## Approach

- Sieve primes to a limit; implement a fast concatenation primality test (cache results of concat(p,q)).
- Build an undirected graph where an edge connects p and q if both concatenations are prime.
- Search for a 5-clique via DFS with pruning: maintain candidate lists that are connected to all in the current set; sort by degree; stop when sum exceeds current best.

## Edge Cases
- Concatenation overflow: Use long or string-based conversion; concatenating two ~5-digit primes may exceed int.
- Leading zeros: Not present (primes have no leading zeros), so concatenation straightforward.
- Cache symmetry: concat(p,q) vs concat(q,p) both needed; store both or compute directionally each time.
- Prime limit adequacy: Sieve must cover largest prime appearing in concatenations (which can create numbers larger than base limit); may need on-demand primality test for large concatenations.
- Pruning correctness: Ensure candidate intersection logic only keeps nodes connected to all current set; a single missed edge invalidates clique.
- Search ordering: Without degree/sum ordering, explosion occurs; maintain deterministic ordering to avoid missed minimal-sum solution.

## Complexity
- Exponential but small with pruning and caching; feasible.

## Practical examples and business impact

- Clique finding: search for maximal compatible sets in graphs with expensive edge tests (e.g., prime concatenation).
- Compatibility modeling: build graphs where edges represent expensive-to-check relationships; prune with memoization.
- Simulation: measure how memoization/caching accelerates hard search problems.
- Education: teach clique search and graph pruning strategies.
- Benchmarking: compare naive vs. memoized edge tests in graph search.
- Data mining: find sets of items with all-pairs compatibility under custom rules.
- Scheduling: assign groups where all members must be mutually compatible (e.g., team formation).
- Security: model key-agreement groups where all pairs must pass a cryptographic test.
- QA: test clique-finding logic with synthetic compatibility graphs.
- Visualization: plot compatibility graphs and highlight maximal cliques found.

## Key Takeaways
- Cache concat primality; grow cliques with aggressive pruning; track best sum.


## Java implementation (Euler060.java)

- Class: `Euler060`
- Status: Marked TODO in code. The planned approach: sieve primes, memoize concat-prime checks, build compatibility graph, then DFS for 5-cliques with pruning by sum and degree.
- Once implemented, the program should print the minimum total sum of such a 5-prime set.
