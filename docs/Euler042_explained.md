# Euler042 — Coded triangle numbers

Count how many words in a list have a letter-sum that is a triangular number.

## Steps

- Word value: sum(ch - 'A' + 1) for letters.
- Precompute triangle numbers up to a safe max value and place in a HashSet.
- For each word, compute value and test membership.

## Complexity
- O(total characters) after O(T) precompute.

## Real-world analogues and impact
- Score-to-class membership checks.
  - Impact: Fast lookups using precomputed sets for ranges.

## Takeaways
- Precompute triangle set; linear scan over words; constant-time membership.


## Java implementation (Euler042.java)

- Class: `Euler042`
- Input: CSV of quoted words (default `p042_words.txt`); you can pass a path as the first CLI arg.
- Helpers: `wordValue(String)` mapping A/Z or a/z to 1..26.
- Steps in code:
  - Read and clean CSV to a list of words; track the maximum word value.
  - Precompute a boolean array `tri[]` marking triangle numbers up to the maximum.
  - Count words whose value is triangle and print the count.
