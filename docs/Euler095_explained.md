# Euler095 — Amicable chains

Find the smallest member of the longest amicable chain with all terms < 1,000,000.

## Plan

- Sieve sum of proper divisors s(n) for n<1e6 via divisor-sum sieve.
- For each start not yet visited in a global state map, follow s(n) until repeating or leaving range.
- If a cycle appears fully within range, record its members and length; update best and minimal member.
- Memoize path results for reuse.

## Complexity
- O(N log N) sieve + near O(N) total traversal with memoization.

## Real-world impact
- Cycle detection in functional graphs with memoized traversal results.

## Java implementation (Euler095.java)
- Sieve `s(n)` for n<1e6 via adding i to multiples j=2i.. limit-1.
- For each unvisited start, walk x → s(x) within bounds tracking index map to detect cycles; when a cycle appears, compute its length and minimal member; update best.
- Mark all visited in this walk as globally seen to avoid reprocessing.
- Prints the smallest member of the longest amicable chain.
