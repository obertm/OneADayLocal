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
