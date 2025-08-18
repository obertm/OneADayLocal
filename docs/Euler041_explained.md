# Euler041 — Pandigital prime

Find the largest n-digit pandigital prime.

## Approach

- Digit-sum rule: 8- or 9-digit pandigitals sum to 36/45 (divisible by 3) → not prime. Only 7-digit (sum=28), 4-digit (10), etc. matter.
- Generate candidates in descending lexicographic order for 7-digit pandigitals first (then 4-digit if needed).
- Test primality (sieve + trial division or deterministic Miller–Rabin for int range).

## Complexity
- Few permutations are needed before hitting the max prime; primality checks are cheap.

## Practical examples and business impact

- Candidate pruning in search: use invariants (e.g., digit sums) to eliminate impossible cases before heavy checks.
- Cryptography toy models: teach primality with strong prefilters to reduce Miller–Rabin calls.
- Scheduling IDs: generate pandigital-like IDs only when sums/mod constraints pass to cut invalid candidates.
- Constraint programming: demonstrate pruning rules that shrink permutation spaces massively.
- Benchmark harnesses: compare runtime with and without pruning to quantify impact.
- Education: illustrate divisibility by 3/9 as a powerful invariant for digit problems.
- Data validation: reject IDs that can’t be prime due to digit rules before database lookups.
- Simulation: generate only feasible candidate pools to control run times in Monte Carlo experiments.
- Security filtering: quick-reject classes of inputs that cannot pass downstream prime checks.
- Competitive programming pattern: template for cutting search space early using arithmetic invariants.

## Takeaways
- Use divisibility rules to prune n; permute digits descending; stop at first prime.


## Java implementation (Euler041.java)

- Class: `Euler041`
- Helpers: `isPrime(int)` trial division; a `permute(...)` routine that generates permutations of the digit set and feeds integers to a consumer.
- Strategy in code: Try 7-digit pandigital digits `{1..7}` first and track the maximum prime found among all permutations; if none, fall back to `{1..4}`.
- Output: Prints the largest pandigital prime discovered.
