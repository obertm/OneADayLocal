# Euler042 — Coded triangle numbers

Count how many words in a list have a letter-sum that is a triangular number.

## Approach

Compute each word's alphabetical value, precompute all triangle numbers up to the maximum possible word value (derived from length × 26), store in a fast membership structure (boolean array or HashSet), and count hits in a single pass.

- Word value: sum(ch - 'A' + 1) for letters.
- Precompute triangle numbers up to a safe max value and place in a HashSet.
- For each word, compute value and test membership.

## Edge Cases

- Empty words: Ignore after trimming; they contribute value 0 which is not triangular (T1=1).
- Mixed case: Normalize to uppercase before mapping values to maintain consistency.
- Non-letter characters: Filter or reject; including them distorts sums; safest is skip words containing invalid chars.
- Very long words: Ensure triangle precompute bound covers maxLen*26; compute bound dynamically.
- Duplicate words: Each counted separately per problem semantics.
- Memory: Triangle boolean array sized to max word value; for very large files ensure bound calculation doesn't over-allocate.
- Performance: O(total chars); hashing cost minimal; for huge data sets, prefer boolean array over HashSet.

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

## Key Takeaways
- Precompute triangle set; linear scan over words; constant-time membership.


## Java implementation (Euler042.java)

- Class: `Euler042`
- Input: CSV of quoted words (default `p042_words.txt`); you can pass a path as the first CLI arg.
- Helpers: `wordValue(String)` mapping A/Z or a/z to 1..26.
- Steps in code:
  - Read and clean CSV to a list of words; track the maximum word value.
  - Precompute a boolean array `tri[]` marking triangle numbers up to the maximum.
  - Count words whose value is triangle and print the count.
