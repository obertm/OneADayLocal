# Euler089 — Roman numerals

Given a list of Roman numerals, compute the total number of characters saved by writing them in their minimal form.

## Approach

- For each numeral, parse to integer (handle subtractive pairs: IV, IX, XL, XC, CD, CM).
- Re-encode to minimal form using greedy largest-symbol subtraction rules.
- Saved = originalLength − minimalLength; sum across all.

## Complexity
- O(total characters) parsing/encoding.

## Real-world impact
- Normalizing encodings to canonical minimal forms; easy audits of savings/efficiency.
