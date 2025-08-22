# Euler064 — Odd period square roots

For N ≤ 10000, count how many continued fractions of √n have an odd period.

## Approach

- For non-square n, compute the continued fraction period via the standard recurrence: m0=0, d0=1, a0=floor(√n); then iterate m_{k+1}=d_k a_k − m_k, d_{k+1}=(n−m_{k+1}^2)/d_k, a_{k+1}=floor((a0+m_{k+1})/d_{k+1}) until a_k==2a0.
- Count period length; increment if odd.

## Edge Cases
- Perfect squares: Must be skipped (period 0); include a quick square test to avoid division by zero anomalies.
- Integer division: Ensure (n - m^2) divisible by d each step; arithmetic errors cause incorrect periods.
- Termination: Condition is a == 2*a0; misplacing termination will yield wrong length.
- Overflow: m and d remain within n bounds; int sufficient for n≤10000; for larger n use long.
- Performance: Period lengths modest; premature optimization unnecessary.

## Complexity
- O(N·period) with small average periods.

## Practical examples and business impact
- Period detection in quadratic irrational expansions.
  - Impact: Structured recurrences give exact periodicity without storing sequences.

## Key Takeaways
- Implement the classic m,d,a loop; count odd-length periods for non-squares.


## Java implementation (Euler064.java)

- Class: `Euler064`
- Helper: `period(int n)` computes the continued fraction period for √n using the `(m,d,a)` recurrence until `a == 2*a0`.
- Main: for n up to 10,000 (override via CLI), count how many have odd period; print the count.
