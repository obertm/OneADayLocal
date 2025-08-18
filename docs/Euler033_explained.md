# Euler033 — Digit cancelling fractions

## Problem statement

Find the four non-trivial two-digit fractions that incorrectly “cancel” a common digit yet remain equal (excluding trivial cases like 30/50). Multiply them together and reduce to lowest terms; report the denominator.

## Step-by-step reasoning

1) Enumerate candidates
- Numerator n from 10..99, denominator d from n+1..99 to ensure a proper fraction. Skip any with trailing zero (trivial).

2) Try cancellations
- For overlapping digits, form the “cancelled” fraction n'/d' by removing one shared digit and compare n/d == n'/d'. Prefer exact cross-multiplication to avoid floating-point issues.

3) Aggregate and reduce
- Multiply the found fractions’ numerators and denominators; reduce the product by GCD to lowest terms.

## Reusable template (for enumerating quirky equivalences)

- Define and filter trivial/invalid cases early.
- Generate structured variants and test equality with exact arithmetic.
- Combine results and simplify at the end.

## Practical examples and business impact

- Model validation: surface counterexamples where heuristic simplifications produce correct-looking outputs for the wrong reasons.
- Data pipeline safety: simulate transformations (e.g., stripping shared characters) and prove when they corrupt ratios/metrics.
- A/B metrics integrity: detect “digit-cancelling” mistakes in KPI aggregation where shared denominators/numerators are accidentally dropped.
- Spreadsheet risk: audit formulas that cancel matching substrings; generate adversarial inputs to test robustness.
- Education: teach exact vs. approximate equality using cross-multiplication and counterexample generation.
- ETL dedup/merge: ensure record-linkage rules don’t over-simplify by cancelling common digits/characters improperly.
- Compression heuristics: evaluate when lossy simplifications preserve value vs. subtly drift (ratio invariants testing).
- APIs and gateways: fuzz request parameter pairs to ensure sanitization doesn’t improperly remove shared characters leading to invariant breaches.
- Scientific reproducibility: simulate numeric reductions where partial cancellation appears valid but breaks under exact arithmetic.
- Code reviews: checklist item to avoid shortcut simplifications; add unit tests for the four non-trivial cases as canaries.

## Key takeaways

- Enumerate carefully, avoid trivial zeros, compare exactly, and reduce at the end.

## Java implementation (Euler033.java)

- Helper: `gcd(int a, int b)` to reduce the final product.
- Search: n in 10..99, d in (n+1)..99; skip zeros; examine the four cancellation alignments and verify equality (the code uses doubles for convenience; cross-multiplication is an exact alternative).
- Output: after multiplying all qualifying fractions, reduce and print the denominator.
