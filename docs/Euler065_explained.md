# Euler065 — Convergents of e

Find the sum of digits of the numerator of the 100th convergent of the continued fraction for e.

## Approach

- Build the coefficient sequence: [2; 1,2,1, 1,4,1, 1,6,1, ...] where every third term after the first is 2k.
- Compute the 100th convergent via backward recurrence: starting from the last coefficient a_n, maintain (num,den) and update with (num,den) ← (a_i·num + den, num).
- Sum digits of final numerator.

## Edge Cases
- Coefficient pattern: Every 3rd (1-based) term from index 2 is 2k; off-by-one here invalidates numerator.
- Backward iteration order: Must process from last index down to 0; reversing order yields wrong convergent.
- BigInteger growth: Numerators grow quickly; avoid primitive types.
- Digit sum: Only numerator digits counted; ensure you don’t sum denominator.
- N parameterization: If generalized, ensure dynamic coefficient generation not hardcoded to 100.

## Complexity
- O(N) BigInteger ops.

## Practical examples and business impact
- Exact convergents for analytic numbers using simple recurrences.
  - Impact: High-precision results without floating error.

## Key Takeaways
- Generate e’s CF coefficients; fold backward to get the convergent; sum numerator digits.


## Java implementation (Euler065.java)

- Class: `Euler065`
- Build coefficients `a[0..99]` for e’s continued fraction: `a[0]=2`, and for k≥1: if k%3==2 then 2*(k+1)/3 else 1.
- Fold backward with BigInteger: starting from the end, update `(num, den) = (a[i]*num + den, num)`.
- Sum digits of `num` and print.
