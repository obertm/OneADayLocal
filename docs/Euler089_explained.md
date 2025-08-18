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

## Java implementation (Euler089.java)
- Current file is a placeholder that prints `DATA_FILE_NOT_FOUND`.
- Intended structure:
	- Read `p089_roman.txt` (or similar dataset) lines.
	- For each line, parse value handling subtractive pairs (IV, IX, XL, XC, CD, CM).
	- Re-encode greedily to minimal Roman and compute length difference from the original.
	- Sum and print total savings.
- If you want, we can implement the full parser/encoder now and wire it to the dataset.
