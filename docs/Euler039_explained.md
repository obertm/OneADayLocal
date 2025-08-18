# Euler039 — Integer right triangles

For perimeters p ≤ P, find p with the most integer right-triangle solutions.

## Approach

- Use Euclid’s formula: primitive triples from m>n, coprime, not both odd: a=k(m^2-n^2), b=k(2mn), c=k(m^2+n^2).
- For each primitive perimeter p0=2m(m+n) ≤ P, increment counts for multiples k·p0.
- Track p with max count.

## Complexity
- O(P log P)ish; iterating m up to √(P/2).

## Real-world analogues and impact
- Enumerating structured solutions via parameterization (avoids brute-force over a,b,c).
  - Impact: Orders-of-magnitude faster counts for constrained geometries.

## Takeaways
- Generate perimeters from Euclid’s formula and count multiples; pick the max.
