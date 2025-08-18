# Euler055 — Lychrel numbers (reverse-and-add)

Count how many numbers below 10,000 never form a palindrome within 50 reverse-and-add iterations.

## Method

- For n in 1..9999: iterate up to 50 times: n = n + reverse(n) using big integers; if a palindrome appears, mark non-Lychrel.
- Count those that never hit a palindrome within the limit.

## Complexity
- O(10000 × 50 × digits) with small big-int overhead.

## Practical examples and business impact

- Iterative refinement: reverse-and-add as a toy for convergence vs. divergence under caps.
- Data cleaning: iterative transformations with an iteration limit to avoid infinite loops.
- ETL safety: cap retries of reversible ops; detect non-converging records (Lychrel-like).
- Education: teach why iteration caps exist and how to choose them.
- Cryptanalysis toys: explore palindromic convergence under repeated transforms.
- Observability: dashboards that cap rollups and flag non-converging series.
- Simulation: study distributions of steps-to-palindrome as a stochastic measure.
- Embedded: fixed-iteration loops for deterministic timing; palindromicity checks as exits.
- QA fuzzing: generate seeds that don’t converge under the cap to test alerting.
- Documentation: highlight need for BigInteger when sums grow quickly.

## Takeaways
- Use BigInteger to avoid overflow; clear iteration cap and palindrome checks.


## Java implementation (Euler055.java)

- Class: `Euler055`
- For n in 1..9999, call `isLychrel(n)` which performs up to 50 reverse-and-add iterations using BigInteger.
- Helpers:
  - `reverseBig(BigInteger)` by reversing the decimal string.
  - `isPalindrome(BigInteger)` via two-pointer string check.
- If no palindrome appears within 50 iterations, count as Lychrel. Print the final count.
