# Euler050 — Consecutive prime sum

Find the prime < 1,000,000 that can be written as the longest sum of consecutive primes.

## Approach

- Sieve primes < 1e6; build prefix sums P where P[i]=sum of first i primes.
- For window lengths L decreasing from max possible, slide start/end and compute sum=P[j]-P[i]; if <1e6 and prime, record and break for that L.
- Keep best (max L) found.

## Complexity
- O(#primes^2) worst-case with early pruning; fast enough with prefix sums and bounds.

## Real-world analogues and impact
- Longest-run analytics in streaming integer sequences with membership tests.
  - Impact: Prefix sums + membership set make large scans tractable.

## Takeaways
- Prefix sums enable O(1) range sums; scan windows to maximize length under constraints.
