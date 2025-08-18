# Euler036 — Double-base palindromes

Sum all numbers < N that are palindromic in both base 10 and base 2.

## Recipe

- Iterate odd numbers only (binary palindrome cannot end with 0 unless zero).
- Check palindrome in base 10 and base 2 (string or numeric reversal).

## Complexity
- O(N) with light checks; or generate palindromes directly to reduce work.

## Real-world analogues and impact
- Dual-format validation (e.g., compatibility across encodings).
  - Impact: Simple integrity checks over multiple representations.

## Takeaways
- Restrict to odds; test palindromicity in both bases.


## Java implementation (Euler036.java)

- Class: `Euler036`
- Helper: `isPal(String s)` two-pointer palindrome checker.
- Main: optional limit argument (default 1,000,000); loop `i` from 1 to limit-1, check decimal pal, then binary pal via `Integer.toBinaryString(i)`. Sum and print.
- Micro-optimizations (optional): iterate only odd `i`; generate decimal palindromes directly to cut checks.
