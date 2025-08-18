# Euler022 — Names scores

Given a list of names, sort them alphabetically. For each name, compute alphabetical value (A=1..Z=26) and multiply by its 1-based position; sum all scores.

## Reproducible steps

1) Parse and clean
- Read CSV or quoted names; strip quotes.

2) Sort
- Standard lexicographic sort.

3) Score
- For each name: value = sum(ch-'A'+1); score = value * position; accumulate.

## Complexity
- Sorting dominates: O(N log N); scoring O(total characters).

## Real-world analogues and impact
- Ranking pipelines where a base score is scaled by rank/position.
  - Impact: Deterministic, explainable scoring for reports and leaderboards.

## Takeaways
- Keep parsing strict; separate sort from scoring for clarity and tests.
