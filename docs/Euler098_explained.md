# Euler098 — Anagramic squares

From a word list, find the largest square number formed by substituting digits for letters in an anagram pair.

## Approach

- Group words by sorted letters; for each group with size ≥ 2, consider all pairs.
- For word length L, precompute all L-digit squares and group them by digit pattern (isomorphic structure).
- For each word pair and square candidate, try a bijection letter→digit with no leading zero; verify both words map to squares; track the maximum.

## Edge Cases
- Leading zero: Reject mappings where the first letter of a word maps to 0.
- Non-bijective mapping: Ensure each letter maps to exactly one digit and vice versa; maintain two-way arrays.
- Repeated letters/digits: Patterns must match; mismatch early prune saves time.
- Word length mismatch: Only compare words of equal length within group; enforced by grouping.
- Performance: Pre-group squares by pattern to avoid testing all squares against all word pairs.

## Complexity
- Dominated by scanning squares per length and group pairs; feasible.

## Practical examples and business impact
- Pattern mining: structural isomorphism between token sequences and numbers.
- License plate decoding: bijective map validation between symbols and digits.
- Cryptanalysis toys: substitution patterns preserving structure.

## Key Takeaways
- Group anagrams; match structural digit pattern of squares via bijection search.

## Java implementation (Euler098.java)
- Loads `p098_words.txt` (quoted, comma-separated); otherwise prints `DATA_FILE_NOT_FOUND`.
- Groups words by sorted letters; for each anagram pair, considers square candidates of matching length grouped by structural pattern.
- Builds bijection letter→digit ensuring no leading zero and one-to-one mapping; checks both words map to squares; tracks max.
- Prints the largest such square.
