# Euler072 — Counting reduced proper fractions

Count the number of reduced proper fractions for denominators up to N.

## Key fact

- Count = Σ_{d=2..N} φ(d), where φ is Euler’s totient.

## Implementation

- Compute φ(1..N) with a sieve-like method: initialize phi[i]=i; for each prime p, for multiples m of p do phi[m]-=phi[m]/p.
- Sum phi[2..N].

## Complexity
- O(N log log N) for the totient sieve; O(N) space.

## Real-world analogues and impact
- Counting coprime pairs/ratios efficiently.
  - Impact: Avoids quadratic enumeration of fractions.

## Takeaways
- Totient sieve plus a prefix sum gives the answer directly.
