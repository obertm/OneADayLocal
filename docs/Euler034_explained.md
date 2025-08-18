# Euler034 — Digit factorials

## Problem statement

Find all numbers that are equal to the sum of the factorials of their digits (excluding single-digit trivial cases), and return their sum.

## Step-by-step reasoning

1) Precompute digit factorials
- Compute `fact[0..9]` once.

2) Upper bound
- For a d-digit number, the maximum sum is d·9!. Find the smallest d such that d·9! < 10^{d−1}; a practical cap is 7·9! = 2,540,160. Search from 10 up to this limit.

3) Scan and test
- For each n, sum `fact[digit]`; if the sum equals n, include it in the answer.

## Reusable template (for digit-function fixed points)

- Cache per-digit contributions.
- Derive a proof-based upper bound using digit extremes.
- Linear scan with digit decomposition and equality check.

## Practical examples and business impact

- Fraud scoring: per-digit features contribute cached weights; scan portfolios and flag fixed-point anomalies.
- Embedded validation: checksum schemes with per-digit factorial-like transforms; fast verification via lookup.
- Image hash digitization: simulate per-digit contributions of hashed pixels; bounded enumeration avoids overrun in edge devices.
- Catalog dedupe: score items by digit-derived signatures; fixed points indicate suspicious catalog entries.
- Simulation throttling: use theoretical bounds to cap scenario counts, ensuring simulations fit SLAs.
- Gamification scoring: define badge scores as sum of digit-contributions; detect special fixed-point achievements.
- Telemetry normalization: map digit streams to weighted sums; precomputed tables accelerate stream processing.
- QA fuzzing: generate only within tight numeric bounds to stress-test digit-transformation pipelines.
- IoT firmware: tiny per-digit lookup tables reduce CPU and power for continuous checks.
- HPC batching: bound-heavy workloads to keep cluster utilization predictable; demonstrate bound rationale to schedulers.

## Key takeaways

- Tight bounds + cached digit contributions make for a quick linear pass.

## Java implementation (Euler034.java)

- Precompute `fact[0..9]`; set `ub = 7 * fact[9]`.
- Loop `n` from 10 to `ub`, sum factorials of digits, compare to n; if equal, add to total.
- Print the final total.
