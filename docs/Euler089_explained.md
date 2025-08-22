# Euler089 — Roman numerals

Given a list of Roman numerals, compute the total number of characters saved by writing them in their minimal form.

## Approach

- For each numeral, parse to integer (handle subtractive pairs: IV, IX, XL, XC, CD, CM).
- Re-encode to minimal form using greedy largest-symbol subtraction rules.
- Saved = originalLength − minimalLength; sum across all.

## Edge Cases
- Invalid numerals: Repeated beyond allowed (e.g., V, L, D cannot repeat); decide whether to ignore or validate strictly.
- Subtractive misuse: Only valid pairs (IV, IX, XL, XC, CD, CM); reject others like IL, IC.
- Case sensitivity: Assume uppercase; normalize input if mixed case.
- Empty line handling: Skip blank lines; they contribute zero savings.
- Large numbers: Standard Roman stops at 3999 (overlines for higher); dataset likely within; document assumption.

## Complexity
- O(total characters) parsing/encoding.

## Practical examples and business impact
- Data normalization: canonical form enforcement and savings measurement.
- Text compression: quantify redundancy removed by canonical encoding.
- Validation: detect non-minimal representations in legacy datasets.

## Key Takeaways
- Parse with subtractive pairs; greedy re-encode; accumulate character savings.

## Java implementation (Euler089.java)
- Current file is a placeholder that prints `DATA_FILE_NOT_FOUND`.
- Intended structure:
	- Read `p089_roman.txt` (or similar dataset) lines.
	- For each line, parse value handling subtractive pairs (IV, IX, XL, XC, CD, CM).
	- Re-encode greedily to minimal Roman and compute length difference from the original.
	- Sum and print total savings.
- If you want, we can implement the full parser/encoder now and wire it to the dataset.
