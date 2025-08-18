# Euler003 — Largest prime factor (from first principles)

Find the largest prime factor of a given integer n (n ≥ 2).

## Problem-solving approach

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
- Forgetting to handle factor 2 separately (makes loop simpler and faster).
- Using `int` and overflowing; prefer `long` for 64-bit n.
- Loop condition must be `f*f <= n` (use long to avoid overflow in `f*f`).

5) Reusable template
- Factor out small primes first (2), then scan odd candidates up to √n.
- Record factors as you go (counts if needed); finish by checking leftover n.

## Real-world analogues and impact

- Ratio simplification / canonical forms
  - Factorization lets you reduce fractions or normalize ratios. This is useful in data deduplication where canonical keys matter.
  - Impact: Better cache keys and join performance by working with reduced forms.

- Scheduling and tiling cycles
  - Prime factors of cycle lengths determine when processes align. Computing largest/specific prime factors helps choose co-prime periods to minimize collisions.
  - Impact: Fewer collisions in task schedulers, smoother traffic shaping.

- Cryptography hygiene (sanity checks)
  - While real keys are too large, factorization logic is still used in small-scale tests and property checks.
  - Impact: Quick validation pipelines without heavy math libraries.

## Key takeaways
- Trial division with 2 then odd f up to √n gets you a robust, beginner-friendly solution.
- Always check if a prime remainder > 1 remains; that’s your largest factor.
- Scale up to Rho/ECM only when input sizes demand it.
