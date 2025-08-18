# Euler041 — Pandigital prime

Find the largest n-digit pandigital prime.

## Approach

- Digit-sum rule: 8- or 9-digit pandigitals sum to 36/45 (divisible by 3) → not prime. Only 7-digit (sum=28), 4-digit (10), etc. matter.
- Generate candidates in descending lexicographic order for 7-digit pandigitals first (then 4-digit if needed).
- Test primality (sieve + trial division or deterministic Miller–Rabin for int range).

## Complexity
- Few permutations are needed before hitting the max prime; primality checks are cheap.

## Real-world analogues and impact
- Strong pruning via invariants (digit sums) before expensive tests.
  - Impact: Large search spaces collapse to tiny candidate sets.

## Takeaways
- Use divisibility rules to prune n; permute digits descending; stop at first prime.


## Java implementation (Euler041.java)

- Class: `Euler041`
- Helpers: `isPrime(int)` trial division; a `permute(...)` routine that generates permutations of the digit set and feeds integers to a consumer.
- Strategy in code: Try 7-digit pandigital digits `{1..7}` first and track the maximum prime found among all permutations; if none, fall back to `{1..4}`.
- Output: Prints the largest pandigital prime discovered.
