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
