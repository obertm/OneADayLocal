# Euler012 — Highly divisible triangular number

Find the first triangular number with over D divisors.

## Steps you can reuse

1) Model
- n-th triangular number: T_n = n(n+1)/2.
- We need the smallest n such that divCount(T_n) > D.

2) Factorization trick
- n and n+1 are coprime, so factor T_n by factoring n and (n+1) separately, then subtract a factor 2 from one side.
  - If n is even, T_n = (n/2)·(n+1). Else T_n = n·((n+1)/2).
  - Count divisors via prime exponents: if T_n = ∏ p_i^{e_i}, then divCount = ∏ (e_i+1).

3) Implementation outline
- Increment n from 1 upward.
- Factor a and b where {a,b} = {n/2, n+1} (or {n, (n+1)/2}).
- Merge prime exponents and compute divisor count; stop when > D.
- Use a prime list (sieve) up to √max(T_n) seen so far; or factor on the fly up to √x.

4) Complexity
- Dominated by repeated small factorizations up to roughly O(n √n) naïvely; prime caching/sieving helps a lot.

## Real-world analogues and impact
- Decomposing products of near-coprime terms comes up in scheduling and CRT-like systems.
  - Impact: Faster property checks by splitting co-prime parts.
- Divisor counts tie to factor structure; used in bucketing and canonicalization tasks.
  - Impact: Better indexing and join performance.

## Takeaways
- Use T_n structure to halve the work.
- Count divisors from prime exponents; stop as soon as threshold exceeded.
