# Euler055 — Lychrel numbers (reverse-and-add)

Count how many numbers below 10,000 never form a palindrome within 50 reverse-and-add iterations.

## Method

- For n in 1..9999: iterate up to 50 times: n = n + reverse(n) using big integers; if a palindrome appears, mark non-Lychrel.
- Count those that never hit a palindrome within the limit.

## Complexity
- O(10000 × 50 × digits) with small big-int overhead.

## Real-world analogues and impact
- Iterative refinement processes with stopping criteria.
  - Impact: Bounded iteration ensures predictable runtime.

## Takeaways
- Use BigInteger to avoid overflow; clear iteration cap and palindrome checks.
