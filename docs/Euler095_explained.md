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
