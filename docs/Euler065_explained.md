# Euler065 — Convergents of e

Find the sum of digits of the numerator of the 100th convergent of the continued fraction for e.

## Steps

- Build the coefficient sequence: [2; 1,2,1, 1,4,1, 1,6,1, ...] where every third term after the first is 2k.
- Compute the 100th convergent via backward recurrence: starting from the last coefficient a_n, maintain (num,den) and update with (num,den) ← (a_i·num + den, num).
- Sum digits of final numerator.

## Complexity
- O(N) BigInteger ops.

## Real-world analogues and impact
- Exact convergents for analytic numbers using simple recurrences.
  - Impact: High-precision results without floating error.

## Takeaways
- Generate e’s CF coefficients; fold backward to get the convergent; sum numerator digits.
