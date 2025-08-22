# Euler072 — Counting reduced proper fractions

Count the number of reduced proper fractions for denominators up to N.

## Approach

- Count = Σ_{d=2..N} φ(d), where φ is Euler’s totient.

## Step-by-step reasoning

- Compute φ(1..N) with a sieve-like method: initialize phi[i]=i; for each prime p, for multiples m of p do phi[m]-=phi[m]/p.
- Sum phi[2..N].

## Edge Cases
- N=1: Sum is zero; handle trivial limit.
- Overflow: Σ φ(d) for N=1e6 fits in 64-bit; use long. For larger N consider BigInteger.
- Memory: phi array of size N+1; ensure N not too large for memory constraints.
- Prime detection: Use condition phi[p]==p; misinitialization breaks sieve.
- Data type: Avoid int for accumulator; risk overflow when N large.

## Complexity
- O(N log log N) for the totient sieve; O(N) space.

## Practical examples and business impact
- Counting coprime pairs/ratios efficiently.
  - Impact: Avoids quadratic enumeration of fractions.

## Key Takeaways
- Totient sieve plus a prefix sum gives the answer directly.


## Java implementation (Euler072.java)

- Class: `Euler072`
- Initialize `phi[i]=i`; for each prime p (detected via `phi[p]==p`), subtract `phi[m]/p` from all multiples m of p.
- Sum `phi[2..N]` into a 64-bit accumulator; print the total.
