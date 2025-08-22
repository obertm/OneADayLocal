# Euler052 — Permuted multiples

Find the smallest x such that {2x,3x,4x,5x,6x} are all permutations of x’s digits.

## Approach

- Iterate x, checking that digit-count signature of kx matches x for k=2..6.
- Early bounds: number of digits must remain constant across 6x, so x must be at least 10^{d-1} and less than 10^d/6.

## Edge Cases
- Digit length change: When 6x crosses a power of 10, further x with that starting digit count invalid; jump to next length.
- Leading zeros: Not possible in integer multiplication; ignore.
- Signature collisions: Use fixed-size int[10] or sorted string; ensure resets between k iterations to avoid carryover.
- Overflow: For larger generalized multiples, watch beyond int range; here within int safe.
- Performance: Simple brute force fine; if generalized, pruning by digit length difference mandatory.

## Complexity
- O(candidates × digits), very fast with signature comparison.

## Practical examples and business impact

- Scale-invariant IDs: ensure that multiples of a base ID keep digit-multiset constraints for legacy systems.
- Billing: verify scaled charges (×2..×6) preserve reference code format by signature comparison.
- Fraud analytics: catch cases where scaling leaves a code’s digits permuted—suspicious consistent transforms.
- Data migration: check that scaled quantities map to the same digit signature to ensure consistent encoding.
- Load testing: generate inputs whose multiples permute digits, stressing normalization.
- Education: teach digit-signature hashing as a cheap equivalence test.
- Hash bucketing: assign by digit signature to keep permutations co-located.
- Telemetry: detect sensors with readings that are scaled copies up to permutation noise.
- Distributed systems: sanity-check that scaling factors don’t break formatting constraints across services.
- Simulation: explore parameter spaces where scaling preserves structure (digit multiset) and measure frequency.

## Key Takeaways
- Constrain by digit-length; use frequency arrays (10-sized) for equality checks.


## Java implementation (Euler052.java)

- Class: `Euler052`
- Approach: Increment x from 1 upward, compute a sorted-digit signature for x; check that for k=2..6, `signature(k*x)` matches.
- Helper: `signature(int)` sorts the digits into a canonical string for O(d log d) comparison.
- Output: The first x that satisfies the property.
