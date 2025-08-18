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


## Java implementation (Euler074.java)

- Class: `Euler074`
- Precompute `FACT[0..9]`; define `next(n)` as sum of digit factorials.
- For each start < 1,000,000, follow the chain with a local map recording step index; on revisit or memo hit, compute chain length for all seen nodes and store in `memo` up to a safe cap (e.g., 3,000,000).
- Count starts that produce exactly 60 non-repeating terms before the loop.
