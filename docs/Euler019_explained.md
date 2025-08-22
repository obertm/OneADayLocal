# Euler019 — Counting Sundays

Count how many Sundays fell on the first of the month during a given date range (e.g., 1901-01-01 to 2000-12-31).

## Problem statement

Given a start date and end date, count months whose first day is a Sunday within the inclusive range. Euler uses 1901-01-01 to 2000-12-31.

## Step-by-step reasoning

## Approach

Iterate months from a known weekday seed, apply Gregorian leap rules, and advance weekday by month length; count months whose first day (tracked weekday) is Sunday.

1) Day-of-week engine
- Implement Zeller’s congruence (or Doomsday) to compute weekday for any Y-M-D.
- Alternatively, iterate months and track weekday offsets with leap-year rules.

2) Leap years (Gregorian)
- Year divisible by 4 is leap, except if divisible by 100, unless divisible by 400.

3) Iterate months
- For each month in the range, compute weekday of the 1st; if Sunday, increment.

4) Complexity
- O(#months) with congruence; trivial for century spans.

## Complexity

- Time: O(M) where M is number of months (≈ years*12).
- Space: O(1).
- Optionally replace iteration with per-month weekday formula (same asymptotic, more math operations).

## Edge Cases

- Range boundaries: Ensure start and end months are both included; off-by-one errors can drop January or December.
- Start year before seed (1900): Seeding assumes 1900-01-01; if earlier dates needed, either back-calculate or use a direct weekday formula.
- Leap century rule: Years divisible by 100 are not leap unless divisible by 400 (1900 no, 2000 yes); common bug is treating any year%4==0 as leap.
- Weekday indexing: Maintain consistent 0=Sunday mapping throughout; mixing conventions silently shifts counts.
- Month lengths: February has 29 only in leap years; April, June, September, November are 30 days—mislabeling skews weekday progression.
- Large spans: Multi-millennia ranges still safe in 32-bit counters but switch to long for defensive robustness.

## Reusable template (for similar problems)

Calendar queries over ranges:
- Use a proven congruence to avoid per-day iteration.
- Encapsulate leap-year and month-length logic in helpers.

## Practical examples and business impact

- Scheduling/reporting pipelines
  - Problem: Compute month-aligned events and counts.
  - Model: Month iteration with weekday checks.
  - Impact: Correct compliance reports.

- Capacity planning for month-start workloads
  - Problem: Anticipate weekday-driven spikes.
  - Model: Count first-of-month Sundays/Mondays/etc.
  - Impact: Better staffing.

- Payroll alignment
  - Problem: Predict paydays on specific weekdays.
  - Model: Iterate months with leap rules; pick weekday targets.
  - Impact: Reliable payroll ops.

- Subscription renewals load
  - Problem: Forecast monthly renewals when anchored to weekdays.
  - Model: Month-start weekday distributions.
  - Impact: Smoother billing.

- Event planning calendars
  - Problem: Choose dates that avoid weekend starts.
  - Model: Scan months for weekday conditions.
  - Impact: Higher attendance.

- Batch window scheduling
  - Problem: Avoid batch overlap on bad weekdays.
  - Model: Month-by-month weekday mapping.
  - Impact: Fewer collisions.

- Logistics pickups
  - Problem: Align pickups with depot weekend closures.
  - Model: Count first-of-month weekends.
  - Impact: Fewer failed pickups.

- SLA renewals
  - Problem: Align SLA checkpoints to business days.
  - Model: Weekday checks on month boundaries.
  - Impact: Predictable reviews.

- Education academic calendars
  - Problem: Avoid first-day classes on weekends/holidays.
  - Model: Weekday counting with exceptions.
  - Impact: Better schedules.

- BI reporting cadence health
  - Problem: Ensure report jobs fall on correct weekdays.
  - Model: Month-first weekday audit.
  - Impact: Fewer failed reports.

## Key Takeaways

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
