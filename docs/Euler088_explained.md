# Euler088 — Product-sum numbers

For 2 ≤ k ≤ 12000, find minimal product-sum numbers and sum the distinct ones.

## Approach

- DFS over factor combinations: recurse with arguments (startFactor, product, sum, count). For each chosen factor f ≥ startFactor, update: product*=f, sum+=f, count++.
- When product − sum + count yields a k (i.e., product equals sum plus number of ones), if k ≤ 12000, record minimal product for k.
- Prune when product exceeds cap (e.g., best found) or factors exceed bounds.

## Complexity
- Exponential but heavily pruned; feasible with early bounds and shared bests.

## Real-world impact
- Generating minimal representatives of equivalence classes under add/multiply transforms.
