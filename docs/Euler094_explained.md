# Euler094 — Almost equilateral triangles

Find perimeters < 1e9 of integer-sided triangles with sides (a,a,a±1) having integer area; sum perimeters.

## Insight & method

- Heron reduces to checking whether (3a±1)(a±1) forms a square inside; leads to Pell-type recurrences.
- Use known recurrence for solutions: starting from minimal (a), iterate via matrix/Pell transform to generate next valid almost-equilateral triangles; accumulate perimeters until limit.

## Complexity
- O(#solutions) with fast recurrences; very few terms.

## Real-world impact
- Diophantine constraints solved by Pell recurrences; efficient generation of rare structures.

## Java implementation (Euler094.java)
- Currently marked TODO in code. The intended approach:
	- Use Pell-type recurrences to generate valid (a,a,a±1) with integer area.
	- For each generated a, add perimeter `3a±1` if ≤ 1e9; sum until exceeding limit.
- We can implement this next to complete the solution.
