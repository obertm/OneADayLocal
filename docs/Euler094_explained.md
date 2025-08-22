# Euler094 — Almost equilateral triangles

Find perimeters < 1e9 of integer-sided triangles with sides (a,a,a±1) having integer area; sum perimeters.

## Insight & method

- Heron reduces to checking whether (3a±1)(a±1) forms a square inside; leads to Pell-type recurrences.
- Use known recurrence for solutions: starting from minimal (a), iterate via matrix/Pell transform to generate next valid almost-equilateral triangles; accumulate perimeters until limit.

## Edge Cases
- Both variants: Need to check (a,a,a+1) and (a,a,a−1) families; ensure recurrence generates both or handle separately.
- Area integrality: Floating Heron may introduce rounding; prefer algebraic Pell derivation to guarantee integer area.
- Perimeter overflow: Use 64-bit when summing up to <1e9 thresholds; safe but guard for generalization.
- Starting seeds: Incorrect initial (a) pair leads to missing solutions; verify first few manually.
- Duplicate generation: Ensure recurrence doesn’t emit same a twice; track last to detect anomalies.

## Complexity
- O(#solutions) with fast recurrences; very few terms.

## Practical examples and business impact
- Structural engineering: near-equilateral designs satisfying integral measures.
- Cryptarithm puzzles: Pell-based generation of constrained triples.
- Math education: showcase Pell recurrences generating sparse solution sets.

## Key Takeaways
- Transform to Pell; iterate recurrence to enumerate sparse valid perimeters.

## Java implementation (Euler094.java)
- Currently marked TODO in code. The intended approach:
	- Use Pell-type recurrences to generate valid (a,a,a±1) with integer area.
	- For each generated a, add perimeter `3a±1` if ≤ 1e9; sum until exceeding limit.
- We can implement this next to complete the solution.
