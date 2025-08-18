# Euler033 — Digit cancelling fractions

Find non-trivial two-digit fractions that incorrectly "cancel" a common digit yet remain equal; multiply them and reduce to lowest terms.

## Method

- Iterate numerator n=10..99, denominator d=n+1..99; skip trivial cases with zeros.
- For overlapping digits, try cancellations and compare n/d to n'/d' exactly (cross-multiply to avoid FP).
- Multiply all found fractions and reduce by GCD.

## Complexity
- ~O(10^4) checks; trivial.

## Real-world analogues and impact
- Detecting invalid simplification rules that happen to pass tests.
  - Impact: Prevents faulty heuristics in data normalization.

## Takeaways
- Enumerate carefully, avoid zero-ending, compare via cross-multiplication; reduce at the end.


## Java implementation (Euler033.java)

- Class: `Euler033`
- Helper: `gcd(int a, int b)` via Euclid to reduce the final product of fractions.
- Search:
  - Iterate `a` in 10..99, `b` in (a+1)..99; skip trivial zeros.
  - Consider the four digit-cancellation cases; verify equality with exact arithmetic (in code this uses double for simplicity, but you can equivalently cross-multiply to avoid FP).
  - Accumulate the resulting numerator and denominator products.
- At the end, reduce by `gcd` and print the denominator.
