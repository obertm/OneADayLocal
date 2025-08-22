# Euler071 — Ordered fractions (left of 3/7)

Find the reduced proper fraction immediately to the left of 3/7 in the set of fractions with denominators ≤ 1,000,000; return its numerator.

## Approach

- For each denominator d up to limit, the best numerator n is floor((3d − 1)/7) to stay strictly less than 3/7.
- Check gcd(n,d)=1 and track the maximum value n/d encountered; keep its numerator.
- Using the mediant/Farey property ensures this greedy per-denominator choice is optimal.

## Edge Cases
- Exact multiple: When 3d is divisible by 7, subtract 1 in numerator to stay strictly left.
- GCD performance: Use iterative gcd with ints; but denominator up to 1e6 so still trivial.
- Overflow: 3d fits in 32-bit; safe. For larger limits use long.
- Precision: Avoid floating comparisons; use cross-multiplication to compare fractions.
- Denominator 7: Skips 3/7 itself due to subtract 1; ensures strict inequality.

## Complexity
- O(N) gcd checks with tiny constants; feasible for 1e6.

## Real-world analogues and impact
- Best-approximation to a target ratio under bounded denominator (rationals in scheduling, sampling rates).
  - Impact: Tight bounds via Farey/mediant arithmetic without sorting all fractions.

## Key Takeaways
- Compute n=floor((3d−1)/7) per d; keep coprime maximum just below 3/7.


## Java implementation (Euler071.java)

- Class: `Euler071`
- Loop d=2..1,000,000; compute `n = floor((3d−1)/7)`; track the maximum n/d seen so far using cross-multiplication to avoid FP.
- Output: Print the numerator `n` of the best fraction directly (as required by the problem).
