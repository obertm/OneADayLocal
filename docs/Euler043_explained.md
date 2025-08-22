# Euler043 — Sub-string divisibility

Sum all 0–9 pandigital numbers with specific 3-digit substring divisibility properties.

## Approach

- Build numbers right-to-left or left-to-right, maintaining modulo constraints for divisors {2,3,5,7,11,13,17}.
- Enforce early: e.g., digits d4d5d6 divisible by 5 ⇒ d6 ∈ {0,5}, etc.
- Use DFS with visited-digit bitmask; when length is 10 and all constraints pass, add to total.

## Edge Cases

- Leading zero: Original problem allows 0–9 pandigital including leading zero; ensure inclusion/exclusion aligns with spec; leading zero numbers still count here.
- Constraint enforcement order: Early pruning essential; applying divisibility checks late causes factorial blow-up.
- Duplicate digits: Must reject; track used digits bitmask to ensure uniqueness.
- Overflow: Sum of all such pandigital numbers fits in 64-bit; using long is safe.
- Performance: Naive permutation of 10! variants expensive; constraint-guided DFS reduces drastically.
- Mod arithmetic errors: Ensure extraction of each 3-digit substring correct (index alignment off-by-one common).
- Memory: Recursion depth 10; safe for stack; iterative backtracking optional.

## Complexity
- Small search due to tight constraints; completes quickly.

## Practical examples and business impact

- Constraint programming: teach how local divisibility constraints prune global permutations.
- Scheduling: build timetables with local constraints (mod-like) and propagate during DFS.
- Network design: assign IP octets/fields satisfying divisibility-like constraints; prune early.
- Test data synthesis: generate pandigital-like records that meet substring rules to stress validators.
- Rule engines: model forward-checking to reject partial assignments early.
- Cryptanalysis toys: substring divisibility as a stand-in for modular constraints in key schedules.
- Config combinatorics: enforce field-alignment divisibility constraints during enumeration.
- Performance demos: compare 10! permutations vs. constraint-guided DFS on the same task.
- Education: visualize constraint propagation with substring windows as local checks.
- Monte Carlo with constraints: sample only from feasible subspace using incremental checks.

## Key Takeaways
- Encode divisibility checks as early pruning; accumulate as soon as all constraints satisfied.


## Java implementation (Euler043.java)

- Class: `Euler043`
- Globals: `sum` accumulator; `PR = {2,3,5,7,11,13,17}` for substring divisors.
- Method: `perm(char[] arr, int l, int r)` generates all 0–9 pandigital permutations; at leaves, checks each 3-digit substring divisibility and, if valid, adds the numeric value to `sum`.
- Note: The code avoids leading-zero results explicitly; the final sum is printed.
- Optimization opportunity: A DFS that enforces constraints during construction would avoid generating all 10! permutations; current version is acceptable for one-off runs.
