# Euler024 — Lexicographic permutations (k-th)

## Problem statement

Given a set of symbols, find the k-th permutation in lexicographic order. In the Euler problem, the symbols are the digits 0..9 and k = 1,000,000 (1-based).

## Step-by-step reasoning

1) Factoradic representation
- Convert (k-1) to factorial number system (factoradic). These digits are selection indices from the remaining pool at each step.

2) Build the permutation
- Keep a list of available symbols in sorted order. For i from n-1 down to 0:
  - index = factoradic[i]
  - pick and remove the element at that index and append it to the answer.

3) Complexity
- With a simple ArrayList removal, this is O(n^2). With a Fenwick tree/order-statistics tree, it can be O(n log n) or even O(n) with a specialized structure.

## Reusable template (for similar permutation indexing problems)

- Normalize k to zero-based (k-1).
- Precompute factorials up to n.
- Repeatedly divide by decreasing factorials to get selection indices.
- Remove the selected element from a dynamic pool and append.

## Practical examples and business impact

- Random-but-repeatable sharding: deterministically jump to the k-th arrangement without enumerating all permutations.
- Sampling without generation: direct indexing into combinatorial spaces enables fast A/B test bucketing or load balancing.

## Key takeaways

- Factoradic = index-to-permutation bridge. Convert (k-1), then select by indices from a shrinking pool.

## Java implementation (Euler024.java)

This solution converts (k-1) to factoradic indices and removes items from a pool.

- Factorials: `long[] fact` up to n.
- Pool: `ArrayList<Character> pool` initially containing '0'..'9'.
- Loop: for i from n down to 1, compute `idx = n / fact[i-1]`, update `n %= fact[i-1]`, and `sb.append(pool.remove(idx))`.
- CLI: optional argument for k (default 1_000_000).
