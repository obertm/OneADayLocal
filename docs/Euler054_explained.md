# Euler054 — Poker hands

Given many poker deals, count how many hands Player 1 wins.

## Evaluator outline

- Map cards to ranks (2..A) and suits; compute hand rank tuple: (category, primary ranks...). Categories: High card, Pair, Two pairs, Three of a kind, Straight, Flush, Full house, Four, Straight flush, Royal flush.
- Compare tuples lexicographically for two hands.
- Parse the dataset, evaluate both hands per line, increment wins for Player 1 when tuple1 > tuple2.

## Complexity
- O(#hands) with constant-time per-hand evaluation.

## Real-world analogues and impact
- Deterministic ranking engines (tournaments, leaderboards).
  - Impact: Consistent adjudication with well-defined tie-breakers.

## Takeaways
- Build a stable rank tuple; compare lexicographically; parse and evaluate line-by-line.
