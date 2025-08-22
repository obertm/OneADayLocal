# Euler096 — Su Doku

Solve multiple 9×9 Sudoku puzzles and sum the 3-digit numbers formed by the top-left 3 cells of each solved grid.

## Solver

- Use constraint propagation (eliminate, only-choice) and backtracking with MRV (fewest candidates first).
- Represent candidates as bitmasks; fast row/col/box checks.
- For each puzzle, solve and extract the required 3 digits as a number.

## Edge Cases
- Multiple solutions: Puzzles expected to have unique solutions; solver should stop after first complete grid.
- Invalid puzzle: Contradictions after propagation; handle gracefully returning failure.
- Bitmask updates: Ensure clearing/setting candidates consistent; stale masks cause missing candidates.
- Backtracking order: MRV essential to limit depth; without it performance degrades.
- Input format: Lines prefixed with GRID plus 9-digit lines; whitespace or malformed lines should be skipped or validated.

## Complexity
- Very fast for standard instances; exponential worst-case but fine here.

## Practical examples and business impact
- Constraint solvers: MRV + propagation baseline.
- QA: Sudoku as regression corpus for solver correctness.
- Education: demonstrate bitmask candidate management.

## Key Takeaways
- Combine elimination, only-choice, then MRV backtracking for fast solves.

## Java implementation (Euler096.java)
- Tries to load `p096_sudoku.txt` (Grid headers + 9 lines each). If missing, prints `DATA_FILE_NOT_FOUND`.
- Parses puzzles, then solves each using a bitmask-based MRV backtracking:
	- Tracks used digits per row/col/box in 10-bit masks.
	- Picks the cell with fewest candidates and tries them; backtracks on conflict.
- Sums the 3-digit value from the top-left corner of each solved grid and prints the sum.
