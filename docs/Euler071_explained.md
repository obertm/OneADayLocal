# Euler071 — Ordered fractions (left of 3/7)

Find the reduced proper fraction immediately to the left of 3/7 in the set of fractions with denominators ≤ 1,000,000; return its numerator.

## Approach

- For each denominator d up to limit, the best numerator n is floor((3d − 1)/7) to stay strictly less than 3/7.
- Check gcd(n,d)=1 and track the maximum value n/d encountered; keep its numerator.
- Using the mediant/Farey property ensures this greedy per-denominator choice is optimal.

## Complexity
- O(N) gcd checks with tiny constants; feasible for 1e6.

## Real-world analogues and impact
- Best-approximation to a target ratio under bounded denominator (rationals in scheduling, sampling rates).
  - Impact: Tight bounds via Farey/mediant arithmetic without sorting all fractions.

## Takeaways
- Compute n=floor((3d−1)/7) per d; keep coprime maximum just below 3/7.


## Java implementation (Euler071.java)

- Class: `Euler071`
- Loop d=2..1,000,000; compute `n = floor((3d−1)/7)`; track the maximum n/d seen so far using cross-multiplication to avoid FP.
- Output: Print the numerator `n` of the best fraction directly (as required by the problem).
