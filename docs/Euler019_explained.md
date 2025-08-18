# Euler019 — Counting Sundays

Count how many Sundays fell on the first of the month during a given date range (e.g., 1901-01-01 to 2000-12-31).

## Problem statement

Given a start date and end date, count months whose first day is a Sunday within the inclusive range. Euler uses 1901-01-01 to 2000-12-31.

## Step-by-step reasoning

1) Day-of-week engine
- Implement Zeller’s congruence (or Doomsday) to compute weekday for any Y-M-D.
- Alternatively, iterate months and track weekday offsets with leap-year rules.

2) Leap years (Gregorian)
- Year divisible by 4 is leap, except if divisible by 100, unless divisible by 400.

3) Iterate months
- For each month in the range, compute weekday of the 1st; if Sunday, increment.

4) Complexity
- O(#months) with congruence; trivial for century spans.

## Reusable template (for similar problems)

Calendar queries over ranges:
- Use a proven congruence to avoid per-day iteration.
- Encapsulate leap-year and month-length logic in helpers.

## Practical examples and business impact

- Scheduling/reporting pipelines
  - Compute month-aligned events and counts reliably.
  - Impact: Correct compliance reports and predictable automation.

- Capacity planning for month-start workloads
  - Anticipate spikes that fall on specific weekdays.
  - Impact: Better staffing and SLA adherence.

## Key takeaways

- Prefer closed-form weekday calculations for speed and correctness.
- Keep leap-year and month-length rules centralized and tested.
