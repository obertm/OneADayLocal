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
