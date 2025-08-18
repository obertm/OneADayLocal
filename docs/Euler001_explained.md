# Euler001 — Sum of multiples of 3 or 5 below N (from first principles)

This walkthrough explains the full problem‑solving approach for Euler001 in plain language, assuming only elementary Java knowledge. You can reuse the same thinking pattern for many "sum/filter" problems.

## Problem statement

Given a positive integer N, compute the sum of all natural numbers below N that are divisible by 3 or 5. For example:
- If N = 10, the numbers are 3, 5, 6, 9 → sum = 23.
- If N = 1000, the answer is 233168.

We want a program that:
- Accepts N (optionally from command‑line),
- Computes the sum,
- Prints the result.

## Step‑by‑step reasoning

1) Inputs/outputs
- Input: a single integer N (> 0), default N = 1000 if not provided.
- Output: a single integer: the sum of all numbers i with 1 ≤ i < N where i % 3 == 0 or i % 5 == 0.

2) Brute force first (clear and correct)
- Loop i from 1 to N‑1.
- If i is divisible by 3 or 5, add it to a running sum.
- Print the sum at the end.
- Divisible means remainder is 0: i % 3 == 0 or i % 5 == 0.

Why start with brute force? It is simple to write and easy to verify. For many constraints (e.g., N up to a few million), this is fast enough.

3) Java building blocks used
- Variables: `int` for the limit; `long` for the running sum (safer against overflow if N is large).
- For loop: `for (int i = 1; i < n; i++) { ... }`
- Conditionals: `if (i % 3 == 0 || i % 5 == 0)`
- Method extraction: Put logic into `sumMultiples3or5Below(int n)` so it’s testable and reusable.
- Main method: Parse `args`, provide default, print result.

4) Code (brute force)
This is exactly what `Euler001.sumMultiples3or5Below` implements:
- Initialize `long sum = 0`.
- Loop i from 1 to n‑1.
- If divisible by 3 or 5, add to sum.
- Return sum.

5) Complexity & when to optimize
- Time: O(N) operations; each checks two modulos and maybe one addition.
- Space: O(1), constant extra space.
- For N up to ~10^8, O(N) may be slow. If you need faster, use a closed‑form formula.

6) Closed‑form formula (optional optimization)
We can sum arithmetic progressions without looping:
- Sum of multiples of m below N is: m * sum of 1..k where k = floor((N-1)/m).
- Sum 1..k = k*(k+1)/2.
- We want multiples of 3 or 5, but numbers divisible by both (i.e., 15) get double‑counted, so subtract their sum (inclusion‑exclusion).

Formula:
- S3 = 3 * k3*(k3+1)/2, where k3 = floor((N-1)/3)
- S5 = 5 * k5*(k5+1)/2, where k5 = floor((N-1)/5)
- S15 = 15 * k15*(k15+1)/2, where k15 = floor((N-1)/15)
- Answer = S3 + S5 − S15

This runs in O(1) time and O(1) space.

Example N = 10:
- k3 = floor(9/3) = 3 → multiples = 3,6,9 → S3 = 3*(3*4/2) = 3*6 = 18
- k5 = floor(9/5) = 1 → multiples = 5 → S5 = 5*(1*2/2) = 5
- k15 = floor(9/15) = 0 → S15 = 0
- Total = 18 + 5 − 0 = 23

7) Edge cases
- N ≤ 1 → sum is 0 (nothing below N).
- Very large N → use `long` for intermediate math in the formula to avoid overflow.
- Negative or non‑numeric input → handle parsing errors or assume valid input for Project Euler context.

8) Testing mindset
- Quick checks: N=10 → 23; N=1 → 0; N=3 → 0; N=5 → 3; N=6 → 8 (3+5); N=16 → 60.
- Compare brute force vs formula for random N to ensure they match.

## Reusable template (for similar problems)
When facing problems like “sum/count numbers < N with property P”:
1) Define P precisely (e.g., divisible by a set of primes).
2) Start with a simple loop + if condition; keep it readable.
3) Identify patterns for optimization:
   - Divisibility → arithmetic progressions → closed forms with inclusion‑exclusion.
   - Digit properties → precompute or bitmask.
   - Prime properties → sieve, etc.
4) Extract logic into a method; keep `main` small for I/O only.
5) Add tests for a few small Ns and one larger case.

## Optional: formula version in Java

