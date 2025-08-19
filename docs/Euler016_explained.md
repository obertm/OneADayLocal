# Euler016 — Power digit sum (2^n)

Compute the sum of digits of 2^n.

## Problem statement

Given n ≥ 0, compute S(n) = sum of decimal digits of 2^n.

## Step-by-step reasoning

1) Exact power computation
- Use BigInteger: `BigInteger.ONE.shiftLeft(n)` or `BigInteger.valueOf(2).pow(n)` to compute 2^n exactly.

2) Sum digits
- Convert to string and accumulate `c - '0'`, or repeatedly divide by 10 using `divideAndRemainder` to avoid building the whole string.

3) Complexity
- O(d) where d ≈ n·log10(2) is the number of digits; memory O(d) if using strings.

4) Edge cases
- n=0 → 1 → sum=1.
- Very large n → prefer divideAndRemainder to reduce peak memory.

5) Testing mindset
- Small checks: n=0→1; n=15→32768→sum=3+2+7+6+8=26; Euler asks n=1000.

## Reusable template (for similar problems)

When summing digits of huge exact integers:
- Compute the value with BigInteger or chunked arrays; avoid floating point.
- Extract digits via string or repeated mod/div by base.

## Practical examples and business impact

- Checksums for giant identifiers or hashes
  - Problem: Produce a human-auditable summary for very large IDs/hashes.
  - Model: Sum decimal digits of the exact value as a quick checksum.
  - Impact: Lightweight integrity checks without extra systems.

- Auditable reporting of exponential growth metrics
  - Problem: Report exponential trends (e.g., 2^n scenarios) with clear summaries.
  - Model: Compute exactly, store value, show digit-sum as a compact signal.
  - Impact: Accurate dashboards; preserves stakeholder trust.

- Big-integer pipeline smoke tests
  - Problem: Validate BigInteger computations across services.
  - Model: Compare digit sums of outputs across implementations.
  - Impact: Cheap cross-language consistency checks.

- Capacity planning for exponential backoff bounds
  - Problem: Backoff schedules reach huge counters; need quick sanity proxies.
  - Model: Use digit sum as a low-cost fingerprint of expected bounds.
  - Impact: Faster detection of misconfigurations.

- Data sharding keys sanity
  - Problem: Large numeric keys distributed by decimal transforms.
  - Model: Digit sums/roots serve as simple uniformity probes.
  - Impact: Early detection of skew.

- Education: exponent growth intuition
  - Problem: Teach how digit lengths scale with powers of 2.
  - Model: Compute 2^n and relate digit count and digit sum trends.
  - Impact: Stronger number-sense.

- Crypto training labs (toy)
  - Problem: Summarize big exponents without exposing full values.
  - Model: Publish digit sums as non-reversible signals.
  - Impact: Safer classroom exercises.

- Compression dictionary sizing previews
  - Problem: Anticipate magnitude of synthetic datasets.
  - Model: Use 2^n magnitudes and digit sums as quick checks.
  - Impact: Right-size memory ahead of time.

- Ledger rollup fingerprints
  - Problem: Large integer rollups across shards need quick verifiers.
  - Model: Compare digit sums after exact sums (no floats).
  - Impact: Confidence in nightly reconciliations.

- Monitoring guardrails
  - Problem: Detect implausible exponential outputs.
  - Model: Alert on digit-sum ranges inconsistent with n.
  - Impact: Early anomaly detection.

## Key takeaways

- BigInteger keeps results exact; digit sum is linear in number length.
- Choose digit extraction method based on memory constraints.

## Java implementation (Euler016.java)

We compute 2^n exactly and then sum its digits.

- Public method: `sumDigitsOfTwoPow(int n)`
  - Builds `BigInteger val = BigInteger.ONE.shiftLeft(n);` which equals 2^n.
  - Converts to decimal: `String s = val.toString();`.
  - Loops over characters and adds `s.charAt(i) - '0'` to an `int sum`.
  - Returns the sum.
- CLI: `main(String[] args)` defaults `n = 1000`; optional first arg overrides; prints the digit sum.

Classroom notes:
- Why `shiftLeft(n)`? It’s a fast, idiomatic way to compute 2^n with BigInteger (equivalent to pow(2, n)).
- Why string-based digit extraction? It’s simple and clear for teaching; for extremely large n, repeated divide-by-10 avoids creating a giant string.
- All arithmetic stays exact because BigInteger is arbitrary precision.
