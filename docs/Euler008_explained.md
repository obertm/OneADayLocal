# Euler008 — Largest product in a series

Given a long string of digits and a window size k, find the maximum product of any k consecutive digits.

## Steps to reproduce

1) Parse and validate inputs
- Ensure window (k) is 1..length.

2) Split by zeros and process zero-free segments
- A zero in the window zeroes the product; treat the string as segments separated by zeros.
- For each segment with length ≥ k:
  - Compute the product of the first k digits.
  - Slide the window: divide by outgoing digit and multiply by incoming digit.
  - Track the maximum.

3) Why segmenting helps
- Avoids recomputing across zeros where product would be 0 anyway.
- Sliding window keeps it O(n).

4) Complexity
- O(n) time, O(1) extra space.

## Reusable pattern
- For “max product/sum in sliding window”: split on zero-like blockers and maintain a rolling aggregate.

## Real-world analogues and impact

- Fraud/risk detection over rolling windows
  - Maintain a rolling score over k recent events; reset segments at blockers (e.g., high-severity alerts).
  - Impact: O(n) processing with constant memory in streaming analytics.

- Forecasting with windowed features
  - Compute features like moving products/sums efficiently.
  - Impact: Lower latency and compute costs in real-time models.

## Key takeaways
- Use sliding windows; reset at zeros.
- Keep integer-safe operations; beware of overflow if window is large.
