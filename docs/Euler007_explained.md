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
  - Problem: Evaluate items against a minimal set of decisive rules.
  - Model: Test candidates only against prior “primes” (critical rules) up to a threshold.
  - Impact: Lower latency, fewer checks.

- Catalog curation with known filters
  - Problem: Avoid applying every filter to every item.
  - Model: Early‑exit using a small set of strong filters; expand only as needed.
  - Impact: Faster pipelines.

- Hiring funnel optimization
  - Problem: Screen candidates with minimal costly steps.
  - Model: Use a growing set of discriminative checks before deeper ones.
  - Impact: Cuts time‑to‑hire.

- API request gating
  - Problem: Triage requests cheaply before expensive validation.
  - Model: Apply fast “prime” checks first; only complex checks for survivors.
  - Impact: Saves CPU; improves throughput.

- Recommendation systems
  - Problem: Prune the candidate set before scoring.
  - Model: Maintain a small prime set of filters; expand when needed.
  - Impact: Faster inference.

- Data quality validation
  - Problem: Detect obvious bad records early.
  - Model: Run lightweight rules akin to prime divisibility.
  - Impact: Cheaper ETL.

- Compiler optimization passes
  - Problem: Apply only passes that matter for a given function.
  - Model: Stop passes when thresholds met (analogy to sqrt bound).
  - Impact: Shorter build times.

- Network intrusion detection
  - Problem: Early discard of benign flows.
  - Model: A few strong signatures (primes) suffice to reject most.
  - Impact: Real‑time performance.

- Experiment design
  - Problem: Find nth “prime” condition meeting strict criteria.
  - Model: Incrementally test candidates with growing prior set.
  - Impact: Efficient exploration.

- Education tooling
  - Problem: Teach sieve/trial‑division strategies interactively.
  - Model: Show test‑up‑to‑sqrt and prior‑primes logic.
  - Impact: Better intuition.

## Key takeaways
- Grow primes incrementally and test up to √x.
- Use sieves when n gets large; for moderate n this method is simple and effective.

## Java implementation (Euler007.java)

- Helper: `isPrime(long x, ArrayList<Integer> primes)` tests divisibility only by prior primes up to `sqrt(x)`.
- Core: `nthPrime(int n)` maintains a dynamic `ArrayList<Integer>` of primes, tries candidates starting at 2, then skips even numbers; stops when size == n and returns the last prime.
- CLI: `main(String[] args)` defaults to `n = 10001`; accepts optional first arg to override; prints the nth prime.
