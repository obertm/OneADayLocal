# Euler062 — Cubic permutations

Find the smallest cube for which exactly five permutations of its digits are also cubes.

## Approach

- Iterate n, compute c=n^3, get a key by sorting the digits of c (e.g., as a string).
- Use a map key→(count, smallest n producing this key). When count hits 5, record and stop when you reach the first such key’s smallest cube.
- Increase n until found; bounding by digit-length helps (reset map when digit-length grows if desired).

## Edge Cases
- Leading zeros: Sorting digits preserves zeros; permutation equality includes identical zero counts; fine.
- Map growth: Many keys with low counts accumulate; optionally purge when digit length increases to save memory.
- Early termination: Must ensure no earlier digit-length key reaches 5 after moving to longer cubes; safe since counts for shorter lengths finalized.
- Integer overflow: n^3 can exceed 32-bit; use long for cube computation.
- Signature collisions: True permutations only; sorting digits yields canonical signature; no hash collision risk if using the string directly.

## Complexity
- O(K) cubes with digit-sort per cube; practical.

## Practical examples and business impact
- Bucketing by canonicalized signature to detect permutation-equivalent values.
  - Impact: Efficient detection of equivalence classes via stable keys.

## Key Takeaways
- Hash cubes by sorted-digit signature; find the first key reaching count=5 and take its smallest cube.


## Java implementation (Euler062.java)

- Class: `Euler062`
- Map: `signature(cube)` → list of cubes; signature is the sorted digits of the cube.
- Iterate n from 1 up; when a list reaches size 5, return its minimum as the answer.
- Output: Print the smallest cube among the five permutations.
