# Euler017 — Number letter counts (1..1000)

Write numbers 1..1000 in words (British usage with "and"), count letters (ignore spaces/hyphens), and sum.

## Steps you can follow

1) Build small dictionaries
- Ones (1–9), teens (10–19), tens (20,30,…,90), and words for hundred, thousand.

2) Number-to-words function
- For 1..99: handle teens; else tens + optional hyphen + ones.
- For 100..999: hundreds + ("and" + sub-99) when remainder > 0.
- 1000 = "one thousand".

3) Count letters
- Remove spaces and hyphens, then count characters.

## Real-world analogues and impact
- Invoice/cheque printing and spoken-form conversions.
  - Impact: Deterministic, testable conversion logic.

## Takeaways
- Decompose by ranges and reuse small lookup tables; apply formatting rules once.
