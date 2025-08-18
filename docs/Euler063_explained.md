# Euler063 — Powerful digit counts

Count how many n-digit positive integers are also an nth power.

## Method

- Base a ∈ {1..9}; for each n≥1, compute a^n (BigInteger) and count digits; include when digits == n.
- Stop increasing n for a when a^n gains fewer than n digits (digits grow roughly n·log10(a)). Overall, n ≤ 21 for a≥2.

## Complexity
- Tiny; 9×~21 checks.

## Real-world analogues and impact
- Matching growth rates to digit-length thresholds.
  - Impact: Predictable scanning bounds reduce search massively.

## Takeaways
- Iterate a=1..9, small n; count digit-length matches; sum results.
