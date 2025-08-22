# Euler063 — Powerful digit counts

Count how many n-digit positive integers are also an nth power.

## Approach

- Base a ∈ {1..9}; for each n≥1, compute a^n (BigInteger) and count digits; include when digits == n.
- Stop increasing n for a when a^n gains fewer than n digits (digits grow roughly n·log10(a)). Overall, n ≤ 21 for a≥2.

## Edge Cases
- a=10 excluded: Bases ≥10 produce more digits than exponent quickly; limiting to 1..9 is correct.
- Base 1: 1^n = 1 (1 digit) => only n=1 counts; ensure loop logic doesn’t over-count.
- Digit count: String length safe; for performance at scale, precompute log10(a) and compare n*log10(a) floor +1.
- BigInteger reuse: Multiplying prior power avoids recomputing from scratch; ensure multiplication order correct.
- Loop termination: Break per base when digits(val) < n; ensures no later n will match.

## Complexity
- Tiny; 9×~21 checks.

## Practical examples and business impact
- Matching growth rates to digit-length thresholds.
  - Impact: Predictable scanning bounds reduce search massively.

## Key Takeaways
- Iterate a=1..9, small n; count digit-length matches; sum results.


## Java implementation (Euler063.java)

- Class: `Euler063`
- Loop: base a=1..9; maintain `val = a^n` via multiply; if `digits(val) == n` increment total, else if `< n` break for that a.
- Output: Print the total count.
