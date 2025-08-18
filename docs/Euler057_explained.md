# Euler057 — Square root convergents

In the first 1000 expansions of √2, count fractions where the numerator has more digits than the denominator.

## Recurrence

- Continued fraction expansion of √2 has convergents: starting with (n,d)=(3,2) then n,d ← (n+2d, n+d).
- Count when digits(n) > digits(d) over 1000 steps.

## Complexity
- O(1000) BigInteger additions.

## Real-world analogues and impact
- Convergent approximations for irrationals; track quality by digit lengths.
  - Impact: Simple recurrences produce high-precision rationals cheaply.

## Takeaways
- Use the closed recurrence for √2; count digit-length comparisons.


## Java implementation (Euler057.java)

- Class: `Euler057`
- Start with numerator=3, denominator=2 as BigIntegers.
- For 1000 steps: if `digits(num) > digits(den)` increment count; update `(num, den) = (num + 2*den, num + den)`.
- Output: Print the count.
