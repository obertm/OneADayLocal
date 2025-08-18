# Euler093 — Arithmetic expressions using four digits

Find the set of four distinct digits that can form the longest run of consecutive positive integers starting from 1 using +,−,×,÷ and parentheses.

## Approach

- Enumerate digit permutations, operator triples, and parenthesizations (five binary-tree shapes).
- Evaluate with rationals to avoid FP errors; keep only positive integers.
- Track consecutive run length from 1 for each digit set; keep best.

## Complexity
- Bounded brute force with careful enumeration; manageable.

## Real-world impact
- Expression search under exact arithmetic and precedence variants.

## Java implementation (Euler093.java)
- Iterates all 4-digit ascending sets a<b<c<d from 0..9; for each set:
	- Permutes digit orderings; enumerates 4^3 operator triples (+,−,×,÷); evaluates five parenthesization shapes.
	- Uses Double arithmetic with guard: division returns null on zero; only collects positive near-integers within 1e-9 to an int.
- Tracks the longest consecutive run from 1 via a boolean table; keeps best key as concatenated digits.
- Prints the best 4-digit key.
- Note: Using rationals (fractions) would be fully exact but Double with tolerance suffices here.
