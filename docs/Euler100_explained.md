# Euler100 — Arranged probability

Find the number of blue discs with total discs > 10^12 such that the probability of two blue discs drawn without replacement is exactly 1/2.

## Math and method

- Equation: B/T × (B−1)/(T−1) = 1/2 simplifies to Pell-type Diophantine equations.
- Use known recurrences to generate (B,T) solutions: starting from small solution, iterate linear transforms until T > 10^12; return B.

## Edge Cases
- Starting pair: Must begin with correct minimal solution (B,N)=(15,21); earlier trivial (1,1) disregarded due to T>10^12 requirement.
- Overflow: B,T exceed 64-bit before threshold loops? For 10^12 limit they fit in 64-bit; still use BigInteger for safety/generalization.
- Recurrence correctness: A sign error produces non-solutions; validate first few terms against known sequence.
- Termination: Strictly T > 10^12; not ≥. Ensure loop condition matches spec.
- Performance: Very few iterations; avoid unnecessary heavy math libraries beyond BigInteger ops.

## Complexity
- O(#solutions) iterations; very small count.

## Practical examples and business impact
- Quality control: probability constraints mapped to Diophantine solutions.
- Risk modeling: discrete counts matching target compound probabilities.
- Education: Pell equations bridging combinatorics and number theory.

## Key Takeaways
- Use Pell-derived linear recurrences to jump directly between valid (B,T) states.

## Java implementation (Euler100.java)
- Uses the standard linear recurrence on (B,N) derived from 2·B(B−1) = N(N−1):
	- Start (B,N) = (15,21), then iterate:
		- B' = 3B + 2N − 2
		- N' = 4B + 3N − 3
- Loop until N > 10^12, then print B. Implemented with BigInteger throughout.
