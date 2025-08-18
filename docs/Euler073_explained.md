# Euler073 — Counting fractions in a range (1/3, 1/2)

Count reduced proper fractions a/b with 1/3 < a/b < 1/2 and b ≤ 12000.

## Approach

- For each denominator d, enumerate numerators n in (d/3, d/2):
  - n_min = floor(d/3) + 1
  - n_max = ceil(d/2) − 1
  - Count n with gcd(n,d)=1.
- Equivalent Farey sequence traversal also works; the per-d bounds are simple and fast.

## Complexity
- Roughly O(N log N) from gcd checks; fine for 12000.

## Real-world analogues and impact
- Counting admissible ratios in a bounded range.
  - Impact: Direct bounds avoid generating all fractions.

## Takeaways
- Tight bounds per denominator and a gcd test per candidate.