```java
static long sumMultiples3or5Below_formula(long n) {
    long n1 = n - 1;
    long k3 = n1 / 3;
    long k5 = n1 / 5;
    long k15 = n1 / 15;
    long s3 = 3 * k3 * (k3 + 1) / 2;
    long s5 = 5 * k5 * (k5 + 1) / 2;
    long s15 = 15 * k15 * (k15 + 1) / 2;
    return s3 + s5 - s15;
}
```

Both methods should return the same answers for all N ≥ 0.

## Practical examples and business impact

These real scenarios use the same modulo + inclusion–exclusion pattern; use the loop for clarity or the O(1) formula for planning at scale.

- Marketing promotions scheduling
    - Problem: Trigger a promo/email campaign on a cadence (every 3rd or 5th day since signup) without double-contacting on overlaps.
    - Model: Day d qualifies if d % 3 == 0 or d % 5 == 0; use inclusion–exclusion for forecasts.
    - Impact: Predictable pacing and budget control; closed-form gives instant volume estimates.

- Subscription billing cycles and proration buckets
    - Problem: Bucket accounts into recurring billing cycles and forecast billing-system load.
    - Model: Count users with cycle day meeting modulo rules; use O(1) formula for capacity planning.
    - Impact: Avoids over-provisioning and expensive scans.

- Manufacturing quality checks
    - Problem: Inspect every 3rd or 5th item; plan inspector staffing per shift.
    - Model: Filter indices by modulo; apply inclusion–exclusion to avoid double counting.
    - Impact: Consistent QA coverage and accurate staffing forecasts.

- Data engineering bucketing and sampling
    - Problem: Deterministic sampling/sharding (e.g., id % 5 == 0) with precomputed counts.
    - Model: Closed-form predicts cardinality without scanning.
    - Impact: Faster ETL planning; lower compute costs.

- Event analytics and rate limiting
    - Problem: Audit every 5th request; deep-inspect every 15th.
    - Model: Combine modulo rules; estimate workloads via inclusion–exclusion.
    - Impact: Keeps systems within SLOs while targeting heavy checks.

- Preventive maintenance scheduling
    - Problem: Run light vs heavy maintenance on different machine cycles (e.g., every 3rd vs 10th run).
    - Model: Model workloads by counting runs matching modulo classes; subtract overlaps.
    - Impact: Accurate maintenance windows and minimal downtime.

- IoT sensor sampling
    - Problem: Devices report at periodic intervals (e.g., every 3 or 5 minutes); gateways must size buffers.
    - Model: Estimate concurrent arrivals using modulo cadence math.
    - Impact: Right-size buffers and radio airtime budgets.

- Retail replenishment waves
    - Problem: Replenish SKUs on repeating cycles (daily/weekly sub-cadences).
    - Model: Forecast bins hitting cycle boundaries via modulo; inclusion–exclusion for overlapping waves.
    - Impact: Smooth warehouse labor and dock scheduling.

- Gaming reward schedules
    - Problem: Grant bonuses on periodic logins (every 3rd or 5th day).
    - Model: Use closed-form to project currency sinks/sources.
    - Impact: Balanced economies without heavy telemetry crunching.

- Course scheduling and assignments
    - Problem: Assign tasks on deterministic cadences across cohorts.
    - Model: Modulo filters define due dates; closed-form predicts grading load.
    - Impact: Staff planning and SLA adherence for graders/support.

Snippets to recognize/translate the pattern:
- SQL: `SELECT COUNT(*) FROM events WHERE (seq % 3 = 0 OR seq % 5 = 0) AND seq < :N;`
- Java Streams: `IntStream.range(1, N).filter(i -> i % 3 == 0 || i % 5 == 0).sum();`
- Forecast (no scan): use the closed‑form formula above to estimate counts/sums instantly.

## Future applications and why they matter (business impact)

- Capacity and cost forecasting
    - Use O(1) formulas to predict how many records meet periodic criteria without scanning warehouses. This saves cluster time and cloud spend.

- Campaign governance and compliance
    - Deterministic cadences (modulo rules) ensure no customer is over-messaged; inclusion–exclusion quantifies overlaps when multiple rules apply.

- Operational resilience
    - Quick estimates for “how many items will be processed on days like X” help plan staffing, batch windows, and SLA buffers.

- Experimentation velocity
    - Deterministic sampling via modulo supports reproducible A/B cohorts and allows precise pre-computation of sample sizes.

- Analytics explainability
    - Simple, auditable rules (divisibility, inclusion–exclusion) make dashboards and forecasts easier to reason about for non-engineers.

Key takeaway: start with a clear loop for correctness; when scale requires, switch to the closed-form to unlock instantaneous estimates and lower compute costs. The same thought process generalizes to many “sum/count with periodic criteria” problems.
