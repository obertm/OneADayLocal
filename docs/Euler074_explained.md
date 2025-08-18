# Euler074 — Digit factorial chains

How many starting numbers below one million produce a chain with exactly 60 non-repeating terms before looping (via sum of factorials of digits)?

## Method

- Precompute fact[0..9]. Define next(x)=sum(fact[d] for digits of x).
- For each start n, follow next() until you hit a seen value; count length of unique segment, reusing memoized chain lengths when encountered.
- Cache lengths for all visited numbers to avoid recomputation.

## Complexity
- Near O(N) amortized with memoization; each number quickly hits a small loop.

## Real-world analogues and impact
- Iterated transforms with memoized orbit lengths.
  - Impact: Huge speedups by caching transient path results.

## Takeaways
- Precompute digit factorials; memoize chain lengths; count starts with length 60.
