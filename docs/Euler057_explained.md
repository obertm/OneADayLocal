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
