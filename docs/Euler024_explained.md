# Euler024 — Lexicographic permutations (k-th)

Find the k-th lexicographic permutation of a multiset (in Euler: digits 0..9, k=1,000,000 1-based).

## Factoradic approach

1) Factoradics
- Represent (k-1) in factorial number system to get selection indices.

2) Build permutation
- Maintain a list of symbols; for i from n-1..0: pick and remove index = factoradic[i].

3) Complexity
- O(n^2) due to list removals; O(n) with a Fenwick tree or order-statistics tree.

## Real-world analogues and impact
- Direct index access into permutations (sharding seeds, sampling without generating all).
  - Impact: Constant-time access pattern per digit enables large-space navigation.

## Takeaways
- Convert (k-1) to factoradic; select indices to build the exact permutation deterministically.
