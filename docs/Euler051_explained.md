# Euler051 — Prime digit replacements

Find the smallest prime that, by replacing certain repeated digits with the same digit, yields an eight-prime family.

## Strategy

- Sieve primes; for each prime p (skip ones ending in even/5), try masks over positions of a chosen digit (e.g., 0,1,2).
- For a mask, replace those positions with digits 0..9 (respect no-leading-zero), count how many results are prime.
- Stop when a mask produces ≥ 8 primes; record the smallest member of that family.

## Complexity
- Manageable with pruning: only replace digits that occur ≥ 1 and avoid last-digit replacement to even/5.

## Practical examples and business impact

- Mask-based search: generate variants by masking positions and sweeping replacements; membership via fast tests.
- Feature toggling: simulate flags (masked digits) applied uniformly to generate many candidates quickly.
- A/B testing: produce cohorts by replacing masked positions and keep only those passing a property (e.g., prime-like test).
- Security fuzzing: masked replacements probe parsers with systematic coverage.
- Data quality: enforce “same-digit replacement” rules to create families and test validation robustness.
- Compression testing: evaluate masked patterns to see which substitutions preserve constraints.
- Compiler/optimizer knobs: mask config bits and replace consistently to find families satisfying performance thresholds.
- Synthetic data: generate equivalence classes under masked replacements for model training.
- Education: demonstrate bitmask enumeration strategies and pruning rules.
- Search acceleration: prefilter by last-digit constraints before exploring masks to avoid even/5 endings.

## Takeaways
- Enumerate bitmasks on repeated digits; replace and count primes; prune by obvious digit rules.


## Java implementation (Euler051.java)

- Class: `Euler051`
- Sieve: boolean array up to a generous limit (2,000,000 in code) for primality tests.
- For each prime p:
  - Generate non-empty bitmasks over its digit positions; keep masks where all masked positions share the same original digit.
  - For each mask, try replacements 0..9 (skip leading-zero cases), count how many results are prime and track the smallest.
  - If count ≥ 8, return that smallest prime; print result in main.
