# Euler037 — Truncatable primes

Find the 11 primes that remain prime when truncating digits from left and right; return their sum.

## Strategy

- Generate candidates by extending from known valid prefixes with allowed digits {1,3,7,9} and avoiding zeros.
- Check left and right truncations for primality using a sieve-backed primality test.
- Stop after finding 11.

## Complexity
- Tiny search space with pruning; effectively instant.

## Real-world analogues and impact
- Validity under prefix/suffix removal (e.g., URL/path robustness, progressive disclosure of identifiers).
  - Impact: Ensures stability across incremental views.

## Takeaways
- Build via BFS/DFS with digit constraints; verify all truncations prime.


## Java implementation (Euler037.java)

- Class: `Euler037`
- Helpers: `isPrime(int)` trial division; `isTruncatable(int)` verifies all left and right truncations are prime and n is prime and has at least two digits.
- Main: find the 11 truncatable primes by scanning odd integers, summing as found, and stop at 11; print the sum.
- Note: For speed you can generate candidates by appending digits {1,3,7,9} to valid prefixes, but the simple scan suffices here.
