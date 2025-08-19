# Euler012 — Highly divisible triangular number

Find the first triangular number with over D divisors.

## Problem statement

Given an integer threshold D, find the smallest triangular number T_n = n(n+1)/2 that has more than D positive divisors, and return T_n.

## Step-by-step reasoning

1) Structure of T_n
- T_n = n(n+1)/2. The numbers n and n+1 are coprime, so their prime factorizations don’t share primes.
- Move the factor 2 onto the even side: if n is even, T_n = (n/2)·(n+1); else T_n = n·((n+1)/2).

2) Divisor count from prime exponents
- If x = Π p_i^{e_i}, then the number of divisors d(x) = Π (e_i + 1).
- Therefore factor a and b where {a,b} = {n/2, n+1} (or {n, (n+1)/2}), merge exponents, and compute Π (e_i+1).

3) Iterative search for n
- For n from 1 upward:
  - Compute a,b as above.
  - Factor a and b using trial division by primes ≤ √max(a,b) (maintain a small prime list).
  - Combine exponents and compute d(T_n).
  - If d(T_n) > D, return T_n.

4) Java building blocks
- Prime list via sieve up to a moving bound, or trial division on the fly.
- HashMap<Prime,Integer> for exponents; multiply (e+1) in long.

5) Complexity
- Dominated by repeated small factorizations. With prime caching, this runs fast for Euler-scale D (e.g., D=500).

6) Edge cases
- D < 1 → T_1 = 1 qualifies.
- Watch for overflow when forming T_n; use long for n and T_n.

7) Testing mindset
- Spot checks: D=1 → 3 (T_2); D=5 → 28; Euler asks D=500 → 76576500.

## Reusable template (for similar problems)

When you need divisor counts of structured numbers:
- Decompose into coprime factors to simplify factoring (like n and n+1).
- Count divisors from prime exponents using Π (e+1).
- Cache primes or small factors to amortize cost across many queries.

## Practical examples and business impact

- Co-prime decomposition in scheduling/CRT-like systems
  - Problem: Analyze combined periods from near-coprime parts cheaply.
  - Model: Split into n and n+1 halves (coprime) to compute properties.
  - Impact: Faster feasibility checks and capacity planning.

- Indexing and bucketing by factor structure
  - Problem: Improve selectivity estimates and joins.
  - Model: Bucket by divisor counts/factor signatures.
  - Impact: Better query plans and caches.

- Load distribution fairness
  - Problem: Choose counts with many divisors to allow flexible partitioning.
  - Model: Prefer numbers with high d(x) for shards/teams.
  - Impact: Easier rebalancing.

- Packaging and bin packing presets
  - Problem: Pick sizes divisible by many small factors.
  - Model: Factor counts to maximize divisor options.
  - Impact: Reduced waste.

- Cryptosystems toy models
  - Problem: Teach divisor functions and factorization rapidly.
  - Model: Use T_n decomposition to demonstrate d(n).
  - Impact: Clear pedagogy.

- Simulation parameter grids
  - Problem: Build grids with flexible subdivision.
  - Model: Favor parameters with high divisor counts.
  - Impact: Faster sweeps and allocations.

- Scheduling work-rotation cycles
  - Problem: Design cycles with many alignment options.
  - Model: Use counts with large d(n) to increase feasible rotations.
  - Impact: Happier schedules.

- Data partition compaction
  - Problem: Merge partitions efficiently.
  - Model: Factor sizes to choose merge factors.
  - Impact: Lower IO.

- Education tools for multiplicative functions
  - Problem: Visualize d(n) via exponent products.
  - Model: Show Π(e+1) from prime exponents.
  - Impact: Strong intuition.

- Heuristics for search bounds
  - Problem: Estimate when d(T_n) exceeds thresholds.
  - Model: Use average orders and coprime splits for bounds.
  - Impact: Targeted searches.

## Key takeaways

- Use T_n’s coprime structure to halve the work.
- Convert factorization to exponent counts → multiplicative divisor function.
- Cache primes; stop as soon as the threshold is exceeded.

## Java implementation (Euler012.java)

- Helper: `countDivisors(long n)` performs trial division to compute the number of positive divisors of n via prime-exponent counts.
- Core: `firstTriangleOverDivisors(int threshold)`
  - For increasing n, forms coprime factors (n/2 and n+1) or (n and (n+1)/2) depending on n’s parity.
  - Multiplies `countDivisors` of each factor to get d(T_n); when it exceeds the threshold, returns T_n as `a*b`.
- CLI: `main(String[] args)` defaults threshold = 500; accepts optional first arg; prints the first qualifying triangular number.
