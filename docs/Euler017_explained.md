# Euler017 — Number letter counts (1..1000)

Write numbers 1..1000 in words (British usage with "and"), count letters (ignore spaces/hyphens), and sum.

## Problem statement

Convert each integer from 1 to 1000 inclusive to its British English words, remove spaces and hyphens, count letters, and return the total across all numbers.

## Step-by-step reasoning

1) Build small dictionaries
- Ones (1–9), teens (10–19), tens (20,30,…,90), and words for hundred, thousand.

2) Number-to-words function
- For 1..99: handle teens; else tens + optional hyphen + ones.
- For 100..999: `<ones> hundred` + (" and " + sub-99) when remainder > 0.
- 1000 = "one thousand".

3) Count letters
- Remove spaces and hyphens, then count characters.

4) Complexity
- O(N) numbers with O(1) work each; dictionary lookups dominate.

5) Edge cases
- Exact hundreds (“three hundred”) should not include “and”.
- British usage requires “and” when a remainder exists.

## Reusable template (for similar problems)

When converting numeric ranges to words and aggregating properties:
- Build lookups for small parts; decompose into standard ranges (1..99, hundreds, thousands).
- Apply locale-specific glue rules once in a helper.
- Normalize output before counting (e.g., strip spaces/hyphens).

## Practical examples and business impact

- Invoice/cheque printing and spoken-form conversions
  - Deterministic, testable conversion logic for financial docs.
  - Impact: Fewer human errors and better compliance.

- Accessibility/readouts in dashboards
  - Convert numbers to readable form for narration; count/limit length for UI.
  - Impact: Improves UX without external dependencies.

## Key takeaways

- Decompose by ranges; reuse small tables and a single formatter.
- Normalize then aggregate to keep counting logic simple.
