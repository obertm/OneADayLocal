# Euler013 — Large sum (first 10 digits)

Sum many 50-digit numbers and output the first 10 digits of the result.

## Robust approach

1) Avoid floating point
- Use arbitrary precision (`BigInteger`) or manual column-wise addition.

2) Two paths
- BigInteger: parse each line `new BigInteger(line)`, accumulate with `.add`, then convert to string and take prefix.
- Manual addition: add columns right-to-left with carry; this works even if BigInteger is unavailable.

3) Complexity
- O(N·L) where N is number count and L is digits per number; memory O(L).

## Real-world analogues and impact
- Financial pipelines summing large amounts precisely.
  - Impact: Exact arithmetic prevents rounding bugs and audit issues.
- Telemetry aggregation of high-precision counters.
  - Impact: Maintains fidelity without loss.

## Takeaways
- Use exact integer arithmetic for big sums; output only the required prefix at the end.
