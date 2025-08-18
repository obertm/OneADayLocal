# Euler054 — Poker hands

Given many poker deals, count how many hands Player 1 wins.

## Evaluator outline

- Map cards to ranks (2..A) and suits; compute hand rank tuple: (category, primary ranks...). Categories: High card, Pair, Two pairs, Three of a kind, Straight, Flush, Full house, Four, Straight flush, Royal flush.
- Compare tuples lexicographically for two hands.
- Parse the dataset, evaluate both hands per line, increment wins for Player 1 when tuple1 > tuple2.

## Complexity
- O(#hands) with constant-time per-hand evaluation.

## Practical examples and business impact

- Tournament adjudication: deterministic ranking with exact tie-breakers.
- Leaderboards: stable ordering under complex category-plus-kicker rules.
- Card-game engines: reusable hand evaluators with lexicographic keys.
- Fraud detection: spot improbable patterns in hands (collusion signals) with rank distributions.
- Simulation: Monte Carlo over deals to validate evaluator correctness and performance.
- Education: teaching lexicographic ranking and tie-break design.
- Online gaming: server-side authoritative evaluation to prevent client tampering.
- Load testing: generate massive random deals and measure throughput of evaluators.
- Analytics: distribution of hand categories over datasets to tune AI opponents.
- QA suites: golden-file comparisons using stable 64-bit rank keys across versions.

## Takeaways
- Build a stable rank tuple; compare lexicographically; parse and evaluate line-by-line.


## Java implementation (Euler054.java)

- Class: `Euler054`
- Input: Attempts to read `poker.txt` or `0054_poker.txt` by default; path may be passed via CLI arg.
- Parsing: Split each line into 10 tokens; first 5 for Player 1, next 5 for Player 2; each card parsed into rank (2..A) and suit.
- Ranking: Build a comparable 64-bit key encoding category and tie-breakers:
  - Categories: straight flush (8), four (7), full house (6), flush (5), straight (4), three (3), two pairs (2), pair (1), high card (0).
  - Ties: primary ranks in descending order depending on category, including special A-5 straight handling.
- Compare keys; increment Player 1’s wins when key1 > key2; print total wins.
