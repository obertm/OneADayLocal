# Euler096 — Su Doku

Solve multiple 9×9 Sudoku puzzles and sum the 3-digit numbers formed by the top-left 3 cells of each solved grid.

## Solver

- Use constraint propagation (eliminate, only-choice) and backtracking with MRV (fewest candidates first).
- Represent candidates as bitmasks; fast row/col/box checks.
- For each puzzle, solve and extract the required 3 digits as a number.

## Complexity
- Very fast for standard instances; exponential worst-case but fine here.

## Real-world impact
- General CSP solving with propagation + heuristic backtracking.
