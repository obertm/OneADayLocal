# Euler075 — Singular integer right triangles

For perimeters P ≤ 1,500,000, count how many P can be formed in exactly one way as a+b+c=P with integer right triangles.

## Plan

- Generate primitive triples via Euclid: a=m^2−n^2, b=2mn, c=m^2+n^2 with m>n, coprime, not both odd.
- For each primitive perimeter p0=2m(m+n), increment counts for all multiples k·p0 ≤ P.
- Answer is count of P with occurrences==1.

## Complexity
- ~O(P log P) with small constants; very fast.

## Real-world analogues and impact
- Counting unique representations via structured generators and multiple coverage.
  - Impact: Accurate uniqueness detection without brute forcing a,b,c.

## Takeaways
- Generate perimeters from primitive triples; mark multiples; count those with exactly one representation.
