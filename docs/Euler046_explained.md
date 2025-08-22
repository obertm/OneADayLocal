# Euler046 — Goldbach’s other conjecture

Find the smallest odd composite that cannot be written as prime + 2×square.

## Approach

- Sieve primes; for odd n increasing that are not prime, test if ∃ prime p ≤ n with (n−p) even and (n−p)/2 a perfect square.
- If no such p exists, return n.

## Edge Cases

- Even numbers: Skip; conjecture concerns odd composites.
- Prime n: Skip; only composites tested.
- Perfect square detection: Use integer sqrt; watch for floating precision; `(int)Math.sqrt(x)` then square and compare.
- Sieve limit: Must exceed candidate n; if n grows beyond initial sieve size, extend or choose higher initial limit.
- Overflow: (n-p)/2 fits in int for this problem; for larger n use long.
- Performance: For large n, checking all primes ≤ n is heavy; break early when (n - 2) / 2 < smallest square needed.

## Complexity
- Prime sieve O(N log log N); each n checks primes up to n with early breaks; practical.

## Practical examples and business impact

- Model falsification: search for counterexamples when a dataset is claimed to decompose into (prime-like + twice-square-like) parts.
- Compression heuristics: detect values that cannot be represented as “small core + structured noise,” rejecting the codec choice.
- Anomaly detection: flag records that don’t admit expected decomposition (baseline + 2×feature^2) in monitoring.
- Security: identify inputs that evade approximate decompositions in filters (e.g., sum of baseline and quadratic term).
- Finance modeling: test if odd transaction aggregates fit a prime-plus-quadratic adjustment; counterexamples prompt rule changes.
- Education: teach constructive counterexample search for conjectures using sieve + fast membership.
- Simulation: evaluate robustness of decomposition pipelines by injecting values that break assumed forms.
- ETL quality: validate transformation that assumes values split into two components; surface violations.
- Hardware DSP: sanity-check that signals follow decompositions; detect cases where quadratic compensation can’t explain residuals.
- Research prototyping: quickly probe the boundary where a heuristic decomposition stops working.

## Key Takeaways
- Precompute primes; test the square condition for differences.


## Java implementation (Euler046.java)

- Class: `Euler046`
- Helpers: `isPrime(int)` trial division; `canWrite(int n)` tries primes p<n and checks whether `(n-p)` is twice a perfect square.
- Main: iterate odd composites from 9 upward; the first that fails `canWrite` is printed.
