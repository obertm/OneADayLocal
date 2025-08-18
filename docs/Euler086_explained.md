# Euler086 — Cuboid route

For integer cuboids with sides up to M, count how many have an integer shortest path between opposite corners on the surface; find minimal M such that count exceeds one million.

## Approach

- For each c in 1..M (treat c as the largest side), consider s=a+b ranging from 2..2c.
- The shortest path length is √(c^2 + s^2); it’s integer if c^2+s^2 is a perfect square.
- For each s, the number of (a,b) pairs with 1≤a≤b≤c and a+b=s is count(s,c) = min(c, s−1) − ceil(s/2) + 1 when positive.
- Accumulate counts over c until exceeding 1,000,000.

## Complexity
- ~O(M^2) with fast square tests; feasible.

## Real-world impact
- Discrete geometry with integer-length constraints; counting via aggregation over sums.
