# Euler005 — Smallest multiple (LCM up to n)

Find the smallest positive number evenly divisible by all numbers from 1 to n.

## Problem statement

Given n ≥ 1, compute L = lcm(1, 2, …, n).

## Step-by-step reasoning

## Approach

Fold LCM across 1..n via gcd (ans = lcm(ans,i))—simple and robust. Alternate: compute highest prime powers ≤ n and multiply (same result, potentially faster for large n).

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

## Edge Cases

- n <= 0: Undefined; validate input.
- n = 1: Result is 1.
- Overflow risk: Use division-before-multiplication in lcm to reduce risk; for very large n use BigInteger.
- Duplicate inputs (generalized list): Folding LCM handles duplicates naturally.
- Non-monotonic input order: Irrelevant—LCM is commutative.

## Complexity

- GCD fold: O(n log n) (Euclid per step) with O(1) extra space.
- Prime-power (sieve): O(n log log n) time, O(n) space; beneficial for very large n.
- Reduce “divisible by 1..n” into a fold of LCMs using GCD, or compute prime powers ≤ n and multiply.

## Practical examples and business impact

- Calendar/schedule alignment
  - Problem: Find the first time multiple recurring events align.
  - Model: Compute lcm of their periods.
  - Impact: Reliable planning for releases or audits.

- Batch sizes and packaging
  - Problem: Choose batch size divisible by multiple container capacities.
  - Model: lcm of container sizes gives the minimal common batch.
  - Impact: Less waste, fewer changeovers.

- Sharding and sampling cycles
  - Problem: Pick sampling periods that minimize collisions across services.
  - Model: Favor co‑prime periods; overall alignment every lcm.
  - Impact: Smooth throughput and reduced hotspotting.

- Transportation timetables
  - Problem: Compute when buses/trains with different headways meet.
  - Model: lcm of headways gives the rendezvous interval.
  - Impact: Better passenger information and resource coordination.

- Distributed job orchestration
  - Problem: Align cron jobs with different frequencies to avoid overlaps.
  - Model: Use lcm to schedule safe windows.
  - Impact: Fewer collisions and missed SLAs.

- Inventory cycle counts
  - Problem: Plan full inventory checks when partial cycles cover subsets.
  - Model: lcm of cycle lengths determines full coverage cadence.
  - Impact: Predictable labor planning.

- Signal sampling and resampling
  - Problem: Align sample rates (e.g., 44.1 kHz and 48 kHz) without jitter.
  - Model: Use lcm of periods to design resamplers.
  - Impact: High‑quality audio/video processing.

- Education/assessment calendars
  - Problem: Align quizzes, labs, and reviews on different cadences.
  - Model: lcm gives combined milestone dates.
  - Impact: Balanced workload for students and staff.

- Finance payment schedules
  - Problem: Find when biweekly and monthly payments coincide.
  - Model: lcm of day counts (adjusted for calendars) approximates alignment.
  - Impact: Clearer cash‑flow planning.

- Microservice maintenance windows
  - Problem: Coordinate maintenance across services with heterogeneous check intervals.
  - Model: lcm‑based planning avoids cascading downtime.
  - Impact: Higher reliability and easier compliance.

## Key Takeaways
- Reduce to GCD/LCM folds or prime-power multiplication.
- Watch for overflow order in lcm = a / gcd(a,b) * b.

## Java implementation (Euler005.java)

- Helper: `gcd(long a, long b)` uses Euclid’s algorithm (iterative modulo) and returns `abs(a)` when `b` becomes 0.
- Helper: `lcm(long a, long b)` computes `a / gcd(a,b) * b` to avoid overflow.
- Core: `lcmUpTo(int n)` folds LCM from 2..n accumulating into a `long`.
- CLI: `main(String[] args)` defaults `n = 20` and prints the result; accepts an optional first arg.
