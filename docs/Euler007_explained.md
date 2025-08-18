# Euler007 — nth prime

Find the nth prime number.

## Approach you can repeat

1) Clarify
- Input: n ≥ 1.
- Output: the nth prime.

2) Trial building with a dynamic prime list
- Keep a growing list/array of found primes.
- To test a candidate x, check divisibility only by primes ≤ √x.
- Start from 2, then test only odd numbers after 2 to skip obvious composites.
- Continue until you have n primes.

3) Why this works and scales reasonably
- Dividing only by found primes saves work.
- Checking up to √x reduces divisions.
- For n ≈ 10^5 it’s fast; for much larger n, use a segmented sieve.

4) Complexity
- Roughly O(n log log n) if using sieve; dynamic trial division is fine for moderate n like 10,001.

## Reusable template
- Maintain a list of primes.
- For each candidate, test divisibility by primes up to √candidate.
- Skip even candidates after 2.

## Real-world parallels and impact

- Security scanning / rule evaluation
  - Similar strategy: maintain a set of known blockers (primes) and test candidates against only necessary rules (≤ threshold).
  - Impact: Reduced evaluations, lower latency.

- Catalog curation with known filters
  - Apply only relevant filters up to a threshold instead of all filters every time.
  - Impact: Faster curation pipelines.

## Key takeaways
- Grow primes incrementally and test up to √x.
- Use sieves when n gets large; for moderate n this method is simple and effective.
