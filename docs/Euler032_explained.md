# Euler032 — Pandigital products

Find all products whose multiplicand, multiplier, and product concatenated form a 1–9 pandigital number; sum distinct products.

## Strategy

- Bounds: If a has 1 digit, b must have 4 digits (1×4=5 total with product 4 digits), or a has 2 digits and b has 3 digits.
- Iterate feasible ranges; check concatenation length=9 and is pandigital; collect product in a set to deduplicate.

## Complexity
- Small brute force with string checks; manageable.

## Real-world analogues and impact
- Constraint checks with concatenated identifiers; uniqueness validation.
  - Impact: Safe enforcement of composite-key integrity.

## Takeaways
- Use tight bounds and a set for unique products; simple digit-set tests suffice.


## Java implementation (Euler032.java)

- Class: `Euler032`
- Helper: `isPandigital(String s)` checks 1–9 pandigital by tracking digits in a boolean[10].
- Main loop:
  - Iterate `a` from 2 to 99.
  - For `b`, use plausible ranges so that `a*b` and the concatenation produce 9 digits.
  - Build `s = "" + a + b + prod`; if `s.length() == 9` and is pandigital, add `prod` to a `HashSet<Integer>` to dedupe.
- Output: Sum of distinct products from the set.
