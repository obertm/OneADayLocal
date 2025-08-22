# Euler099 — Largest exponential

Given many pairs (a,b), find the line with the largest value of a^b.

## Technique

- Compare by b·ln(a). Track the max value and its line index.
- Avoid floating instability by double precision; inputs fit well; or use long double/BigDecimal if needed.

## Edge Cases
- Floating precision: For very close comparisons, doubles may tie; compare with tolerance or use higher precision.
- Zero/negative bases: Input spec uses positive integers; no handling needed; if extended, domain restrictions change formula.
- Overflow avoidance: Do not compute a^b directly; log-space comparison essential.
- Line indexing: Maintain 1-based indexing per problem statement; off-by-one easy here.
- Parsing errors: Skip malformed lines gracefully.

## Complexity
- O(N) with one log per line.

## Practical examples and business impact
- Big-number ranking: log-space comparison for scale ordering.
- Data science: feature weighting by exponent magnitude proxies.
- Performance: avoid overflow by comparing in log domain.

## Key Takeaways
- Compare b·ln(a) values to rank a^b without large arithmetic.

## Java implementation (Euler099.java)
- Loads `p099_base_exp.txt` (base,exponent per line), or prints `DATA_FILE_NOT_FOUND` if not found.
- Scans lines computing `b*ln(a)` and keeps the line number (1-based) with the maximum value.
- Prints the winning line index.
