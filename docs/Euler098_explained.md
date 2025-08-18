# Euler098 — Anagramic squares

From a word list, find the largest square number formed by substituting digits for letters in an anagram pair.

## Approach

- Group words by sorted letters; for each group with size ≥ 2, consider all pairs.
- For word length L, precompute all L-digit squares and group them by digit pattern (isomorphic structure).
- For each word pair and square candidate, try a bijection letter→digit with no leading zero; verify both words map to squares; track the maximum.

## Complexity
- Dominated by scanning squares per length and group pairs; feasible.

## Real-world impact
- Isomorphism-based mapping between symbol sequences and numbers.

## Java implementation (Euler098.java)
- Loads `p098_words.txt` (quoted, comma-separated); otherwise prints `DATA_FILE_NOT_FOUND`.
- Groups words by sorted letters; for each anagram pair, considers square candidates of matching length grouped by structural pattern.
- Builds bijection letter→digit ensuring no leading zero and one-to-one mapping; checks both words map to squares; tracks max.
- Prints the largest such square.
