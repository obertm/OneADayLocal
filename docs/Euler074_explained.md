# Euler074 — Digit factorial chains

How many starting numbers below one million produce a chain with exactly 60 non-repeating terms before looping (via sum of factorials of digits)?

## Approach

- Precompute fact[0..9]. Define next(x)=sum(fact[d] for digits of x).
- For each start n, follow next() until you hit a seen value; count length of unique segment, reusing memoized chain lengths when encountered.
- Cache lengths for all visited numbers to avoid recomputation.

## Edge Cases
- Loop identification: Distinguish between hitting a known memoized length vs encountering a fresh loop cycle; update all nodes correctly.
- Growth bounds: next(x) for x with k digits ≤ k·9!; ensure memo array sized to cover max encountered value (k=7 for <1e6 gives 7·9! < 2.6e7).
- Repeated digits: Factorial caching eliminates recomputation; ensure not recalculating per digit per step unnecessarily.
- Performance: Avoid recursion depth issues; iterative chain build safer.
- Off-by-one in length: Count non-repeating terms (exclude the first repeated value from length); precise indexing required.

## Complexity
- Near O(N) amortized with memoization; each number quickly hits a small loop.

## Practical examples and business impact
- Iterated transforms with memoized orbit lengths.
  - Impact: Huge speedups by caching transient path results.

## Key Takeaways
- Precompute digit factorials; memoize chain lengths; count starts with length 60.


## Java implementation (Euler074.java)

- Class: `Euler074`
- Precompute `FACT[0..9]`; define `next(n)` as sum of digit factorials.
- For each start < 1,000,000, follow the chain with a local map recording step index; on revisit or memo hit, compute chain length for all seen nodes and store in `memo` up to a safe cap (e.g., 3,000,000).
- Count starts that produce exactly 60 non-repeating terms before the loop.
