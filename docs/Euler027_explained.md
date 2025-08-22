# Euler027 — Quadratic primes

## Problem statement

Find integers a and b such that the quadratic n^2 + a·n + b produces the longest run of consecutive primes starting at n = 0, given bounds |a| < A and |b| ≤ B.

## Step-by-step reasoning

## Approach

Restrict b to primes (value at n=0) and scan integer a range; for each (a,b) count consecutive n while polynomial yields primes using a fast primality test; retain longest run.

1) Constrain b
- At n = 0, the value equals b, so b must be prime (and positive). This prunes the search dramatically.

2) Scan a for each candidate b
- Iterate a in [−(A−1) .. (A−1)]. For each (a, b), count consecutive n starting at 0 for which the polynomial yields a prime.

3) Fast primality checks
- Use a simple trial division up to √value (or a sieve-backed lookup for speed) to test primality of each generated value.

## Edge Cases

- b non-prime: Skip early; necessary condition.
- Negative polynomial outputs: For some n>0, n^2 + a n + b may become ≤ 0; treat as non-prime and stop the run.
- Large |a|, |b|: For bigger bounds precompute sieve up to max possible value (approx B + A^2) or switch to Miller–Rabin.
- Overflow: Use int when values stay within range; for large bounds switch to long to prevent overflow of n^2.
- Equality at n=0 only: Runs of length 1 (only b prime) should still be counted; initialize best accordingly.
- Primality caching: Without caching, repeated trial division can slow search; optional optimization is a sieve.

## Reusable template (for constrained parameter searches)

- Use necessary conditions derived from boundary cases to prune candidates.
- Iterate over remaining parameters and evaluate an objective function (run length here).
- Keep the arg-max and its value.

## Practical examples and business impact

- Hyperparameter sweeps: prune combinations with simple feasibility checks before costly evaluation.
- Optimization with constraints: necessary conditions can cut compute by orders of magnitude.

## Key Takeaways

- The n=0 constraint implies b is prime; this is the dominant pruning lever.
- With pruning, a direct search is fast and clear to implement.

## Java implementation (Euler027.java)

We scan a in [−999..999] and b among primes where |b| ≤ 1000, counting consecutive primes from n = 0.

- Primality: `isPrime(int n)` handles small cases, rejects evens > 2, and tests divisibility by odd numbers up to √n.
- Candidate b: preselect values with `isPrime(|b|)`; downstream primality checks filter any non-positive/invalid cases.
- Counting run: for each (a, b), increment n while `isPrime(n*n + a*n + b)` remains true.
- Track best run length and corresponding (a, b), then output `a*b` as required by the problem.
