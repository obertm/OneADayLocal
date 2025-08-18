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
