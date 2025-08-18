# Euler020 — Factorial digit sum (n!)

Compute the sum of the decimal digits of n! (n factorial).

## Problem statement

Given an integer n ≥ 0, compute S(n) = sum of digits of n!. For example, 10! = 3628800 so S(10) = 3+6+2+8+8+0+0 = 27.

## Step-by-step reasoning

1) Inputs/outputs
- Input: integer n (n ≥ 0). Default per Euler is n = 100.
- Output: integer digit-sum of n!.

2) Baseline method: exact factorial with arbitrary precision
- Ordinary 64-bit integers overflow quickly (20! already exceeds 64-bit). Use `java.math.BigInteger`.
- Multiply the integers 2..n into an accumulator `BigInteger fact`.
- Convert `fact` to a decimal string and sum its digits, or repeatedly divide by 10 to extract digits.

3) Java building blocks used
- BigInteger arithmetic: `multiply(BigInteger)`, `valueOf(long)`.
- String processing: `toString()` then iterate chars and add `c - '0'`.
- Looping from 2 to n; handle n = 0 or 1 by returning 1 for factorial before digit sum.

4) Code outline (what Euler020.java does)
- Initialize `BigInteger fact = BigInteger.ONE`.
- For i = 2..n: `fact = fact.multiply(BigInteger.valueOf(i))`.
- `String s = fact.toString();` then `sum += (s.charAt(k) - '0')` for all k.
- Print `sum`.

5) Complexity
- BigInteger multiplication cost depends on digits; denote it M(D).
- Total time ≈ sum over i=2..n of M(D(i!)). Digits in i! grow like Θ(i log i), so later steps dominate.
- Digit summation is O(D) where D is number of digits in n! (~ Θ(n log n)).

6) Optimizations and variants
- Manual digit arrays: simulate grade-school multiplication in an int array (base 10 or base 1e9) to avoid repeated BigInteger allocations. Java’s BigInteger is usually sufficient here.
- Base-1e9 chunks: store big numbers in base 10^9 to reduce length and sum digits at the end.
- Parallel product trees: helpful for very large n; not necessary for Euler scale.

7) Edge cases and correctness
- n = 0 or 1 → 1! = 1 → digit sum 1.
- Large n → ensure BigInteger is used throughout; avoid accidental 64-bit overflow in intermediates.
- Locale/format → use `toString()` in base 10; no separators.

8) Testing mindset
- Small checks: n=0→1, n=1→1, n=3→6→sum=6, n=10→3628800→27.
- Cross-check BigInteger vs manual digit-array implementation on random n.

## Reusable template (for similar problems)

When you need exact results for huge combinatorial quantities (factorials, binomials, permutations):
- Choose an arbitrary-precision type (BigInteger).
- Keep the core algorithm simple and exact (multiply 2..n or use product trees).
- Post-process once in base 10 for digit-based metrics.
- Validate with small cases; profile before over-optimizing.

## Practical examples and business impact

- Combinatorial risk and capacity planning
  - Estimating counts of permutations/combinations (e.g., SKU bundles or routing configurations) grows factorially. BigInteger avoids overflow and keeps audits exact.
  - Impact: Accurate capacity/risk estimates; no silent truncation.

- Data integrity via digit checksums
  - Pipelines sometimes store decimal digit checks. Pattern here (compute exact value → derive digit sum) mirrors such validations.
  - Impact: Explainable, language-agnostic validation logic at any scale.

- Pricing and billing simulations
  - Simulating exhaustive combinations of fees/tiers can produce huge totals. Compute exactly, then derive concise metrics like digit sums or mod checks.
  - Impact: Prevents financial errors and improves compliance.

## Key takeaways

- Use BigInteger for exactness at Euler scales.
- Separate the big-number computation from the final digit aggregation.
- Prefer simple, verifiable loops; optimize only if needed.

## Java implementation (Euler020.java)

We compute n! with BigInteger and then sum its decimal digits.

- Public method: `sumDigitsOfFactorial(int n)`
  - Initialize `BigInteger fact = BigInteger.ONE`.
  - For i = 2..n: `fact = fact.multiply(BigInteger.valueOf(i))`.
  - Convert to text: `String s = fact.toString();`.
  - Sum digits: loop chars and add `c - '0'` to an `int sum`.
  - Return `sum`.
- CLI: `main(String[] args)` defaults `n = 100`; optional first arg overrides; prints the digit sum.

Classroom notes:
- 64-bit overflow: 20! already exceeds long; BigInteger is necessary for exact results.
- Separation of concerns: compute factorial first, then do digit work; keeps the program easy to reason about and test.
- For very large n, you can avoid the intermediate string by repeatedly dividing by 10 with `divideAndRemainder` and accumulating remainders.
