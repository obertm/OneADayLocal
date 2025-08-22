# Euler073 — Counting fractions in a range (1/3, 1/2)

Count reduced proper fractions a/b with 1/3 < a/b < 1/2 and b ≤ 12000.

## Approach

- For each denominator d, enumerate numerators n in (d/3, d/2):
  - n_min = floor(d/3) + 1
  - n_max = ceil(d/2) − 1
  - Count n with gcd(n,d)=1.
- Equivalent Farey sequence traversal also works; the per-d bounds are simple and fast.

## Edge Cases
- Boundary fractions: Exclude exactly 1/3 and 1/2; careful with integer rounding to avoid inclusion.
- GCD optimization: Precomputed smallest prime factor array could speed counts; unnecessary at N=12000.
- Overflow: Multiplying for cross-comparisons stays in 32-bit; safe.
- Performance: Two-sided sweeping via Farey neighbors avoids gcd calls altogether; ensure chosen method consistent.
- Duplicate counting: Each fraction generated once per denominator; no double counting risk.

## Complexity
- Roughly O(N log N) from gcd checks; fine for 12000.

## Real-world analogues and impact
- Counting admissible ratios in a bounded range.
  - Impact: Direct bounds avoid generating all fractions.

## Key Takeaways
- Tight bounds per denominator and a gcd test per candidate.


## Java implementation (Euler073.java)

- Class: `Euler073`
- Uses Farey sequence stepping between neighbors to count fractions strictly between 1/3 and 1/2 for denominators ≤ 12000 without gcd loops.
- Maintains neighbors (a/b, c/d) and repeatedly computes the next mediant step until reaching 1/2; increments a counter per step.
- Output: Print the count.
