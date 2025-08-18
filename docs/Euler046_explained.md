# Euler046 — Goldbach’s other conjecture

Find the smallest odd composite that cannot be written as prime + 2×square.

## Procedure

- Sieve primes; for odd n increasing that are not prime, test if ∃ prime p ≤ n with (n−p) even and (n−p)/2 a perfect square.
- If no such p exists, return n.

## Complexity
- Prime sieve O(N log log N); each n checks primes up to n with early breaks; practical.

## Real-world analogues and impact
- Detecting absence of a proposed decomposition.
  - Impact: Validates or rejects heuristics in data approximations.

## Takeaways
- Precompute primes; test the square condition for differences.
