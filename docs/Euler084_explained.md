# Euler084 — Monopoly odds

Compute the modal string (concatenation of the three most probable squares) of a Monopoly board with 2d6 dice and rules for Chance/Community Chest.

## Approach

- Build a 40×40 transition matrix covering dice sums, doubles to jail, Go To Jail, and Chance/CC card effects.
- Compute the stationary distribution by repeated multiplication (power method) or direct eigenvector on a stochastic matrix.
- Sort probabilities, take top three indices, and concatenate as a 6-digit code.

## Complexity
- O(40^3) to build once; convergence in O(k·40^2) multiplications.

## Real-world impact
- Markov chain steady-state analysis for board games or stateful processes.

## Java implementation (Euler084.java)
- Models state as `(position 0..39, doublesStreak 0..2)` yielding 120 states; builds a 120×120 transition matrix T.
- Enumerates all D×D dice outcomes (with D=4 sides in this version), handling:
	- Three consecutive doubles → Jail.
	- Go To Jail square.
	- Community Chest (16 cards: GO, JAIL, or stay) and Chance (GO, JAIL, C1, E3, H2, R1, next R×2, next U, back 3 with one-level follow-up).
- Uses power iteration (~200 steps) to approximate the stationary distribution, then aggregates probabilities across doubles-streak to get per-square mass.
- Sorts squares by probability and prints the top three indices as a 6-digit string.
- Notes: This implementation uses 4-sided dice per the problem variant; adjust D to 6 for standard 2d6.
