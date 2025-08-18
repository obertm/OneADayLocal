# Euler002 — Sum of even Fibonacci numbers below a limit (from first principles)

This guide explains a clear problem‑solving path for Euler002, starting simple and then introducing optimizations. You can reuse the same pattern whenever you need to generate a sequence up to a threshold and aggregate elements that match a property.

## Problem statement

Given a positive integer limit L, compute the sum of all even Fibonacci numbers that do not exceed L.
- Fibonacci sequence starts 1, 2, 3, 5, 8, 13, 21, 34, … (each term is the sum of the previous two).
- For L = 100, the even Fibonacci numbers ≤ 100 are 2, 8, 34 → sum = 44.
- For L = 4_000_000 (4 million), the answer is 4,613,732.

## Step‑by‑step reasoning

1) Inputs/outputs
- Input: integer L (L ≥ 1), default 4_000_000 if not provided.
- Output: single integer: sum of even Fibonacci numbers not exceeding L.

2) Start simple: iterate Fibonacci numbers up to L
- Keep two variables for the last two Fibonacci numbers (call them a and b).
- On each step: `next = a + b; a = b; b = next;` until `b > L`.
- If the current term `b` is even (`b % 2 == 0`), add it to the sum.

Why this first? It’s easy to write, easy to reason about, and for common limits is fast enough.

3) Java building blocks used
- Variables: `long a, b, sum` for safety against overflow; `int` or `long` for the limit.
- Loop: `while (b <= limit) { ... }`
- Parity check: `(b & 1) == 0` (equivalent to `b % 2 == 0`).
- Method extraction: `sumEvenFib(int limit)` does the work; `main` parses args and prints.

4) Code (straightforward iteration)
This is exactly what `Euler002.sumEvenFib` implements:
- Initialize `a = 1, b = 2, sum = 0`.
- While `b <= limit`:
  - If `b` is even, add to `sum`.
  - Advance the sequence: `next = a + b; a = b; b = next;`.
- Return `sum`.

5) Complexity & when to optimize
- Let k be the number of Fibonacci terms up to L; k is about O(log L) because Fibonacci grows exponentially.
- Time: O(k) operations, which is already excellent for very large L.
- Space: O(1) extra space.

6) Optimization ideas (two classic improvements)
- Observation: Every third Fibonacci number is even. The parity pattern of Fibonacci is odd, odd, even, then repeats.
  - Even terms form their own recurrence: E(1)=2, E(2)=8, E(3)=34, … and satisfy: E(n) = 4*E(n-1) + E(n-2).
  - You can iterate only over even Fibonacci terms using this recurrence, reducing work by ~3x (still O(k), but smaller k).

- Closed-form/fast-doubling (optional):
  - If you need the nth Fibonacci in O(log n), use matrix exponentiation or fast‑doubling formulas.
  - For this problem we don’t need random access; simple iteration (all terms or just even terms) is typically fastest and simplest.

Example of iterating only even terms:
```java
static long sumEvenFibEvenOnly(long limit) {
    long e1 = 2;      // E(1)
    long e2 = 8;      // E(2)
    long sum = 0;
    while (e1 <= limit) {
        sum += e1;
        long e3 = 4 * e2 + e1; // next even term based on previous two
        e1 = e2;
        e2 = e3;
    }
    return sum;
}
```

7) Edge cases
- L < 2 → no even Fibonacci numbers (sum = 0).
- Very large L → use `long` for the running sum and terms; consider `BigInteger` only if L is astronomically large (beyond 64‑bit terms).
- Invalid input → for Project Euler we assume valid numeric input; in production, validate and fail gracefully.

8) Testing mindset
- Quick checks: L=1 → 0; L=2 → 2; L=10 → 10 (2 + 8); L=34 → 44 (2 + 8 + 34).
- Cross‑verify: compare the straightforward iteration and the “even‑only” recurrence on random limits.

## Reusable template (for similar sequence problems)
When facing “sum elements of a recurrence sequence up to a threshold that satisfy property P”:
1) Define the base recurrence and the property P clearly (e.g., parity, divisibility, digit pattern).
2) Start with a simple generator loop up to the threshold; filter by P; aggregate.
3) Look for structure:
   - Parity or modulo patterns that repeat (like every 3rd term even).
   - A secondary recurrence that generates only the desired subsequence (like E(n) = 4E(n-1) + E(n-2)).
   - Fast‑doubling or matrix methods if random access or huge n is required.
4) Keep state minimal (constant space) unless the problem requires history or memoization.
5) Validate with small cases and one larger case.

## Practical examples from the real world

- Retry/backoff schedules with cost caps
  - Problem: Many systems use exponential or Fibonacci‑like backoff. You may want to sum only attempts that land on “even” steps (or steps matching a cadence) to estimate cost or load until a cutoff L.
  - Model: Generate terms up to L; filter parity (or modulo class); sum costs.
  - Impact: Accurate budget/load forecasts for SRE planning; avoids over‑provisioning.

- Tiered loyalty or rewards programs
  - Problem: Award points on actions whose counts follow a growth pattern (e.g., Fibonacci milestones) but only count “even milestones” for premium tiers.
  - Model: Iterate terms up to L or use the even‑only recurrence; compute sums instantly.
  - Impact: Predictable rewards liabilities and clear tiering logic.

- Inventory ramp‑ups and inspection cadences
  - Problem: When ramping production following a growth curve, sample or inspect every even milestone to maintain quality.
  - Model: Sum metrics at selected milestones; even‑only iteration reduces computation.
  - Impact: Ensures QA coverage with minimal processing overhead.

- Streaming pipelines: selective windowing
  - Problem: Apply heavier analytics only on windows that fall on certain indices (e.g., every 3rd or even window) while still projecting total heavy‑compute cost up to L.
  - Model: Generate indices; filter by parity/modulo; sum projected costs.
  - Impact: Controls cloud costs and keeps SLAs.

Snippets to translate the pattern:
- SQL (conceptual; sequences often materialized upstream):
  ```sql
  -- Imagine a table fib(n, val) up to L
  SELECT SUM(val) FROM fib WHERE val % 2 = 0 AND val <= :L;
  ```
- Java (straight iteration):
  ```java
  long sum = 0, a = 1, b = 2;
  while (b <= L) {
      if ((b & 1) == 0) sum += b;
      long next = a + b; a = b; b = next;
  }
  ```
- Java (even‑only recurrence): see `sumEvenFibEvenOnly` above.

## Key takeaways
- Start with a simple generator and a filter; it’s easy, correct, and usually fast.
- Exploit structure to skip work: here, every 3rd Fibonacci is even; iterate only even terms via E(n) = 4E(n-1) + E(n-2).
- Favor O(1) space and O(log L) time when possible; only reach for heavier math (fast‑doubling) if the problem demands it.
