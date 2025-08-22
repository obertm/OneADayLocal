# Euler058 — Spiral primes ratio

Build the number spiral and find the side length where the ratio of primes on the diagonals first falls below 10%.

## Approach

- For each odd side s=3,5,7,..., corners are s^2, s^2−(s−1), s^2−2(s−1), s^2−3(s−1). Test the three non-square corners for primality.
- Track total diagonal count (=2s−1) and prime count; stop when ratio < 0.10.

## Edge Cases
- Ratio threshold: Strictly below 10%; equality does not stop.
- Long arithmetic: s^2 fits in 64-bit for s up to 1e6; if generalized further, watch overflow.
- Primality performance: Trial division adequate for problem scale; for larger s adopt Miller–Rabin.
- Starting layer: Begin at s=3; the 1×1 spiral (s=1) has ratio 100%; ensure loop starts after base case.
- Floating precision: Use double or compare 10*primes < total to avoid division precision issues.

## Complexity
- O(#layers) primality checks; fast with a strong primality test.

## Practical examples and business impact

- Threshold detection: monitor ratios (e.g., primes/total) and trigger on crossing a threshold.
- Grid simulation: spiral or layered grid models for signal/feature density analysis.
- Education: teach incremental ratio tracking and early stopping.
- QA: test spiral/corner value generation and ratio logic.
- Visualization: animate spiral growth and prime ratio decline.
- Embedded: implement efficient spiral/corner generation for pattern recognition.
- Simulation: model decay of “interesting” events in expanding search spaces.
- Benchmarking: compare naive vs. direct-corner generation for grid problems.
- Data mining: detect when rare events fall below a critical mass in streaming data.
- Security: monitor for drop-off in “prime-like” events in rolling windows.

## Key Takeaways
- Generate corner values directly; maintain running prime/total counts.


## Java implementation (Euler058.java)

- Class: `Euler058`
- For each odd side length `s = 2*layer + 1`, compute corners: `s^2`, `s^2-(s-1)`, `s^2-2(s-1)`, `s^2-3(s-1)`; test the three non-square corners for primality.
- Maintain totals: `total += 4`, increment `primes` accordingly; when `primes / total < 0.10`, print side length `s`.
- Helper: `isPrime(long)` using 6k±1 trial division.
