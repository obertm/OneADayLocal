# Euler045 — Triangular, pentagonal, hexagonal

Find the next number that is triangular, pentagonal, and hexagonal after 40755.

## Approach

- Hexagonal numbers H(n)=n(2n−1) are a subset of triangular; iterate n>143 and generate H(n).
- Test pentagonality for H(n) via inverse check: x=(1+√(1+24H))/6 integer.
- First match after 40755 is the answer.

## Complexity
- O(k) iterations until the next match; constant-time membership test.

## Practical examples and business impact

- Rare-event filtering: generate rare candidates and test membership in broader conditions to find intersections.
- Time-series synthesis: intersect monotone pattern streams (e.g., peaks with specific figurate-time positions).
- Multi-index joins: iterate the smallest index and test membership in others to accelerate joins.
- Simulation design: rare-sequence generation guarantees minimal work to find overlaps of constraints.
- Education: teach sequence intersections via generating the rarest and testing others by inverse formulas.
- Search optimization: show that generating common sequences first is wasteful vs. rare-first strategies.
- Embedded/perf: membership tests by inverse math instead of lookups to save memory.
- Data validation: ensure values meet multiple structural constraints cheaply.
- Analytics: exploring intersections of precomputed feature families with O(1) checks.
- Cryptanalysis toys: seek numbers with multiple structural properties as didactic exercises.

## Takeaways
- Generate hexagonals; test pentagonality; triangularity is implicit.


## Java implementation (Euler045.java)

- Class: `Euler045`
- Helpers: triangular, pentagonal, and hexagonal inverse checks; triangularity is constructed; pent/hex checked via inverse formulas.
- Loop: from n=286 upward, compute T(n); if both pentagonal and hexagonal, print T(n) and exit.
