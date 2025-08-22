# Euler026 — Reciprocal cycles

## Problem statement

For d < N, which denominator d yields the longest recurring cycle in the decimal expansion of 1/d?

## Step-by-step reasoning

## Approach

Strip factors 2 and 5 from d, then compute multiplicative order of 10 modulo the reduced denominator via repeated modular multiplication; track maximum order.

1) Remove factors of 2 and 5
- Let d' be d with all 2s and 5s removed. If d' = 1, the decimal terminates and the cycle length is 0.

2) Multiplicative order
- The cycle length is the smallest k such that 10^k ≡ 1 (mod d'). Compute it by iterating `mod = (mod*10) % d'` until `mod == 1`, counting steps.
- With φ(d') and factorization you can speed this up by checking divisors, but brute-force is sufficient for N ≤ 1000.

## Edge Cases

- d divisible only by 2 and/or 5 → d' = 1 → cycle length 0 (terminating decimal). Must short-circuit to avoid infinite loop.
- Large N: For bigger bounds, brute-force order can be slow for numbers with large φ(d'); consider factoring d' and testing divisors of φ(d').
- Performance: Ensure modulo operation uses int; avoid BigInteger until necessary.
- Off-by-one: Initialize length counting correctly (e.g., start len=1 with mod=10%d' or start len=0 and loop before increment) to avoid +/−1 errors.
- Overflow: 10*mod stays within int for mod< N (N ≤ 10000 typical). For huge N, use long.
- Skipping non-coprime bases: After stripping 2/5, remaining denominator is coprime with 10; verify assumption.

## Reusable template (for repeating decimal/period problems)

- Normalize denominator by removing base-prime factors (2 and 5 for base 10).
- Use multiplicative order of the base modulo the reduced denominator.
- Track remainders or use divisor testing on φ(n) if factorization is cheap.

## Practical examples and business impact

- Pseudorandom generators: period analysis for LCGs and modular sequences.
- Cryptography/math libraries: understanding multiplicative orders and cyclic groups.

## Key Takeaways

- Cycle length = multiplicative order of 10 modulo d' after removing 2s and 5s.

## Java implementation (Euler026.java)

We scan d in [2, N) and compute the multiplicative order after stripping 2s and 5s.

- Reduction: divide d by 2 and 5 while possible; if it becomes 1, length is 0.
- Order loop: start `len = 1`, `mod = 10 % d`, repeatedly `mod = (mod*10) % d` until `mod == 1`.
- Track best (length, d) and print the arg-max denominator.
