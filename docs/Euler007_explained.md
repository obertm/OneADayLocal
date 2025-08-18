# Euler007 — nth prime

Find the nth prime number.

## Problem statement

Given n ≥ 1, return the n-th prime (1-indexed): 2, 3, 5, 7, 11, …

## Step-by-step reasoning

1) Trial building with a dynamic prime list
- Keep a growing list/array of found primes.
- To test a candidate x, check divisibility only by primes ≤ √x.
- Start from 2, then test only odd numbers after 2 to skip obvious composites.
- Continue until you have n primes.

2) Why this works and scales reasonably
- Dividing only by found primes saves work.
- Checking up to √x reduces divisions.
- For n ≈ 10^5 it’s fast; for much larger n, use a segmented sieve.

3) Complexity
- Roughly O(n log log n) if using sieve; dynamic trial division is fine for moderate n like 10,001.

## Reusable template
- Maintain a list of primes; test candidates by primes up to √candidate; skip even candidates after 2.

## Practical examples and business impact

- Security scanning / rule evaluation
  - Similar strategy: maintain a set of known blockers (primes) and test candidates against only necessary rules (≤ threshold).
  - Impact: Reduced evaluations, lower latency.

- Catalog curation with known filters
  - Apply only relevant filters up to a threshold instead of all filters every time.
  - Impact: Faster curation pipelines.

## Key takeaways
- Grow primes incrementally and test up to √x.
- Use sieves when n gets large; for moderate n this method is simple and effective.

## Java implementation (Euler007.java)

- Helper: `isPrime(long x, ArrayList<Integer> primes)` tests divisibility only by prior primes up to `sqrt(x)`.
- Core: `nthPrime(int n)` maintains a dynamic `ArrayList<Integer>` of primes, tries candidates starting at 2, then skips even numbers; stops when size == n and returns the last prime.
- CLI: `main(String[] args)` defaults to `n = 10001`; accepts optional first arg to override; prints the nth prime.
