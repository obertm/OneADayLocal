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
