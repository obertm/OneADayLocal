# Euler035 — Circular primes below N

Count primes below N that remain prime under all rotations of their digits.

## Approach

- Sieve primes up to N.
- Exclude numbers containing even digits or 5 (except single-digit primes) to prune.
- For each candidate, generate all rotations and ensure each is prime.

## Complexity
- Sieve O(N log log N) plus per-candidate rotation checks; fast for N=1e6.

## Real-world analogues and impact
- Robustness under rotations/transformations (e.g., cyclic shifts in hash-based systems).
  - Impact: Ensures invariance properties for identifiers.

## Takeaways
- Use sieve + digit pruning + rotation prime checks.
