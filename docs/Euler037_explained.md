# Euler037 — Truncatable primes

Find the 11 primes that remain prime when truncating digits from left and right; return their sum.

## Approach

- Generate candidates by extending from known valid prefixes with allowed digits {1,3,7,9} and avoiding zeros.
- Check left and right truncations for primality using a sieve-backed primality test.
- Stop after finding 11.

## Edge Cases

- Single-digit primes: Not counted (must have at least two digits); ensure filter enforces this.
- Leading zeros after truncation: Not possible if zeros are excluded; if generation allowed zeros, truncations could create leading-zero interpretations—avoid.
- Primality test accuracy: Trial division sufficient for small range; for larger search spaces, use sieve or deterministic Miller–Rabin.
- Duplicate generation: Ensure each found truncatable prime counted once; maintain a set if using BFS/DFS with branching.
- Performance scaling: For larger digit lengths, constraint-based generation (prefix pruning) required; naive scanning grows expensive.
- Overflow: Not an issue under 32-bit for these values; for generalized problems with longer truncatable primes use long.

## Complexity
- Tiny search space with pruning; effectively instant.

## Practical examples and business impact

- URL/path robustness: ensure identifiers remain valid when truncated from either side (progressive disclosure/UIs).
- API versioning: test tokens that must preserve validity when prefixes/suffixes are added or stripped by gateways.
- Log redaction: simulate left/right truncation during PII redaction and verify tokens remain within allowed sets.
- Streaming ingestion: validate that partial/truncated messages keep checksum-valid prefixes and suffixes.
- Compiler tooling: ensure truncations of symbol names during minification keep unique, valid prefixes.
- DB sharding keys: design keys that maintain distribution even when truncated for short-form display.
- Security fuzzing: generate truncatable candidates to probe parser acceptance at every cut point.
- Numeric coding schemes: design progression where every left/right truncation remains in a permitted numeric class.
- Education: demonstrate invariants under truncation and the power of prefix/suffix filters.
- Observability: define alert IDs whose truncated forms still route to the correct service during UI shortening.

## Key Takeaways
- Build via BFS/DFS with digit constraints; verify all truncations prime.


## Java implementation (Euler037.java)

- Class: `Euler037`
- Helpers: `isPrime(int)` trial division; `isTruncatable(int)` verifies all left and right truncations are prime and n is prime and has at least two digits.
- Main: find the 11 truncatable primes by scanning odd integers, summing as found, and stop at 11; print the sum.
- Note: For speed you can generate candidates by appending digits {1,3,7,9} to valid prefixes, but the simple scan suffices here.
