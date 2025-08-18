# Euler040 — Champernowne’s constant digits

Compute the product d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 where dn is the nth digit of the fractional part of Champernowne’s constant 0.123456789101112...

## Method

- Walk digit-length blocks: numbers with 1 digit contribute 9×1 digits, 2-digit contribute 90×2, etc.
- For each target position, jump through blocks to find the exact source number and digit index within it.
- Multiply the extracted digits.

## Complexity
- O(#targets × #digit-blocks) with tiny constants.

## Real-world analogues and impact
- Position mapping in concatenated streams/logs without materializing the whole string.
  - Impact: Direct indexing for large synthetic sequences.

## Takeaways
- Compute offsets by digit-length ranges; index into the exact number and digit.


## Java implementation (Euler040.java)

- Class: `Euler040`
- Helper: `digitAt(int n)` walks through digit-length blocks: 1-digit (9×1), 2-digit (90×2), etc., subtracting until the target falls in a block; then computes the exact source number and digit offset.
- Main: multiplies digits at positions `{1,10,100,1000,10000,100000,1000000}` by calling `digitAt(p)` for each; prints the product.
