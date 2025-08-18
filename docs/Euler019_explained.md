# Euler019 — Counting Sundays

Count how many Sundays fell on the first of the month during a given date range (e.g., 1901-01-01 to 2000-12-31).

## Approach

1) Day-of-week engine
- Either implement Zeller’s congruence or iterate dates using a day counter.
- Handle leap years: year divisible by 4, except centuries not divisible by 400.

2) Count condition
- For each month in the range, compute the day-of-week of the 1st; if Sunday, increment.

3) Complexity
- O(number of months) with congruence; O(number of days) if naive (still OK for a century).

## Real-world analogues and impact
- Calendar logic for scheduling/reporting systems.
  - Impact: Correctness in compliance and planning tools.

## Takeaways
- Use proven congruences or library functions where allowed; watch leap-year rules.
