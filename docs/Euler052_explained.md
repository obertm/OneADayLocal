# Euler052 — Permuted multiples

Find the smallest x such that {2x,3x,4x,5x,6x} are all permutations of x’s digits.

## Method

- Iterate x, checking that digit-count signature of kx matches x for k=2..6.
- Early bounds: number of digits must remain constant across 6x, so x must be at least 10^{d-1} and less than 10^d/6.

## Complexity
- O(candidates × digits), very fast with signature comparison.

## Real-world analogues and impact
- Permutation-invariance checks across scaled values (e.g., ID formats).
  - Impact: Lightweight signature comparisons prevent expensive string work.

## Takeaways
- Constrain by digit-length; use frequency arrays (10-sized) for equality checks.


## Java implementation (Euler052.java)

- Class: `Euler052`
- Approach: Increment x from 1 upward, compute a sorted-digit signature for x; check that for k=2..6, `signature(k*x)` matches.
- Helper: `signature(int)` sorts the digits into a canonical string for O(d log d) comparison.
- Output: The first x that satisfies the property.
