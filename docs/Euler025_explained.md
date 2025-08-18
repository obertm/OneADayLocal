# Euler025 — 1000-digit Fibonacci index

Find the index of the first Fibonacci number with D digits.

## Approach

1) Big integers
- Iterate F(n+1)=F(n)+F(n-1) using BigInteger until digits ≥ D.

2) Optional math shortcut
- Use logs: digits(F_n) ≈ floor(n·log10(φ) - log10(√5)) + 1 to estimate n and then adjust.

## Complexity
- O(n · M(n)) big-int adds; practical and fast for 1000 digits.

## Real-world analogues and impact
- Threshold-crossing index in monotone sequences (growth processes, capacity planning).
  - Impact: Predict and detect when a metric exceeds a target.

## Takeaways
- Straight BigInteger iteration is simple and reliable; logs can seed a near-exact starting point.
