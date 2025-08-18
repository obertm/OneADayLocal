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

## Java implementation (Euler022.java)

We read a CSV of quoted names, normalize, sort, and compute rank-weighted scores.

- Parser: reads file path from `args[0]` or uses `p022_names.txt`; loads content with `Files.readString(Path.of(file))`.
- Cleaning: splits on commas, trims quotes ("name" → name), keeps non-empty entries.
- Scoring: `nameValue(String)` maps A..Z/a..z to 1..26 and sums; `totalScore(List<String>)` sorts and accumulates `(i+1) * nameValue(name)` into a long.
- CLI: prints the total score; prints `DATA_FILE_NOT_FOUND` if the data file is missing (so tests can handle absent datasets).

Classroom notes:
- Using `Collections.sort` keeps the sort stable and simple; letter mapping avoids locale issues.
- Use `long` for the total because the sum can exceed 32-bit range.
