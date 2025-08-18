# Euler058 — Spiral primes ratio

Build the number spiral and find the side length where the ratio of primes on the diagonals first falls below 10%.

## Plan

- For each odd side s=3,5,7,..., corners are s^2, s^2−(s−1), s^2−2(s−1), s^2−3(s−1). Test the three non-square corners for primality.
- Track total diagonal count (=2s−1) and prime count; stop when ratio < 0.10.

## Complexity
- O(#layers) primality checks; fast with a strong primality test.

## Real-world analogues and impact
- Monitoring the decline of a signal against total observations.
  - Impact: Detect thresholds with incremental updates.

## Takeaways
- Generate corner values directly; maintain running prime/total counts.


## Java implementation (Euler058.java)

- Class: `Euler058`
- For each odd side length `s = 2*layer + 1`, compute corners: `s^2`, `s^2-(s-1)`, `s^2-2(s-1)`, `s^2-3(s-1)`; test the three non-square corners for primality.
- Maintain totals: `total += 4`, increment `primes` accordingly; when `primes / total < 0.10`, print side length `s`.
- Helper: `isPrime(long)` using 6k±1 trial division.
