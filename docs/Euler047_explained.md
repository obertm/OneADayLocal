# Euler047 — Distinct prime factors (run of K)

Find the first integer of the first run of K consecutive integers with exactly K distinct prime factors (K=4 in the problem).

## Efficient plan

- Build an array spf[ ] (smallest prime factor) via sieve up to a limit.
- For each n, count distinct primes by repeatedly dividing by spf while skipping duplicates.
- Slide a window counting how many consecutive n have count==K; when it reaches K, return start.

## Complexity
- O(N) with spf sieve and O(log n) factorization per n; very fast for the bounds.

## Real-world analogues and impact
- Property runs in sequences with factor-based features.
  - Impact: Linear-time detection of structured streaks.

## Takeaways
- Use spf sieve to get distinct-factor counts cheaply; maintain a consecutive-run counter.


## Java implementation (Euler047.java)

- Class: `Euler047`
- Helper: `countDistinctPrimeFactors(int n)` trial-divides and counts unique factors by dividing them out.
- Main: parameter `k` (default 4); increase `n`, track `streak` of consecutive ints with exactly `k` distinct prime factors; when `streak==k`, print `n-k+1`.
- Note: An spf sieve would be faster, but this direct approach is still quick for k=4.
