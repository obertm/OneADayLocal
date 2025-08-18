# Euler034 — Digit factorials

Find all numbers equal to the sum of the factorial of their digits; return their sum (excluding 1 and 2).

## Plan

- Precompute fact[0..9].
- Upper bound: for d digits, max sum = d·9!; smallest d with d·9! < 10^{d-1} gives a cap (~2,540,160). Use a tighter known bound (~7·9! = 2,540,160) and scan from 10.
- Check each n by summing fact[digit].

## Complexity
- O(limit × digits) with small constants.

## Real-world analogues and impact
- Feature sums over digits/characters with cached contributions.
  - Impact: Turns brute force into an efficient linear pass.

## Takeaways
- Cache digit factorials and apply a hard upper bound; scan and test.


## Java implementation (Euler034.java)

- Class: `Euler034`
- Precompute `fact[0..9]` once; upper bound `ub = 7 * fact[9]` (2,540,160).
- Loop `n` from 10 to `ub`:
  - Sum `fact[d]` over the digits of `n`.
  - If the sum equals `n`, add to `total`.
- Print the final `total`.
