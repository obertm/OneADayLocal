# Euler035 — Circular primes below N

## Problem statement

Count the primes below N that remain prime under all rotations of their digits.

## Approach

Sieve primes up to N once, prune any multi-digit candidate containing digits that force a composite rotation (even digits or 5), then for remaining primes test all cyclic rotations for primality via the sieve.

## Step-by-step reasoning

1) Sieve primes
- Build a primality array up to N (Sieve of Eratosthenes).

2) Prune impossible candidates
- Any multi-digit number containing {0,2,4,5,6,8} will produce a composite rotation (even or multiple of 5). Skip them.

3) Check rotations
- For each remaining candidate, generate all digit rotations and ensure each one is prime via the sieve.

## Edge Cases

- Single-digit primes: 2,3,5,7 are circular by definition; must include (despite containing forbidden digits logic—handle separately).
- Digit 5 and even digits: Multi-digit numbers containing them should be skipped; ensure logic doesn’t wrongly skip single-digit prime 5 or 2.
- Leading zeros: Rotations should not introduce leading zeros because digits 0 are excluded; if 0 present, skip candidate.
- Large N memory: Sieve memory O(N); for very large N switch to segmented sieve.
- Rotation generation: Avoid redundant checks; pre-stop if any rotation composite.
- Performance: Strings vs numeric rotation; numeric approach faster (split high and low parts) but string is fine for Euler bound.

## Reusable template (for rotation-invariant filters)

- Precompute membership (primality) once.
- Use digit/property pruning to cut the search space.
- Verify the invariance under all cyclic shifts.

## Practical examples and business impact

- Rotation-invariant identifiers: design IDs that remain valid under sensor/camera rotations (e.g., rotated readings still parse).
- Cryptographic toy models: explore rotation-closed sets to illustrate invariants in block transformations.
- Manufacturing labels: ensure cyclic barcode encodings don’t yield invalid codes when read from arbitrary starting offsets.
- Network tokenization: test cyclic shift robustness in protocol tokens to avoid accidental valid-but-rotated collisions.
- Stream ciphers education: simulate keystream rotations and filter invalid states quickly via pruning.
- Monitoring systems: rotate time-windowed feature vectors; keep only those whose rotations satisfy thresholds (anomaly detection).
- Genetic sequence analysis: cyclic rotations of k-mers; prune impossible motifs early.
- Compiler tooling: detect rotation-invariant substrings in code obfuscation and remove trivial patterns.
- Search optimization: show how pruning rules cut orders of magnitude from brute force in combinatorial scans.
- Data compression: analyze circular shifts in strings to maintain validity under LZ-like transforms.

## Complexity

Time: O(N log log N) for sieve plus rotation checks on a pruned subset (cheap). Space: O(N) for sieve.

## Key Takeaways

- Sieve + pruning + rotation checks solve this comfortably for N up to 1e6.

## Java implementation (Euler035.java)

- Sieve builder: `boolean[] sieve(int n)`.
- Pruning: reject multi-digit numbers containing forbidden digits.
- Rotation check: rotate strings and test each rotation via the sieve.
- CLI: optional limit (default 1_000_000), print the count of circular primes below it.
