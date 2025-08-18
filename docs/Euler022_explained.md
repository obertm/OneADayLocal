# Euler022 — Names scores

Given a list of names, sort them alphabetically. For each name, compute alphabetical value (A=1..Z=26) and multiply by its 1-based position; sum all scores.

## Problem statement

Given a file/list of uppercase names, sort alphabetically. For name at 1-based index i, compute score(name) = i × sum(letterValue), where A=1..Z=26. Return the total of scores.

## Step-by-step reasoning

1) Parse and clean
- Read CSV or quoted names; strip quotes; normalize to uppercase.

2) Sort
- Standard lexicographic sort.

3) Score
- For each name: value = sum(ch - 'A' + 1); score = value × position; accumulate in long.

4) Complexity
- Sorting dominates: O(N log N); scoring O(total characters).

5) Edge cases
- Empty names; stray quotes/commas → sanitize.

## Reusable template (for similar problems)

Rank-weighted scoring pipelines:
- Clean → sort → compute base value → multiply by rank → sum.

## Practical examples and business impact

- Leaderboards and reports with position-based scaling
  - Base scores scaled by rank for display or payouts.
  - Impact: Deterministic, explainable scoring for stakeholders.

- ETL normalization of identifiers
  - Map characters to numeric values to build reproducible metrics.
  - Impact: Traceable transformations for audits.

## Key takeaways

- Keep parsing strict; separate sort from scoring for clarity and testability.
- Use long for totals to avoid overflow.
