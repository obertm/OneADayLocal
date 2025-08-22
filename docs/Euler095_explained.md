# Euler095 — Amicable chains

Find the smallest member of the longest amicable chain with all terms < 1,000,000.

## Plan

- Sieve sum of proper divisors s(n) for n<1e6 via divisor-sum sieve.
- For each start not yet visited in a global state map, follow s(n) until repeating or leaving range.
- If a cycle appears fully within range, record its members and length; update best and minimal member.
- Memoize path results for reuse.

## Edge Cases
- s(n)=n: Perfect numbers form length-1 cycles; exclude since chain length must be >1 for interest (but spec counts cycles regardless—decide inclusion policy; Euler expects excluding trivial?).
- Exiting range: If chain hits ≥ limit, discard entire chain; mark path nodes to avoid reprocessing.
- Zero or negative: s(n) always ≥1 for n≥1; no special case needed.
- Repeated nodes before cycle: Need index map to measure cycle length accurately between first occurrence and repetition.
- Overflow: Divisor sum fits in int for n<1e6; safe; for larger use long.

## Complexity
- O(N log N) sieve + near O(N) total traversal with memoization.

## Practical examples and business impact
- Dependency resolution: cycle detection with memoized path compression.
- Social graphs: amicable (mutual) chains detection analogies.
- Caching: functional graph traversal reuse via memo states.

## Key Takeaways
- Sieve divisor sums; traverse functional graph storing visitation indices to isolate cycles.

## Java implementation (Euler095.java)
- Sieve `s(n)` for n<1e6 via adding i to multiples j=2i.. limit-1.
- For each unvisited start, walk x → s(x) within bounds tracking index map to detect cycles; when a cycle appears, compute its length and minimal member; update best.
- Mark all visited in this walk as globally seen to avoid reprocessing.
- Prints the smallest member of the longest amicable chain.
