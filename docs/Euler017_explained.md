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
  - Problem: Convert amounts to words reliably (locale-aware).
  - Model: Deterministic formatter with British "and" rules.
  - Impact: Fewer errors; better compliance.

- Accessibility/readouts in dashboards
  - Problem: Narrate metrics naturally for screen readers.
  - Model: Number-to-words with proper punctuation rules; letter-count limits for UI.
  - Impact: Better UX without heavy dependencies.

- IVR/voice assistants
  - Problem: Speak numbers clearly to callers.
  - Model: Number-to-words with locale-specific phrasing.
  - Impact: Clearer interactions.

- Testing localization packs
  - Problem: Verify number rendering across languages.
  - Model: British baseline with letter-count checks as invariants.
  - Impact: Safer releases.

- Education content generators
  - Problem: Produce worksheets with numbers written in words.
  - Model: Programmatic number-to-words across ranges.
  - Impact: Scalable content creation.

- Compliance length constraints
  - Problem: Forms cap character counts.
  - Model: Letter counts post-normalization.
  - Impact: Filing success.

- Data quality pipelines
  - Problem: Detect malformed numeric text entries.
  - Model: Re-render numbers and compare to inputs.
  - Impact: Cleaner datasets.

- Bank statement reconciliation bots
  - Problem: Validate written-out amounts vs numeric fields.
  - Model: Dual rendering and comparison.
  - Impact: Fewer disputes.

- Document layout engines
  - Problem: Avoid line breaks in awkward positions.
  - Model: Pre-compute lengths from normalized words.
  - Impact: Better typography.

- Internationalization scoping
  - Problem: Estimate complexity for adding locales.
  - Model: Tally rule and dictionary size per language from a baseline.
  - Impact: Realistic roadmaps.

## Key takeaways

- Decompose by ranges; reuse small tables and a single formatter.
- Normalize then aggregate to keep counting logic simple.

## Java implementation (Euler017.java)

We build small word tables and a formatter function, then sum letter counts.

- Data: `ONES` array holds empty,"one".."nineteen"; `TENS` holds "","","twenty","thirty",...,"ninety".
- Formatter: `numberToWords(int n)`
  - 0 → "zero".
  - < 20 → from `ONES`.
  - < 100 → tens word + optional "-" + ones word.
  - < 1000 → `<ones> hundred` + (" and " + remainder) when remainder > 0.
  - 1000 → "one thousand" (exact).
- Counter: `letterCount(String words)` counts only lowercase letters a..z, ignoring spaces and hyphens.
- Aggregator: `totalLettersInRange(int from, int to)` sums `letterCount(numberToWords(n))` for n in the range.
- CLI: `main(String[] args)` defaults to 1..1000; optional args override start and end; prints the total.

Classroom notes:
- British usage rule: Include "and" between hundreds and the remainder, e.g., "one hundred and one".
- Normalization: Counting only [a-z] makes the letter tally unambiguous and easy to implement.
- Modularity: Separating formatting from counting simplifies testing and reuse.
