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


## Java implementation (Euler035.java)

- Class: `Euler035`
- Sieve: `boolean[] sieve(int n)` builds primality up to limit.
- Candidate pruning: For multi-digit numbers, reject any with digits {0,2,4,5,6,8} since some rotation would be even or divisible by 5.
- Check rotations by slicing strings `s.substring(i)+s.substring(0,i)` and testing primality in the sieve array.
- Main accepts optional limit (default 1,000,000), counts circular primes below it, and prints the count.
