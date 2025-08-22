# Euler008 — Largest product in a series

Given a long string of digits and a window size k, find the maximum product of any k consecutive digits.

## Problem statement

Given a digit string S and window length k, compute max over all windows of length k of the product of digits in the window.

## Step-by-step reasoning

## Approach

Sliding window product with zero segmentation: split the digit string by zeros (reset points) and maintain a rolling product within each zero-free segment, updating by dividing outgoing and multiplying incoming digits.

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

## Complexity

- Time: O(n) (each digit enters/exits window once within its segment).
- Space: O(1) beyond input storage.
- Zero splits prevent unnecessary O(k) recomputations after zero windows.

## Reusable template
- For “max product/sum in sliding window”: split on zero-like blockers and maintain a rolling aggregate.

## Practical examples and business impact
## Edge Cases

- k > length of string: Return 0 or error (undefined) – ensure validation.
- k = 0: Vacuous window; usually invalid – reject.
- Zeros inside window: reset segmentation logic; ensure division not attempted across zero.
- Overflow: For long windows product may overflow 64-bit; consider BigInteger or log-sum variant.
- Non-digit characters: Validate or strip; Euler input trusted.

- Fraud/risk detection over rolling windows
  - Problem: Maintain rolling risk over k events with resets on triggers.
  - Model: Sliding window; split on blockers (zeros) to avoid wasted work.
  - Impact: O(n) streaming with O(1) state.

- Forecasting with windowed features
  - Problem: Compute moving statistics efficiently.
  - Model: Sliding window products/sums; constant updates.
  - Impact: Lower latency feature pipelines.

- Time‑series anomaly detection
  - Problem: Flag windows with unusually high multiplicative interactions.
  - Model: Track max product across windows.
  - Impact: Early detection of compounding risks.

- E‑commerce conversion funnels
  - Problem: Score k‑step funnels; drop sessions with hard resets.
  - Model: Segment by resets; rolling computation per segment.
  - Impact: Faster funnel analytics.

- Network throughput monitoring
  - Problem: Track worst/best k‑second bandwidth windows.
  - Model: Sliding window aggregates.
  - Impact: Real‑time capacity insights.

- Audio/signal processing
  - Problem: Compute sliding energy/envelope with resets at silence.
  - Model: Segment on zeros; windowed products/sums.
  - Impact: Efficient analysis.

- Manufacturing SPC (statistical process control)
  - Problem: Monitor k‑unit rolling stability; reset on faults.
  - Model: Sliding window over defect indicators.
  - Impact: Quick response to drift.

- Edge device telemetry
  - Problem: Do windowed computations on constrained hardware.
  - Model: O(1) updates; skip zeroed segments.
  - Impact: Battery‑friendly analytics.

- Portfolio risk windows
  - Problem: Evaluate k‑day compounding risk bands.
  - Model: Sliding multiplicative window.
  - Impact: Faster risk reporting.

- Log analytics
  - Problem: Track rolling error density with resets on deploys.
  - Model: Split by deploy markers; sliding counts per segment.
  - Impact: Fast incident triage.

## Key Takeaways
- Use sliding windows; reset at zeros.
- Keep integer-safe operations; beware of overflow if window is large.

## Java implementation (Euler008.java)

- Core: `maxAdjacentProduct(String digits, int window)`
  - Validates `window` range and scans the digit string.
  - Splits by zeros into zero-free segments and processes only segments with length ≥ window.
  - Computes the first window’s product, then slides by dividing outgoing digit and multiplying incoming digit.
  - Tracks and returns the best product.
- Data: The 1000-digit constant is embedded as `NUM`.
- CLI: `main(String[] args)` defaults `window = 13`; first arg overrides; prints the maximum product.
