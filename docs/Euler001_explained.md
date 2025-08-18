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

## Practical examples from the real world (where this pattern shows up)

These are real or realistic scenarios where “sum/count items divisible by a set of factors” appears. The same loop-or-formula approach applies.

- Marketing promotions scheduling
    - Problem: Trigger a promo or email campaign for customers on a repeating cadence (e.g., every 3rd or 5th day since signup) without double-contacting on overlaps.
    - Model: Let d be “days since signup.” Customers with d % 3 == 0 or d % 5 == 0 are eligible; if both, count once (use inclusion–exclusion if using closed form). 
    - Impact: Predictable pacing, coverage measurement, and budget control. The closed-form can estimate daily send volumes quickly for planning.

- Subscription billing cycles and proration buckets
    - Problem: Bucket accounts into recurring billing cycles (e.g., triweekly or on days divisible by 5) and forecast load on billing infrastructure.
    - Model: Count users whose cycle day satisfies day % 3 == 0 or day % 5 == 0; use the O(1) formula for instant capacity planning per time window.
    - Impact: Avoids over-provisioning and reduces compute by using formulas instead of scanning all accounts.

- Manufacturing quality checks
    - Problem: Inspect every 3rd or 5th item on a production line, aggregating the inspected count per shift.
    - Model: For item indices i < N, filter i % 3 == 0 || i % 5 == 0; sum counts per shift. Use inclusion–exclusion to forecast inspections for target throughput N.
    - Impact: Ensures consistent QA coverage and accurate staffing forecasts.

- Data engineering bucketing and sampling
    - Problem: Create deterministic samples or shards (e.g., keep rows where id % 5 == 0) and project sample sizes without scanning.
    - Model: Use modulo filters (single or combined) and closed-form to estimate cardinalities quickly.
    - Impact: Faster ETL planning, lower costs by avoiding full scans; predictable sample sizes for A/B tests.

- Event analytics and rate limiting
    - Problem: Process or throttle only requests whose sequence number hits specific cycles (e.g., audit every 5th request; deep inspect every 15th).
    - Model: Apply modulo filters; if combining multiple rules, use inclusion–exclusion to estimate overlap and total workload.
    - Impact: Keeps systems within SLOs and reduces unnecessary processing while maintaining statistically sound coverage.

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
