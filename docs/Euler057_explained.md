# Euler057 — Square root convergents

In the first 1000 expansions of √2, count fractions where the numerator has more digits than the denominator.

## Recurrence

- Continued fraction expansion of √2 has convergents: starting with (n,d)=(3,2) then n,d ← (n+2d, n+d).
- Count when digits(n) > digits(d) over 1000 steps.

## Complexity
- O(1000) BigInteger additions.

## Practical examples and business impact

- Convergent approximations: use recurrences to generate rational approximations for irrationals in simulations.
- Control systems: track numerator/denominator growth in recursive filters.
- Data compression: analyze digit-length growth in continued fraction expansions for encoding efficiency.
- Education: teach recurrence relations and digit-length analysis.
- Cryptography: study convergent growth for key schedule design.
- QA: test digit-length comparison logic in BigInteger libraries.
- Benchmarking: measure performance of recurrence-based rational generators.
- Visualization: plot digit-length ratios over steps to reveal convergence patterns.
- Embedded: implement recurrence-based rational approximators for resource-limited systems.
- Simulation: model error decay in convergent expansions and digit-length crossovers.

## Takeaways
- Use the closed recurrence for √2; count digit-length comparisons.


## Java implementation (Euler057.java)

- Class: `Euler057`
- Start with numerator=3, denominator=2 as BigIntegers.
- For 1000 steps: if `digits(num) > digits(den)` increment count; update `(num, den) = (num + 2*den, num + den)`.
- Output: Print the count.
