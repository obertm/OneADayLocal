# Euler090 — Cube digit pairs

Count the distinct ways to place digits on two cubes so that they can display all square numbers below 100: 01, 04, 09, 16, 25, 36, 49, 64, 81.

## Problem statement

- You have two cubes; each face shows a digit 0–9. A cube can’t repeat a digit (6 faces → 6 distinct digits per cube).
- When placing the cubes side by side, they must be able to display each of the two-digit squares below 100.
- Digits 6 and 9 are interchangeable: if a cube contains 6, it can display 9 and vice versa (due to rotation).
- Count unordered pairs of digit-sets (A, B) (i.e., (A, B) and (B, A) are the same).

## Step-by-step reasoning

1) Inputs/outputs
- Input: none (fixed set of squares and digits 0..9).
- Output: count of unordered pairs.

2) Represent cube faces as sets
- Choose 6 digits for cube A and 6 for cube B from {0..9}. Use bitmasks of size 10 for fast checks.
- Augment each set to include both 6 and 9 if either is present (interchangeability rule).

3) Validate coverage of required pairs
- Required pairs: (0,1), (0,4), (0,9), (1,6), (2,5), (3,6), (4,9), (6,4), (8,1). After augmentation, 6/9 substitution is automatic.
- For each pair (x, y): valid if (x in A and y in B) OR (x in B and y in A).

4) Count unordered pairs
- Iterate A over all C(10,6) choices; iterate B from A to end to avoid double counting.
- For each (A, B) meeting all requirements, increment count.

5) Complexity
- About C(10,6) ≈ 210 choices per cube; unordered pairs ~ 210×211/2 ≈ 22k → trivial.

6) Edge cases and correctness
- Ensure augmentation only once per set: if set has 6 or 9, include both.
- Remember leading zero is allowed in two-digit displays (01, 04, 09).
- Use unordered counting to avoid doubling.

7) Testing mindset
- Quick invariants: If a set lacks both 6 and 9 entirely, it can still be valid as long as the counterpart cube covers both; augmentation handles this correctly.
- Spot-check a few known valid pairs; total count should match Euler’s known answer (121).

## Reusable template (for similar problems)

When checking pairwise coverage with interchangeable symbols:
- Model items as bitsets, add equivalence-closure (augment interchangeable elements).
- Validate each required pair with symmetric placement.
- Count unordered combinations to avoid duplicates.

## Practical examples and business impact

- AB testing with interchangeable features
  - Some features are functionally equivalent (6/9). Close under equivalence first, then evaluate coverage.
  - Impact: Correctly counts designs without over- or under-estimating due to symmetry.

- UI component libraries with mirrored glyphs
  - Determine whether two sets of icons can render a required set of badges where some glyphs are rotationally equivalent.
  - Impact: Guarantees complete coverage with minimal asset duplication.

- Compliance checks with symmetric roles
  - Verify that two departments’ controls jointly cover a control matrix with equivalences (either side can satisfy a control).
  - Impact: Avoids redundant controls while ensuring coverage.

## Key takeaways

- Normalize interchangeable elements (6↔9) before checks.
- Use bitsets for fast membership and compact iteration.
- Treat pairs as unordered to avoid double counting.

## Java implementation (Euler090.java)
- Generates all 6-digit subsets of {0..9} as bitmasks; iterates unordered pairs (i..j) to avoid double counting.
- Required pairs are hard-coded; membership test `has(mask,d)` treats 6 and 9 as interchangeable by checking either bit.
- `canDisplayAll(a,b)` validates each square: (x in a & y in b) OR (x in b & y in a).
- Prints the count of valid unordered pairs.
