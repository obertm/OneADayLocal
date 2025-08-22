# Euler036 — Double-base palindromes

Sum all numbers < N that are palindromic in both base 10 and base 2.

## Approach

Iterate only odd numbers (except 0) below N (binary palindromes cannot end with 0). Check decimal palindromicity and then binary palindromicity via string reversal or two-pointer checks. Optionally generate decimal palindromes directly to skip non‑palindromic candidates.

## Recipe

- Iterate odd numbers only (binary palindrome cannot end with 0 unless zero).
- Check palindrome in base 10 and base 2 (string or numeric reversal).

## Edge Cases

- N ≤ 1: Sum is 0 (exclusive) or 1 includes 1; define inclusivity clearly.
- Even candidates: Skip all even > 0 since binary form ends with 0; ensures no false positives.
- Leading zeros: Palindrome checks must not allow leading zeros; numeric approach avoids this.
- Performance: For large N, generating palindromes (both odd/even-length) instead of scanning reduces complexity drastically.
- Memory: String allocations per candidate; optimize with char arrays or numeric reversal if needed.
- Duplicate counting: Ensure each value added once; no multi-representation duplicates.

## Complexity
- O(N) with light checks; or generate palindromes directly to reduce work.

## Practical examples and business impact

- Dual-encoding validation: verify identifiers remain valid under decimal and binary encodings (e.g., device IDs across protocols).
- Cross-serialization checks: ensure values serialize/deserialze symmetrically across base10 and base2 paths in heterogeneous systems.
- Firmware images: sanity-check mirrored header/trailer patterns in both human-readable and bit-level representations.
- Data integrity in ETL: run palindromicity tests in multiple encodings to catch corruption introduced by format conversions.
- CQRS/event sourcing: ensure event keys maintain invariants across read/write stores that encode IDs differently.
- Telemetry pipelines: detect reversible bit-patterns that should read the same forward/backward in ring buffers.
- Security toy models: illustrate multi-representation invariants for steganography/watermarking demos.
- Compression testing: craft numbers with symmetric bit patterns to probe compressor edge cases.
- Embedded systems: build fast palindrome checks using bitwise operations for binary and decimal on constrained hardware.
- Education/simulation: generate dual-base palindromes to demonstrate representation effects and test conversion functions at scale.

## Complexity

Time: O(N) basic scan (with early pruning), or much less if generating palindromes. Space: O(1).

## Key Takeaways
- Restrict to odds; test palindromicity in both bases.


## Java implementation (Euler036.java)

- Class: `Euler036`
- Helper: `isPal(String s)` two-pointer palindrome checker.
- Main: optional limit argument (default 1,000,000); loop `i` from 1 to limit-1, check decimal pal, then binary pal via `Integer.toBinaryString(i)`. Sum and print.
- Micro-optimizations (optional): iterate only odd `i`; generate decimal palindromes directly to cut checks.
