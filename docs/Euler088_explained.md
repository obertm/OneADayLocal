# Euler088 — Product-sum numbers

For 2 ≤ k ≤ 12000, find minimal product-sum numbers and sum the distinct ones.

## Approach

- DFS over factor combinations: recurse with arguments (startFactor, product, sum, count). For each chosen factor f ≥ startFactor, update: product*=f, sum+=f, count++.
- When product − sum + count yields a k (i.e., product equals sum plus number of ones), if k ≤ 12000, record minimal product for k.
- Prune when product exceeds cap (e.g., best found) or factors exceed bounds.

## Edge Cases
- k computation: k = count + (product − sum); ensure product ≥ sum to avoid negative/invalid k.
- Pruning limit: Choose upper bound (2K) carefully; too low risks missing minima; too high wastes time.
- Factor ordering: Enforce non-decreasing factors to avoid permutations; startFactor parameter ensures that.
- Duplicate minimal products: Keep only smallest per k; ignore larger repeats.
- Stack depth: Recursive depth small (factor count), but tail recursion safe; ensure termination conditions robust.

## Complexity
- Exponential but heavily pruned; feasible with early bounds and shared bests.

## Practical examples and business impact
- Factor-based cost models: minimal product for additive decomposition patterns.
- Optimization: canonical minimal representative enumeration for equivalence classes.
- Compression modeling: exploring multiplicative vs additive tradeoffs.

## Key Takeaways
- DFS over non-decreasing factors; use k = len + (prod - sum) identity; prune aggressively.

## Java implementation (Euler088.java)
- Optional CLI K (default 12,000). Sets `limit = 2*K` as an upper bound for minimal product-sum values.
- DFS over non-decreasing factors f ≥ start with state `(start, prod, sum, len)`:
	- Computes k = len + (prod − sum) which is the number of ones needed to turn the multiset into a product-sum equality.
	- If 2 ≤ k ≤ K, records `minN[k] = min(minN[k], prod)`.
	- Prunes when `prod > limit` or k > K.
- After DFS, inserts all `minN[2..K]` into a `HashSet` and sums distinct values; prints the sum.
- Efficient due to strong pruning and the modest cap.
