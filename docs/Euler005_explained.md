# Euler005 — Smallest multiple (LCM up to n)

Find the smallest positive number evenly divisible by all numbers from 1 to n.

## Problem statement

Given n ≥ 1, compute L = lcm(1, 2, …, n).

## Step-by-step reasoning

1) Model
- The answer is the least common multiple (LCM) of numbers 1..n.
- LCM(a, b) = a / gcd(a, b) * b.
- Extend by folding: `ans = lcm(ans, i)` for i = 2..n.

2) Implementation steps
- Write a fast gcd (Euclid’s algorithm).
- Write lcm using gcd; beware overflow order (divide before multiply).
- Fold from 2..n with `ans = lcm(ans, i)`.

3) Prime-exponent view (optimization/intuition)
- LCM of 1..n = product over primes p ≤ n of p^{max e s.t. p^e ≤ n}.
- You can build primes via sieve and multiply highest powers.
- Equivalent to the gcd-folding method but can be faster for big n.

4) Complexity
- Folding lcm with gcd is roughly O(n log n) time with tiny constants; space O(1).

## Reusable template
- Reduce “divisible by 1..n” into a fold of LCMs using GCD, or compute prime powers ≤ n and multiply.

## Practical examples and business impact

- Calendar/schedule alignment
  - When multiple recurring events need a common alignment point, the LCM gives the first simultaneous occurrence.
  - Impact: Accurate planning for releases, cron jobs, or compliance checks.

- Batch sizes and packaging
  - Determine the smallest batch size that fits evenly into multiple container sizes or machine cycles.
  - Impact: Reduces waste and changeover time in manufacturing.

- Sharding and sampling cycles
  - Choose periods that minimize collisions across services.
  - Impact: Improves throughput and reduces hotspotting.

## Key takeaways
- Reduce to GCD/LCM folds or prime-power multiplication.
- Watch for overflow order in lcm = a / gcd(a,b) * b.

## Java implementation (Euler005.java)

- Helper: `gcd(long a, long b)` uses Euclid’s algorithm (iterative modulo) and returns `abs(a)` when `b` becomes 0.
- Helper: `lcm(long a, long b)` computes `a / gcd(a,b) * b` to avoid overflow.
- Core: `lcmUpTo(int n)` folds LCM from 2..n accumulating into a `long`.
- CLI: `main(String[] args)` defaults `n = 20` and prints the result; accepts an optional first arg.
