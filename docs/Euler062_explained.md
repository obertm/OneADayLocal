# Euler062 — Cubic permutations

Find the smallest cube for which exactly five permutations of its digits are also cubes.

## Approach

- Iterate n, compute c=n^3, get a key by sorting the digits of c (e.g., as a string).
- Use a map key→(count, smallest n producing this key). When count hits 5, record and stop when you reach the first such key’s smallest cube.
- Increase n until found; bounding by digit-length helps (reset map when digit-length grows if desired).

## Complexity
- O(K) cubes with digit-sort per cube; practical.

## Real-world analogues and impact
- Bucketing by canonicalized signature to detect permutation-equivalent values.
  - Impact: Efficient detection of equivalence classes via stable keys.

## Takeaways
- Hash cubes by sorted-digit signature; find the first key reaching count=5 and take its smallest cube.
