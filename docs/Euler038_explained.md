# Euler038 — Pandigital concatenated product

Find the largest 1–9 pandigital 9-digit number that is the concatenated product of an integer with (1,2,...,n), n≥2.

## Plan

- n must start with 9 and be 4-digit at most (since 9xxx×(1,2) yields 9 digits). Search n in [9123..9876] or slightly broader.
- Concatenate n×1, n×2, ... until length ≥ 9; check pandigital when length==9; take max.

## Complexity
- Small loop with string building.

## Real-world analogues and impact
- Constructed identifiers from scaled copies; uniqueness checks.
  - Impact: Guarantees dense, constraint-satisfying IDs.

## Takeaways
- Narrow to 4-digit seeds and test concatenated products for pandigitality.


## Java implementation (Euler038.java)

- Class: `Euler038`
- Helpers: `isPandigital(String)` for 1–9; `concatProduct(int x)` builds the concatenated string of x×1, x×2, ... until 9+ chars.
- Main: iterate x from 1 to 9999; if the concatenation has length 9 and is pandigital, parse to int and track the maximum; print the best value.
