# Euler039 — Integer right triangles

For perimeters p ≤ P, find p with the most integer right-triangle solutions.

## Approach

- Use Euclid’s formula: primitive triples from m>n, coprime, not both odd: a=k(m^2-n^2), b=k(2mn), c=k(m^2+n^2).
- For each primitive perimeter p0=2m(m+n) ≤ P, increment counts for multiples k·p0.
- Track p with max count.

## Edge Cases

- P below smallest perimeter (12): No solutions; result should be 0 or none; define contract.
- Duplicate triples: Counting multiples of primitive triples ensures uniqueness; naive a<b<c loops must avoid duplicate (a,b,c) ordering.
- Overflow: For large P, m^2 + n^2 may exceed int; use long in calculations.
- Coprime check: Ensure gcd(m,n)=1 and not both odd; skipping either inflates counts with non-primitive duplicates.
- Performance: Brute-force a,b,c O(P^2) slow for big P; Euclid’s formula vital above ~10^4.
- Tie handling: If multiple perimeters share max count, decide whether to return smallest; Euler instance unique.

## Complexity
- O(P log P)ish; iterating m up to √(P/2).

## Practical examples and business impact

- RF engineering: enumerate waveguide/cavity dimensions (integer relations) by parameterization to hit perimeter/length budgets.
- Construction planning: count rectangular right-triangle truss options for a given perimeter; compare bill-of-materials scenarios.
- Computer graphics: generate integer right triangles for grid-aligned meshes; choose perimeters with many options to maximize reuse.
- Educational geometry: teach Euclid’s triple parameterization to avoid a^2+b^2=c^2 brute-force scans.
- Robotics pathing: analyze grid-constrained path triangles for calibration; perimeters with many solutions yield more samples.
- PCB/mechanical layout: fit right-angled components with fixed perimeters in integer grid designs.
- Sports analytics: design field/court drill distances matching perimeter constraints with multiple triple options.
- Cryptarithm puzzles: simulate integer solutions to constrained forms using parameterized families rather than brute force.
- Simulation design: choose perimeters with rich solution sets to sample diverse triangle shapes under fixed budgets.
- Operations research: demonstrate how parameterization collapses search spaces in combinatorial geometry problems.

## Key Takeaways
- Generate perimeters from Euclid’s formula and count multiples; pick the max.


## Java implementation (Euler039.java)

- Class: `Euler039`
- Implementation shown here uses a straightforward perimeter scan and counts integer triples by iterating `a < b < c` with `a + b + c = p` and testing `a*a + b*b == c*c`.
- For each p up to the limit (default 1000; you can pass another), count such triples and keep the p with the maximum count. Print that p.
- Note: A faster alternative is to use Euclid’s formula to generate perimeters and count multiples, but the direct enumeration is simple and fast enough for P ≤ 1000.
