# Euler021 — Amicable numbers under N

Find the sum of all amicable numbers < N. Two numbers a ≠ b are amicable if d(a) = b and d(b) = a, where d(x) is the sum of proper divisors of x.

## Problem statement

Given N, compute the sum of all a < N that are part of an amicable pair (a,b) with a ≠ b and d(a)=b, d(b)=a.

## Step-by-step reasoning

## Approach

Precompute d(x) (sum of proper divisors) for all x < N, then scan each a: b=d(a); if b≠a, b<N, and d(b)=a, add a. Use multiplicative divisor-sum or a sieve; multiplicative per-number factoring is fine at Euler limits.

1) Precompute d(x)
- Sieve-like pass: initialize sums with 1 for x>1, then for each m from 2..N/2 add m to multiples 2m,3m,…
- Alternative: loop f up to √x per x and add f and x/f; sieve is faster in bulk.

2) Detect amicable pairs
- For each a in [2..N): b = d(a); if b < N, b ≠ a, and d(b) = a → add a.
- Avoid double-counting by summing a only (or track visited).

3) Complexity
- Divisor-sum sieve ~ O(N log N); detection O(N).

## Complexity

- Precompute via sieve: O(N log N) time, O(N) space.
- Detection: O(N) lookups.
- Total: dominated by precomputation.

## Edge Cases

- N ≤ 2: No amicable numbers; sum is 0.
- Perfect numbers: d(a)=a (e.g., 6, 28) must not be counted; ensure b != a.
- Partner out of range: If b = d(a) ≥ N skip (Euler spec counts only a < N even if partner larger).
- Overflow: For larger N, divisor sums can exceed int; use long arrays.
- Duplicate counting: Summing only a avoids adding both a and b.

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

## Key Takeaways

- Sieve divisor sums once; then check amicable condition in O(1) per a.
- Sum each a once to avoid double-counting.

## Java implementation (Euler021.java)

We compute sum of proper divisors via a multiplicative formula and scan for amicable pairs.

- Helper: `sumProperDivisors(int n)`
  - Uses prime-power sigma formula: for n = ∏ p^e, σ(n) = ∏ (1 + p + … + p^e). Returns σ(n) − n (proper divisors sum).
  - Iterates p=2, then odd p, dividing out prime powers and accumulating a `term` for each prime.
- Driver: `sumAmicableBelow(int limit)`
  - Precomputes `d[a] = sumProperDivisors(a)` for a in 1..limit-1.
  - For each a in 2..limit-1: let b = d[a]; if b != a, b in range, and d[b] == a, add a to answer.
- CLI: `main(String[] args)` defaults `limit=10_000`; optional first arg overrides; prints the sum.

Classroom notes:
- The σ function is multiplicative across prime powers; subtract n at the end to switch from σ(n) to proper-divisor sum.
- We only add a (not b) to avoid counting each pair twice.
