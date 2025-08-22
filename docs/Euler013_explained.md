# Euler013 — Large sum (first 10 digits)

Sum many 50-digit numbers and output the first 10 digits of the result.

## Problem statement

Given N large integers (≈50 digits each), compute the sum S and return the first 10 digits of S.

## Step-by-step reasoning

## Approach

Parse each 50‑digit number as BigInteger and accumulate; convert sum to decimal string once and slice first 10 digits. Alternate manual column addition exists if BigInteger were disallowed.

1) Use exact integer arithmetic
- Avoid floating point; use BigInteger or manual column addition to prevent rounding/precision loss.

2) Two robust paths
- BigInteger path: parse each line as `new BigInteger(line)`, accumulate with `.add`, then convert to string and take the first 10 digits.
- Manual addition: add columns right-to-left into an int array with carry propagation; after finishing, read off the most significant digits. This avoids BigInteger if restricted.

3) Java building blocks
- BigInteger for simplicity; String parsing; StringBuilder to extract prefix.

4) Complexity
- O(N·L) where N is count and L is digits per number; memory O(L).

## Complexity

- Time: O(N·L) additions on base 2^32/2^N words (BigInteger optimized).
- Space: O(L) digits for running sum.
- Manual column add has same asymptotic with slightly lower constant.

## Edge Cases

- Leading zeros: Preserve them during parsing; BigInteger handles them; they do not affect the sum.
- Variable line lengths: Ignore blank lines or trailing whitespace; trim each line before parsing to prevent NumberFormatException.
- Prefix longer than sum length: If requested prefix n exceeds digit count, return the full sum (implementation already guards via substring logic).
- Mixed input size: If some numbers are shorter, left-pad logically (BigInteger parsing already treats them correctly); manual column addition must explicitly treat missing digits as 0.
- Extremely large N: Memory still modest; consider streaming (process line by line) rather than holding all numbers.

## Testing mindset
- Hand-compute a tiny set (e.g., 2 numbers) and verify prefix.
- Compare BigInteger vs manual column method outputs for random synthetic sets.


## Reusable template (for similar problems)

When summing many large integers and only a prefix is needed:
- Use exact integer math (BigInteger or column-wise) and extract the prefix at the end.
- Avoid per-line formatting overhead; parse once, accumulate once.

## Practical examples and business impact

- Financial ledgers at scale
  - Problem: Sum many high-precision amounts; show header digits.
  - Model: Exact BigInteger addition; slice leading digits.
  - Impact: Audit-safe previews.

- Telemetry aggregation
  - Problem: Aggregate large counters across shards exactly.
  - Model: BigInteger sums or column-wise addition.
  - Impact: Accurate capacity triggers.

- Blockchain analytics
  - Problem: Sum balances/values with 256-bit precision.
  - Model: Use arbitrary-precision addition and prefix reporting.
  - Impact: Correctness across big ranges.

- Scientific measurements
  - Problem: Accumulate very large integer counts (events/reads).
  - Model: Exact integer aggregation; prefix for dashboards.
  - Impact: No precision loss.

- Billing pre-invoices
  - Problem: Generate previews showing only first 10–12 digits quickly.
  - Model: Sum exactly; format prefix only.
  - Impact: Faster UX.

- ETL checkpointing
  - Problem: Maintain exact row-count sums from many sources.
  - Model: BigInteger counters; periodic prefix logs.
  - Impact: Reliable lineage.

- Risk engines
  - Problem: Add large exposure numbers with no rounding.
  - Model: BigInteger totals; extract report prefixes.
  - Impact: Compliance-friendly.

- Archival integrity checks
  - Problem: Combine large chunk sizes/checksums counts.
  - Model: Exact sums; small prefixes for logs/alerts.
  - Impact: Trustworthy operations.

- Education / competitions
  - Problem: Show how exact arithmetic avoids float pitfalls.
  - Model: Side-by-side demo with floats vs BigInteger.
  - Impact: Strong intuition.

- Distributed map-reduce sums
  - Problem: Partial sums are large; final aggregator needs exactness.
  - Model: BigInteger reduction and prefix display.
  - Impact: Correct results at scale.

## Key Takeaways

- Prefer exact integer addition; extract only what you need (first 10 digits) at the end.
- Manual addition is an implementation fallback with identical complexity.

## Java implementation (Euler013.java)

This solution uses `java.math.BigInteger` to keep exact precision while summing 100 numbers with ~50 digits each.

- Data: The 100 numbers are stored in a `String[] NUMBERS` constant.
- Core method: `firstNDigitsOfSum(int n)`
  - Start with `BigInteger sum = BigInteger.ZERO;`.
  - Loop over each string s in `NUMBERS` and do `sum = sum.add(new BigInteger(s));`.
  - Convert to decimal text: `String str = sum.toString();`.
  - Return the prefix: `str.length() <= n ? str : str.substring(0, n)`.
- CLI behavior: `main(String[] args)` defaults `n = 10`; if a first argument is provided, it tries to parse it as the number of leading digits; it then prints the result.

Classroom notes:
- Why BigInteger? 64-bit integers overflow immediately at this size; BigInteger grows to as many digits as needed and stays exact.
- Why string then substring? We only need the first n digits; converting once and slicing is simple and fast enough for 100 inputs.
- Alternative: Manual column addition avoids BigInteger but is more code; performance is similar at this scale.
