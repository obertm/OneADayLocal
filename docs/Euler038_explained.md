# Euler038 — Pandigital concatenated product

Find the largest 1–9 pandigital 9-digit number that is the concatenated product of an integer with (1,2,...,n), n≥2.

## Approach

- n must start with 9 and be 4-digit at most (since 9xxx×(1,2) yields 9 digits). Search n in [9123..9876] or slightly broader.
- Concatenate n×1, n×2, ... until length ≥ 9; check pandigital when length==9; take max.

## Edge Cases

- Leading zeros: Any concatenated result containing '0' invalid; skip early when a zero digit encountered.
- Length overshoot: If concatenated string exceeds 9 digits, abandon that n; further multiples only lengthen it.
- Duplicate digits: Immediately reject; track with a bitmask/boolean array for speed.
- n with internal zeros: Often wastes work; pre-skip if base number contains 0 to avoid inevitable invalid concatenations.
- Performance: Search space small; for generalized problems with larger digit sets, derive tighter bounds.
- Overflow: Multiplying n by small integers safe in int; if scaling to larger digits, switch to long.

## Complexity
- Small loop with string building.

## Practical examples and business impact

- Synthetic ID design: build IDs from scaled copies of a seed to satisfy digit coverage and ordering constraints.
- Data generation for benchmarks: produce concatenated product sequences to stress test parsers and dedup systems.
- Telemetry synthesis: simulate sensors where harmonics (×1, ×2, ×3, …) are concatenated into a single stream; validate structure.
- Quality control: confirm that serials composed from repeated scale factors meet format constraints.
- Game/lottery systems: construct “valid ticket” numbers from scaled pieces under strict digit rules to model collision rates.
- Network packet crafting: stitch scaled header components to fill exact field widths while meeting uniqueness.
- Cryptanalysis toys: search constructed concatenations as proxy CSPs to teach constraint pruning.
- E-commerce SKUs: generate composite SKUs from multiples of a base to hit prescribed digit patterns for legacy systems.
- Educational demos: show how tight bounds reduce search drastically when building structured concatenations.
- Fuzz testing: craft concatenations to hit every digit exactly once, probing validators and sanitizer edge cases.

## Key Takeaways
- Narrow to 4-digit seeds and test concatenated products for pandigitality.


## Java implementation (Euler038.java)

- Class: `Euler038`
- Helpers: `isPandigital(String)` for 1–9; `concatProduct(int x)` builds the concatenated string of x×1, x×2, ... until 9+ chars.
- Main: iterate x from 1 to 9999; if the concatenation has length 9 and is pandigital, parse to int and track the maximum; print the best value.
