# Euler010 — Summation of primes below n

Compute the sum of all primes less than n.

## Problem statement

Given an integer n, return S(n) = sum of all primes p with p < n. For example, S(10) = 2 + 3 + 5 + 7 = 17.

## Step-by-step reasoning

1) Inputs/outputs
- Input: n (n ≥ 0). If n ≤ 2, the sum is 0.
- Output: 64-bit sum of primes below n (use long).

2) Use a sieve (Eratosthenes)
- Maintain a boolean array comp[0..n-1] where true means composite.
- Mark even numbers (optional micro-optimization) and start from p=3.
- For each odd p with comp[p]==false, add p to the sum and mark its odd multiples starting at p*p with stride 2p.
- Initialize sum with 2 if n > 2.

3) Java building blocks
- Arrays: boolean[] for composite flags.
- Loops: outer over p, inner to mark multiples.
- Arithmetic: use long for the running sum to avoid overflow.

4) Complexity
- Time ~ O(n log log n); space O(n). For n up to 2,000,000, this is trivial in Java.

5) Edge cases and correctness
- n ≤ 2 → 0.
- Avoid integer overflow in p*p by using `for (long m = 1L*p*p; m < n; m += 2L*p)` or checking `p <= sqrt(n-1)`.
- If memory is tight, use a bitset or segmented sieve; unnecessary for Euler 10.

6) Testing mindset
- Small checks: n=10→17; n=3→2; n=2→0; n=20→77.
- Cross-verify against a simple (slower) prime test for small n.

## Reusable template (for similar problems)

When you need to aggregate over primes below a bound:
- Use a sieve to precompute primality in bulk.
- Sum (or otherwise process) primes on the fly while sieving.
- For massive bounds, switch to segmented sieve; for primality of single numbers, use Miller–Rabin.

## Practical examples and business impact

- Security keyspace and sampling (toy scale)
  - Problem: Enumerate primes below a bound for demos/tests.
  - Model: Sieve for fast generation.
  - Impact: Rapid prototyping.

- Analytics over sparse sets
  - Problem: Filter out obvious non‑candidates en masse.
  - Model: Sieve‑like marking of multiples/blocks.
  - Impact: Lower compute and I/O.

- Feature selection at scale
  - Problem: Remove features that are multiples of others (redundant).
  - Model: Sieve out dominated features by rules.
  - Impact: Faster training.

- Network scanning
  - Problem: Skip known non‑responsive ranges quickly.
  - Model: Mark and skip ranges like sieve multiples.
  - Impact: Faster scans.

- Compiler dead‑code elimination
  - Problem: Remove code known to be unreachable/redundant.
  - Model: Iterative marking akin to sieving.
  - Impact: Smaller binaries.

- Document retrieval
  - Problem: Exclude documents by broad rules first.
  - Model: Bulk marking and later precise checks.
  - Impact: Snappy search.

- Scheduling with exclusion lists
  - Problem: Exclude dates/slots by recurrence patterns.
  - Model: Pre‑mark excluded slots; process remainder.
  - Impact: Efficient calendars.

- ETL prefilters
  - Problem: Drop rows matching broad filters early.
  - Model: Sieve‑style pass before expensive transforms.
  - Impact: Cheaper pipelines.

- Education tooling
  - Problem: Teach sieving visually and interactively.
  - Model: Show marking from p*p and skip even steps.
  - Impact: Better intuition.

- Database cleanup
  - Problem: Remove redundant keys/rows in bulk.
  - Model: Mark‑and‑sweep style sieve pass.
  - Impact: Healthier datasets.

## Key takeaways

- Use sieves for prime generation; mark from p*p and skip even steps.
- Keep sums in long; guard p*p from overflow with long temporaries.

## Java implementation (Euler010.java)

- Core: `sumPrimesBelow(int n)` builds a boolean sieve and accumulates primes into a long sum, marking odd multiples starting at p*p.
- CLI: `main(String[] args)` defaults n = 2_000_000; accepts optional first arg; prints the sum of primes < n.
