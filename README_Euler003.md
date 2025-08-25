# Euler003: Largest Prime Factor

## Original Goal
Compute the largest prime factor of a given `long` (Project Euler Problem 3). Input example: `600851475143` → `6857`.

## Previous Implementation
- Stripped factors of 2 using bit test and shift.
- Trial-divided every odd number `f = 3,5,7,...` while `f * f <= n`.
- Complexity: O(sqrt(n)) divisions; candidate density ~ 1/2 of integers (all odds).

## Optimization Applied (2025-08-25)
Commit introduces constant-factor speedups without changing asymptotic complexity:
1. Early elimination of factor 3, mirroring the existing specialized handling for 2.
2. Switch to a 6k ± 1 wheel: after removing 2 & 3, all remaining prime candidates are of the form 6k−1 or 6k+1, cutting trial divisions to 2 per 6 numbers (instead of 3 odds per 6 previously) ⇒ ~33% fewer modulus operations in the main loop.
3. Overflow-safe loop guard `f <= n / f` instead of `f * f <= n` (defensive, though overflow unlikely at these magnitudes).
4. Added argument validation (`n >= 2`) and early returns when `n` reduces to 1 after stripping small primes.
5. Minor readability & comment improvements.

## Resulting Method Outline
```
- Remove factor 2 completely
- Remove factor 3 completely
- For f = 5; f <= n / f; f += 6:
    - Test f (6k−1) repeatedly
    - Test f+2 (6k+1) repeatedly
- If remaining n > 1, it is prime and is the answer
```

## Performance Notes
For the Euler target input (~6e11), both versions finish instantly. The optimization matters more when factoring many large numbers or numbers with large prime factors near sqrt(n). Division count reduction is roughly one third in the main loop.

## Possible Future Enhancements (Not Implemented)
- Integrate a deterministic Miller–Rabin primality check (for 64-bit) to skip residual looping once `n` becomes prime.
- Use a precomputed small prime list when factoring many values in batch.
- Extend to 30k wheel for further (smaller) constant-factor gains; likely unnecessary here.

## Correctness
All existing tests (`EulerTests.test003`) continue to pass after the change.

## File Modified
- `Euler003.java`

## Added File
- `README_Euler003.md` (this document)

