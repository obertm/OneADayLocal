# Euler042 — Coded triangle numbers

Count how many words in a list have a letter-sum that is a triangular number.

## Steps

- Word value: sum(ch - 'A' + 1) for letters.
- Precompute triangle numbers up to a safe max value and place in a HashSet.
- For each word, compute value and test membership.

## Complexity
- O(total characters) after O(T) precompute.

## Practical examples and business impact

- Feature scoring: map tokens to numeric scores and test membership in special score classes.
- Education: show precompute+set membership as a universal trick for fast classification.
- NLP toy models: word scores to buckets; triangle numbers as proxy labels for exercises.
- Gaming: assign “triangle score” achievements to names/tags deterministically.
- Data cleansing: flag strings whose letter-sum lands in suspect buckets for manual review.
- Simulation: large-scale scans using boolean membership arrays to bound per-item cost.
- Security: quick signature checks comparing sums to precomputed sets.
- Embedded systems: precompute small membership arrays for O(1) checks on constrained hardware.
- Caching strategy: demonstrate when to trade memory for speed by precomputing membership.
- Test generation: construct inputs targeting or avoiding triangle buckets to exercise branches.

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
