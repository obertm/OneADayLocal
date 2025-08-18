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
