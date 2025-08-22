# Euler079 — Passcode derivation

Given many successful login attempts as ordered triples of digits, deduce the shortest possible passcode that respects all relative orderings.

## Approach

- Build a DAG of precedence constraints from each triple (a before b, b before c, and a before c implicitly through edges).
- Perform a topological sort (Kahn’s algorithm), choosing the smallest available digit to keep minimality.
- Concatenate the order as the passcode.

## Edge Cases
- Duplicate triples: Should not create duplicate edges or inflate in-degree counts; use sets or guard checks.
- Disconnected digits: Digits with no constraints appear wherever they fit; choose smallest available to uphold minimality.
- Cycles: Bad data could introduce cycles; detect when queue empties before consuming all nodes.
- Leading zero: If zero participates, it can appear first unless constraints block; acceptable per problem domain.
- Multiple minimal choices: Deterministic tie-break (smallest digit) ensures canonical result.

## Complexity
- O(V+E) where V is digits, E is constraints; tiny.

## Practical examples and business impact
- Inferring a minimal sequence consistent with partial orders.
  - Impact: Toposort resolves ordering from noisy constraints.

## Key Takeaways
- Translate triplets to a DAG; topo-sort to obtain the minimal consistent passcode.


## Java implementation (Euler079.java)

- Class: `Euler079`
- Loads triplets from `Euler079.txt` if present, otherwise uses the standard sample set embedded.
- Builds precedence edges for digits and performs Kahn’s topological sort, always choosing the smallest-available digit to ensure the minimal passcode.
- Output: The shortest passcode string that satisfies all order constraints.
