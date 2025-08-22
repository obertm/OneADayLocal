# Euler040 — Champernowne’s constant digits

Compute the product d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 where dn is the nth digit of the fractional part of Champernowne’s constant 0.123456789101112...

## Approach

- Walk digit-length blocks: numbers with 1 digit contribute 9×1 digits, 2-digit contribute 90×2, etc.
- For each target position, jump through blocks to find the exact source number and digit index within it.
- Multiply the extracted digits.

## Edge Cases

- Position = 0: Sequence is 1-indexed; 0 invalid; reject early.
- Large positions: Use long for running counts if extending beyond 1e6 to avoid int overflow.
- Off-by-one in block subtraction: Ensure when subtracting a whole block you decrement remaining position correctly; fencepost errors yield wrong digits.
- Conversion speed: Repeated string conversions for each digit extraction acceptable for small set; for many queries, precompute block offsets or use arithmetic to index digits directly.
- Leading zeros: Not present in natural numbers; no need to handle.
- Negative positions: Invalid input; guard.

## Complexity
- O(#targets × #digit-blocks) with tiny constants.

## Practical examples and business impact

- Log indexing: map byte offsets to record boundaries in concatenated logs without loading all data.
- Streaming analytics: jump to positions in synthetic sequences (IDs, counters) by digit-length blocks for fast sampling.
- Data lakes: compute nth-element queries over virtual sequences without materialization to control costs.
- Telemetry: index into concatenated counters for downsampling probes with strict latency budgets.
- Storage systems: implement sparse access over virtual concatenations (thin provisioning) via block math.
- Benchmark harnesses: reproducibly pull digits at specified positions from generated sequences without building them.
- ETL pagination: convert 1-based item positions into source segments and local offsets efficiently.
- Education: teach block-based offset math and constant-factor optimization in indexing.
- Search engines: compute term positions within concatenated posting lists using block jump tables.
- Time-series sim: index into synthetic “counting” series by digit-block math to generate exact points on demand.

## Key Takeaways
- Compute offsets by digit-length ranges; index into the exact number and digit.


## Java implementation (Euler040.java)

- Class: `Euler040`
- Helper: `digitAt(int n)` walks through digit-length blocks: 1-digit (9×1), 2-digit (90×2), etc., subtracting until the target falls in a block; then computes the exact source number and digit offset.
- Main: multiplies digits at positions `{1,10,100,1000,10000,100000,1000000}` by calling `digitAt(p)` for each; prints the product.
