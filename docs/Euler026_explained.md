# Euler026 — Reciprocal cycles

Find d < N for which 1/d has the longest recurring cycle in decimal expansion.

## Number theory playbook

1) Strip factors of 2 and 5
- Let d' = d with all 2s and 5s removed; if d'=1, cycle length = 0.

2) Multiplicative order
- Cycle length is the smallest k such that 10^k ≡ 1 (mod d'). Compute by repeated modular multiplication while tracking remainders, or use φ(d') factorization to test divisors.

3) Complexity
- Worst-case O(d) per d for remainder-tracking approach; still fine for d < 1000.

## Real-world analogues and impact
- Periods of LCGs and repeating patterns in modular arithmetic.
  - Impact: Choose parameters with provable long periods.

## Takeaways
- Reduce denominator by 2s and 5s; cycle length equals multiplicative order of 10 modulo the reduced denominator.
