# Euler013 — Large sum (first 10 digits)

Sum many 50-digit numbers and output the first 10 digits of the result.

## Problem statement

Given N large integers (≈50 digits each), compute the sum S and return the first 10 digits of S.

## Step-by-step reasoning

1) Use exact integer arithmetic
- Avoid floating point; use BigInteger or manual column addition to prevent rounding/precision loss.

2) Two robust paths
- BigInteger path: parse each line as `new BigInteger(line)`, accumulate with `.add`, then convert to string and take the first 10 digits.
- Manual addition: add columns right-to-left into an int array with carry propagation; after finishing, read off the most significant digits. This avoids BigInteger if restricted.

3) Java building blocks
- BigInteger for simplicity; String parsing; StringBuilder to extract prefix.

4) Complexity
- O(N·L) where N is count and L is digits per number; memory O(L).

5) Edge cases
- Leading zeros in inputs are fine; outcome may have more than 50 digits—prefix extraction must handle that.
- Trim newline/quotes if input is quoted (Euler provides clean lines).

6) Testing mindset
- Create a small set of known sums; verify both BigInteger and manual addition yield identical prefixes.

## Reusable template (for similar problems)

When summing many large integers and only a prefix is needed:
- Use exact integer math (BigInteger or column-wise) and extract the prefix at the end.
- Avoid per-line formatting overhead; parse once, accumulate once.

## Practical examples and business impact

- Financial ledgers at scale
  - Sum thousands of high-precision amounts; return statement headers or preview prefixes.
  - Impact: Prevents rounding bugs; keeps audits clean.

- Telemetry aggregation
  - Aggregate large counters exactly across shards.
  - Impact: Accurate dashboards and capacity triggers.

## Key takeaways

- Prefer exact integer addition; extract only what you need (first 10 digits) at the end.
- Manual addition is an implementation fallback with identical complexity.
