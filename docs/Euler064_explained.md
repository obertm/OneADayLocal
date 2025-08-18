# Euler064 — Odd period square roots

For N ≤ 10000, count how many continued fractions of √n have an odd period.

## Recipe

- For non-square n, compute the continued fraction period via the standard recurrence: m0=0, d0=1, a0=floor(√n); then iterate m_{k+1}=d_k a_k − m_k, d_{k+1}=(n−m_{k+1}^2)/d_k, a_{k+1}=floor((a0+m_{k+1})/d_{k+1}) until a_k==2a0.
- Count period length; increment if odd.

## Complexity
- O(N·period) with small average periods.

## Real-world analogues and impact
- Period detection in quadratic irrational expansions.
  - Impact: Structured recurrences give exact periodicity without storing sequences.

## Takeaways
- Implement the classic m,d,a loop; count odd-length periods for non-squares.
