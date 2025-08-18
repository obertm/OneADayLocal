# Euler049 — Prime permutations in arithmetic progression

Find a 12-digit number formed by concatenating three 4-digit primes that are permutations of each other and form an arithmetic sequence (excluding the known example starting at 1487).

## Strategy

- Sieve 4-digit primes; group by sorted-digit signature.
- For each group with ≥3 primes, sort ascending and search for triples (a,b,c) with equal gaps where all three are in the group.
- Concatenate the found triple.

## Complexity
- Sieve + grouping O(N); triple search per group is small.

## Real-world analogues and impact
- Pattern mining within equivalence classes under permutation.
  - Impact: Simple grouping enables efficient structure discovery.

## Takeaways
- Group by digit signature; look for arithmetic triplets inside groups.


## Java implementation (Euler049.java)

- Class: `Euler049`
- Helpers: `isPrime(int)` and `sortDigits(int)` for digit-signature grouping.
- Steps:
  - Sieve/prune primes to 4-digit odd primes; group into a map keyed by sorted-digit strings.
  - For each group with size ≥ 3, sort and search for (a,b,c) with `c = 2b - a` also in the group.
  - Skip the known example (1487, 4817, 8147); on the first new triple, print the concatenated 12-digit string and exit.
