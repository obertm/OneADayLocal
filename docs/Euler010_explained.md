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
  - Efficiently enumerate primes below a threshold for experiments or teaching; sieve is the gold standard.
  - Impact: Fast prototyping without heavy libraries.

- Analytics over sparse sets
  - Sieve-like prefilters generalize to many sparse selection tasks where you eliminate multiples quickly.
  - Impact: Lower compute by avoiding unnecessary checks.

## Key takeaways

- Use sieves for prime generation; mark from p*p and skip even steps.
- Keep sums in long; guard p*p from overflow with long temporaries.

## Java implementation (Euler010.java)

- Core: `sumPrimesBelow(int n)` builds a boolean sieve and accumulates primes into a long sum, marking odd multiples starting at p*p.
- CLI: `main(String[] args)` defaults n = 2_000_000; accepts optional first arg; prints the sum of primes < n.
