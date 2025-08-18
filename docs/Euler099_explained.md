# Euler099 — Largest exponential

Given many pairs (a,b), find the line with the largest value of a^b.

## Technique

- Compare by b·ln(a). Track the max value and its line index.
- Avoid floating instability by double precision; inputs fit well; or use long double/BigDecimal if needed.

## Complexity
- O(N) with one log per line.

## Real-world impact
- Ranking exponential magnitudes without computing huge numbers.
