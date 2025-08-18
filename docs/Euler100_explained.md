# Euler100 — Arranged probability

Find the number of blue discs with total discs > 10^12 such that the probability of two blue discs drawn without replacement is exactly 1/2.

## Math and method

- Equation: B/T × (B−1)/(T−1) = 1/2 simplifies to Pell-type Diophantine equations.
- Use known recurrences to generate (B,T) solutions: starting from small solution, iterate linear transforms until T > 10^12; return B.

## Complexity
- O(#solutions) iterations; very small count.

## Real-world impact
- Solving probability constraints via Pell recurrences; efficient large-number solutions.

## Java implementation (Euler100.java)
- Uses the standard linear recurrence on (B,N) derived from 2·B(B−1) = N(N−1):
	- Start (B,N) = (15,21), then iterate:
		- B' = 3B + 2N − 2
		- N' = 4B + 3N − 3
- Loop until N > 10^12, then print B. Implemented with BigInteger throughout.
