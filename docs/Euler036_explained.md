# Euler036 — Double-base palindromes

Sum all numbers < N that are palindromic in both base 10 and base 2.

## Recipe

- Iterate odd numbers only (binary palindrome cannot end with 0 unless zero).
- Check palindrome in base 10 and base 2 (string or numeric reversal).

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

## Takeaways
- Restrict to odds; test palindromicity in both bases.


## Java implementation (Euler036.java)

- Class: `Euler036`
- Helper: `isPal(String s)` two-pointer palindrome checker.
- Main: optional limit argument (default 1,000,000); loop `i` from 1 to limit-1, check decimal pal, then binary pal via `Integer.toBinaryString(i)`. Sum and print.
- Micro-optimizations (optional): iterate only odd `i`; generate decimal palindromes directly to cut checks.
