# Euler021 — Amicable numbers under N

Find the sum of all amicable numbers < N. Two numbers a ≠ b are amicable if d(a) = b and d(b) = a, where d(x) is the sum of proper divisors of x.

## Problem statement

Given N, compute the sum of all a < N that are part of an amicable pair (a,b) with a ≠ b and d(a)=b, d(b)=a.

## Step-by-step reasoning

1) Precompute d(x)
- Sieve-like pass: initialize sums with 1 for x>1, then for each m from 2..N/2 add m to multiples 2m,3m,…
- Alternative: loop f up to √x per x and add f and x/f; sieve is faster in bulk.

2) Detect amicable pairs
- For each a in [2..N): b = d(a); if b < N, b ≠ a, and d(b) = a → add a.
- Avoid double-counting by summing a only (or track visited).

3) Complexity
- Divisor-sum sieve ~ O(N log N); detection O(N).

## Reusable template (for similar problems)

Mutual relationships via precomputed scores:
- Precompute a function f(x) for all x in range.
- Then scan x and find y=f(x) that also satisfy f(y)=x, with constraints.

## Practical examples and business impact

- Ledgers with mutual credits
  - Detect pairs of accounts that cross-credit exactly.
  - Impact: Quick anomaly detection using a single precompute + scan.

- Social graphs with reciprocal links
  - Identify mutual follows/edges efficiently.
  - Impact: Efficient features for recommendation and moderation.

## Key takeaways

- Sieve divisor sums once; then check amicable condition in O(1) per a.
- Sum each a once to avoid double-counting.
