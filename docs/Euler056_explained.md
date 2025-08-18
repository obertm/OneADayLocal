# Euler056 — Powerful digit sum

Find the maximum digital sum of a^b for 1 < a < 100 and 1 < b < 100.

## Approach

- Loop a,b; compute BigInteger a^b (or repeated multiply), sum digits; track maximum.
- Minor prune: a with trailing zeros won’t help maximize digit sum at high b, but full brute force is fine.

## Complexity
- ~10k exponentiations with small sizes; trivial.

## Real-world analogues and impact
- Exploring parameter grids to find extreme values of a metric.
  - Impact: Reliable maxima with exact arithmetic.

## Takeaways
- Straight brute force with BigInteger and digit-sum helper.
