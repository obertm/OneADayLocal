# Euler027 — Quadratic primes

## Problem statement

Find integers a and b such that the quadratic n^2 + a·n + b produces the longest run of consecutive primes starting at n = 0, given bounds |a| < A and |b| ≤ B.

## Step-by-step reasoning

1) Constrain b
- At n = 0, the value equals b, so b must be prime (and positive). This prunes the search dramatically.

2) Scan a for each candidate b
- Iterate a in [−(A−1) .. (A−1)]. For each (a, b), count consecutive n starting at 0 for which the polynomial yields a prime.

3) Fast primality checks
- Use a simple trial division up to √value (or a sieve-backed lookup for speed) to test primality of each generated value.

## Reusable template (for constrained parameter searches)

- Use necessary conditions derived from boundary cases to prune candidates.
- Iterate over remaining parameters and evaluate an objective function (run length here).
- Keep the arg-max and its value.

## Practical examples and business impact

- Hyperparameter sweeps: prune combinations with simple feasibility checks before costly evaluation.
- Optimization with constraints: necessary conditions can cut compute by orders of magnitude.

## Key takeaways

- The n=0 constraint implies b is prime; this is the dominant pruning lever.
- With pruning, a direct search is fast and clear to implement.

## Java implementation (Euler027.java)

We scan a in [−999..999] and b among primes where |b| ≤ 1000, counting consecutive primes from n = 0.

- Primality: `isPrime(int n)` handles small cases, rejects evens > 2, and tests divisibility by odd numbers up to √n.
- Candidate b: preselect values with `isPrime(|b|)`; downstream primality checks filter any non-positive/invalid cases.
- Counting run: for each (a, b), increment n while `isPrime(n*n + a*n + b)` remains true.
- Track best run length and corresponding (a, b), then output `a*b` as required by the problem.
