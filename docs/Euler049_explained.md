# Euler049 — Prime permutations in arithmetic progression

Find a 12-digit number formed by concatenating three 4-digit primes that are permutations of each other and form an arithmetic sequence (excluding the known example starting at 1487).

## Approach

- Sieve 4-digit primes; group by sorted-digit signature.
- For each group with ≥3 primes, sort ascending and search for triples (a,b,c) with equal gaps where all three are in the group.
- Concatenate the found triple.

## Edge Cases

- Leading zeros in permutations: Not an issue since all primes stay 4-digit; ensure r ≤ 9999.
- Duplicate detection: Triplets can be visited multiple ways; restrict to p < q < r and maybe iterate q>p only.
- Known sequence filtering: Must compare full triplet set membership, not just starting value, to skip exactly that sequence.
- Digit multiset: Sort 4-character string or count 10-length frequency array; stable and fast; avoid BigInteger for concatenation.
- Overflow: Concatenation of three 4-digit numbers fits in int? 12-digit may exceed int; use long or string building.
- Performance: Nested loops worst-case O(P^2); early pruning by difference (r beyond 9999) reduces search.

## Complexity
- Sieve + grouping O(N); triple search per group is small.

## Practical examples and business impact

- Fraud detection: group by digit-signature and find arithmetic patterns in transactions.
- Inventory: product codes permuted by warehouse conventions; detect evenly spaced series within groups.
- Cryptanalysis toys: permutation-equivalence classes with linear gaps as proxy structure.
- Time-series bins: reorder-invariant buckets; search arithmetic spacing for signal.
- Education: show the power of signature grouping before structure mining.
- Compression: identify permutable symbol blocks with regular gaps for model tuning.
- A/B testing IDs: ensure evenly spaced IDs within signature groups for fair sampling.
- Data quality: detect accidental permutations of fields forming suspicious progressions.
- Scheduling: job IDs permuted per site; detect arithmetic cadence within equivalence groups.
- Benchmarking: compare naive all-pairs vs. signature-then-gap search performance.

## Key Takeaways
- Group by digit signature; look for arithmetic triplets inside groups.


## Java implementation (Euler049.java)

- Class: `Euler049`
- Helpers: `isPrime(int)` and `sortDigits(int)` for digit-signature grouping.
- Steps:
  - Sieve/prune primes to 4-digit odd primes; group into a map keyed by sorted-digit strings.
  - For each group with size ≥ 3, sort and search for (a,b,c) with `c = 2b - a` also in the group.
  - Skip the known example (1487, 4817, 8147); on the first new triple, print the concatenated 12-digit string and exit.
