# Euler003 — Largest prime factor (from first principles)

Find the largest prime factor of a given integer n (n ≥ 2).

## Problem statement

Given an integer n ≥ 2, return the largest prime p that divides n.

## Step-by-step reasoning

## Approach

Strip factor 2, then trial-divide by odd numbers up to √n, dividing out each factor fully; any leftover >1 is the largest prime factor.

1) Define the goal
- Input: n (≥ 2).
- Output: the largest p such that p is prime and p | n.

2) Start with trial division (simple and reliable)
- Repeatedly divide out factor 2 while n is even.
- Then try odd factors f = 3, 5, 7, … while f*f ≤ n.
  - While f divides n, set `largest = f` and divide `n /= f`.
  - Increase f by 2 (skip evens).
- If, after the loop, `n > 1`, then `n` itself is prime and is the largest factor.

Why this works: whenever a composite factor appears, you strip it out. The remaining `n` will shrink; the last remaining (if > 1) must be prime and is ≥ any factor already seen.

3) Complexity and when to optimize
- Worst-case roughly O(√n) divisions (trying odd f up to √n). Divisions only occur a few times per factor due to repeated division.
- For 64-bit inputs, this is usually fast. For very large integers (hundreds of digits), consider advanced methods (Pollard’s Rho, ECM).

4) Typical pitfalls

## Edge Cases

- n < 2: Out of scope (no prime factors). Return 0 or error if validating.
- n prime: Loop ends with n > 1; that remainder is the largest factor.
- Power of 2: After removing 2s, n = 1 quickly; ensure last recorded factor is 2.
- Large prime factor near √n: Ensure `f * f <= n` uses long to prevent overflow.
- Negative input: Not required for Euler; validate in production.

## Complexity

- Time: O(√n) worst-case (n prime). Reduces as n shrinks when small factors exist.
- Space: O(1).
- Larger (multi-precision) inputs may warrant Pollard's Rho / ECM.
- Forgetting to handle factor 2 separately (makes loop simpler and faster).
- Using `int` and overflowing; prefer `long` for 64-bit n.
- Loop condition must be `f*f <= n` (use long to avoid overflow in `f*f`).

## Reusable template
- Factor out small primes first (2), then scan odd candidates up to √n.
- Record factors as you go (counts if needed); finish by checking leftover n.

## Practical examples and business impact

- Ratio simplification / canonical forms
  - Problem: Reduce fractions or normalize ratios in data pipelines.
  - Model: Factor numerator/denominator; divide by gcd to canonicalize.
  - Impact: Better cache keys and join performance.

- Scheduling and tiling cycles
  - Problem: Align periodic tasks to minimize collisions.
  - Model: Use prime factors of cycle lengths; select co‑prime periods.
  - Impact: Smoother traffic shaping and fewer clashes.

- Cryptography hygiene (sanity checks)
  - Problem: Verify small synthetic keys or test vectors.
  - Model: Factor small integers; assert properties quickly.
  - Impact: Fast validation with lightweight code.

- Database sharding diagnostics
  - Problem: Diagnose hotspotting due to poorly chosen shard counts.
  - Model: Inspect prime factors of table sizes and shard counts.
  - Impact: Pick co‑prime partitions; reduce contention.

- Signal processing and FFT sizes
  - Problem: Choose transform sizes for speed.
  - Model: Prefer sizes with small prime factors (radix‑friendly); detect largest factor to decide plan.
  - Impact: Faster pipelines and lower latency.

- Manufacturing batch decomposition
  - Problem: Split a batch into prime‑sized sub‑batches for QA sampling.
  - Model: Factor batch size; largest factor bounds sub‑batch sizes.
  - Impact: Predictable sampling effort.

- Security auditing of IDs
  - Problem: Detect weak ID schemes where counts share large factors with cycle lengths.
  - Model: Factor counts; adjust modulo schemes.
  - Impact: Lower collision risk.

- Compression block sizing
  - Problem: Choose block sizes with favorable factorization for parallel merge/split.
  - Model: Use largest prime factor to avoid pathological splits.
  - Impact: Higher throughput.

- Education/demonstration tooling
  - Problem: Teach factorization visually with immediate feedback.
  - Model: Run trial division up to sqrt(n) and highlight factors.
  - Impact: Better understanding; quick correctness checks.

- Finance settlement cycles
  - Problem: Align settlement windows across systems with different cycle lengths.
  - Model: Analyze prime factors; plan co‑prime adjustments.
  - Impact: Fewer reconciliation conflicts.

## Java implementation (Euler003.java)

- Method: `largestPrimeFactor(long n)` implements the trial-division approach.
  - Strips factor 2 with a while loop using bit check `(n & 1) == 0`.
  - Tries odd factors `f = 3, 5, …` while `f*f <= n`, dividing out all repetitions and tracking `largest`.
  - If `n > 1` at the end, that remaining `n` is prime and is the largest factor.
- CLI: `main(String[] args)` uses default `n = 600_851_475_143L` and allows overriding via the first argument; prints the result to stdout.

## Key Takeaways
- Trial division with 2 then odd f up to √n gets you a robust, beginner-friendly solution.
- Always check if a prime remainder > 1 remains; that’s your largest factor.
- Scale up to Rho/ECM only when input sizes demand it.
