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

## Java implementation (Euler019.java)

We iterate months and track weekday offsets with Gregorian leap-year rules.

- Leap helper: `isLeap(int year)` implements the Gregorian rule: divisible by 4, except centuries unless divisible by 400.
- Month length: `daysInMonth(int year, int month)` returns 28/29/30/31 based on the month and leap year.
- Core: `countSundaysOnFirst(int startYear, int endYear)`
  - Track day-of-week (dow) with 0=Sunday .. 6=Saturday.
  - Seed `dow = 1` because 1900-01-01 was a Monday.
  - Loop year=1900..endYear and month=1..12:
    - If year within [startYear, endYear] and `dow == 0`, increment count.
    - Advance `dow = (dow + daysInMonth(year, month)) % 7`.
  - Return the count.
- CLI: `main(String[] args)` defaults to 1901..2000; two optional args override start and end; prints the total Sundays on the first of a month.

Classroom notes:
- Seeding from 1900-01-01 avoids having to compute an absolute epoch; we “walk” forward month by month.
- The `% 7` accumulation is a simple, bug-resistant way to track weekdays without a full calendar library.
- Alternative: Use Zeller’s congruence to compute each month’s weekday directly; iteration is clearer for teaching.
