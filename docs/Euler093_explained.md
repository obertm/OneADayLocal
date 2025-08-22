# Euler093 — Arithmetic expressions using four digits

Find the set of four distinct digits that can form the longest run of consecutive positive integers starting from 1 using +,−,×,÷ and parentheses.

## Approach

- Enumerate digit permutations, operator triples, and parenthesizations (five binary-tree shapes).
- Evaluate with rationals to avoid FP errors; keep only positive integers.
- Track consecutive run length from 1 for each digit set; keep best.

## Edge Cases
- Floating precision: Using double may misclassify near-integers; prefer rational (fraction) representation for exactness.
- Division by zero: Skip operator arrangements producing zero denominators early.
- Negative/zero results: Only positive integers count; filter strictly.
- Duplicate results: Many expressions yield same value; use a boolean array or bitset to mark reachable integers.
- Parenthesis coverage: Ensure all 5 binary tree shapes considered; omission reduces reachable set.

## Complexity
- Bounded brute force with careful enumeration; manageable.

## Practical examples and business impact
- Expression simplification engines benchmarking.
- Calculator test-case generation across precedence trees.
- Symbolic search: enumerating small expression spaces for coverage.

## Key Takeaways
- Exhaust digits, operators, tree shapes; collect integer results and measure prefix run.

## Java implementation (Euler093.java)
- Iterates all 4-digit ascending sets a<b<c<d from 0..9; for each set:
	- Permutes digit orderings; enumerates 4^3 operator triples (+,−,×,÷); evaluates five parenthesization shapes.
	- Uses Double arithmetic with guard: division returns null on zero; only collects positive near-integers within 1e-9 to an int.
- Tracks the longest consecutive run from 1 via a boolean table; keeps best key as concatenated digits.
- Prints the best 4-digit key.
- Note: Using rationals (fractions) would be fully exact but Double with tolerance suffices here.
