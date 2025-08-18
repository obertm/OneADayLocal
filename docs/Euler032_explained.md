# Euler032 — Pandigital products

## Problem statement

Find all products where multiplicand, multiplier, and product concatenated form a 1–9 pandigital number. Sum the distinct products.

## Step-by-step reasoning

1) Tight bounds
- If a has 1 digit, b must have 4 digits (so that a, b, and a·b together have 9 digits). If a has 2 digits, b has 3 digits. Other splits can’t produce exactly 9 digits in total.

2) Search and test
- Iterate feasible ranges; compute product p = a·b; form s = a||b||p; check length is 9 and s is pandigital over {1..9}.
- Add p to a set to deduplicate, then sum the set.

## Reusable template (for constrained pandigital concatenations)

- Derive digit-length bounds to avoid wasted checks.
- Use a boolean[10] or bitmask to validate digits quickly.
- Deduplicate results via a set.

## Practical examples and business impact

- Composite key generation: simulate schemas where concatenated fields must satisfy coverage constraints (e.g., unique digits/classes) to reduce collisions.
- Data quality audits: detect malformed IDs that don’t satisfy structure constraints (pandigital-like rules) across multiple systems.
- Sensor fusion: check that combined signal encodings cover all required symbol spaces (e.g., 1–9) to guarantee observability.
- Cryptanalysis toy models: search concatenated plaintext/ciphertext pairs that hit digit coverage as a proxy for constraint satisfaction problems.
- QA test-case generation: systematically produce input triples that satisfy tight structural rules for parser/validator testing.
- Inventory labeling: ensure product+batch+checksum concatenations hit a digit coverage target to minimize human error recognition failures.
- Distributed tracing: simulate span-id concatenations with coverage properties to improve uniqueness across services.
- Packet header design: evaluate field concatenations against coverage and collision risks under constrained bit budgets.
- Randomized load testing: generate pandigital-like inputs to stress hash functions and normalization pipelines.
- Education/assessment: teaching constraint pruning and search bounds; students can simulate how narrowing digit-length drastically shrinks search.

## Key takeaways

- Bounding by digit-length math makes the brute force tiny; simple digit-set checks are enough.

## Java implementation (Euler032.java)

- Helper: `isPandigital(String s)` ensures length 9 and digits 1..9 appear exactly once.
- Loop: iterate a in 2..99; choose b ranges to keep total digits at 9; validate concatenation.
- Set: add each valid product to `HashSet<Integer>` and sum distinct values at the end.
