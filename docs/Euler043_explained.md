# Euler043 — Sub-string divisibility

Sum all 0–9 pandigital numbers with specific 3-digit substring divisibility properties.

## Constraint-driven build

- Build numbers right-to-left or left-to-right, maintaining modulo constraints for divisors {2,3,5,7,11,13,17}.
- Enforce early: e.g., digits d4d5d6 divisible by 5 ⇒ d6 ∈ {0,5}, etc.
- Use DFS with visited-digit bitmask; when length is 10 and all constraints pass, add to total.

## Complexity
- Small search due to tight constraints; completes quickly.

## Real-world analogues and impact
- Constraint propagation in combinatorial enumeration.
  - Impact: Explodes much less than naïve permutation generation.

## Takeaways
- Encode divisibility checks as early pruning; accumulate as soon as all constraints satisfied.
