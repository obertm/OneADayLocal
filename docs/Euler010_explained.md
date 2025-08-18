# Euler010 — Summation of primes below n

Compute the sum of all primes less than n.

## Approach

1) Choose a sieve
- Sieve of Eratosthenes marks composites and leaves primes. For memory efficiency, skip evens and start crossing off at p*p.

2) Implementation outline
- If n ≤ 2, sum = 0.
- Maintain a boolean array `comp` of length n; true means composite.
- Initialize sum with 2.
- For odd p from 3 to n-1:
  - If not composite, add p to sum and mark multiples from p*p in steps of 2p.

3) Complexity
- Time ~ O(n log log n); space O(n).

4) Reusable template
- For “sum/filter over primes below bound,” use a sieve and aggregate during marking.

## Real-world uses and impact

- Security keyspace scans (toy scale)
  - Efficiently enumerate prime candidates below a bound.
  - Impact: Faster prototyping and property checks.

- Analytics over sparse sets
  - Sieve-like prefilters generalize to many sparse selection tasks.
  - Impact: Lower compute by avoiding unnecessary checks.

## Key takeaways
- Use sieves for prime generation.
- Mark from p*p and skip even steps for speed.
