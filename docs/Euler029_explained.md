# Euler029 — Distinct powers

## Problem statement

How many distinct values are in the set { a^b | 2 ≤ a ≤ A, 2 ≤ b ≤ B }?

## Step-by-step reasoning

## Approach

Enumerate a,b ranges, compute BigInteger a^b, insert into a HashSet to deduplicate; report set size.

1) Use exact big integers
- Compute BigInteger.valueOf(a).pow(b) and store results in a hash set to deduplicate.

2) Optional normalization
- You can normalize perfect powers by factoring a (e.g., 4^3 = 2^6) to reduce duplicates analytically, but it’s unnecessary for A = B = 100.

## Edge Cases

- Bounds reversed or invalid: Ensure A,B ≥ 2; swap or throw if inputs inverted.
- Overflow avoidance: Use BigInteger; long overflow for large exponents otherwise.
- Memory: Number of distinct results ≤ (A-1)*(B-1); still manageable; for huge ranges consider exponent normalization to reduce storage.
- Performance: pow(b) complexity grows with log exponent; caching repeated BigInteger.valueOf(a) objects micro-optimizes.
- Duplicate generation: Equivalent powers (e.g., 4^3 vs 8^2) create duplicates naturally handled by the set; analytic dedupe optional.
- Leading/trailing spaces in CLI args: trim and parse carefully.

## Reusable template (for exact-value deduping)

- Choose an exact arithmetic type to represent the values.
- Generate results and insert into a set keyed by value.
- Return the set size.

## Practical examples and business impact

- Deduplication of generated keys, signatures, or hashes where collisions are mathematical equivalences.
- Confidence via exact arithmetic avoids subtle overflow/rounding issues.

## Key Takeaways

- BigInteger + HashSet is clear, correct, and fast at this scale.

## Java implementation (Euler029.java)

We enumerate a and b, exponentiate exactly, and deduplicate with a hash set.

- Args: optional (aMin, aMax, bMin, bMax), defaults to 2..100.
- Core: nested loops compute `BigInteger.valueOf(a).pow(b)` and add to `Set<BigInteger>`.
- Output: print `set.size()`.
