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
