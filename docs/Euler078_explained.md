# Euler078 — Coin partitions divisible by one million

Find the least n such that the number of partitions p(n) is divisible by 1,000,000.

## Approach

- Use generalized pentagonal numbers g(k)=k(3k−1)/2 for k=1,−1,2,−2,...
- Recurrence: p(n)=Σ (-1)^{k-1} p(n−g(k)), summing terms while n−g(k)≥0.
- Compute p(n) mod 1_000_000 iteratively until p(n)≡0.

## Edge Cases
- Pentagonal generation order: Must alternate positive/negative k to apply correct sign pattern (+,+,−,−,...).
- Modulo handling: Apply mod after each addition/subtraction to keep numbers small; adjust negative sums by +MOD.
- Array growth: Need p up to answer n; dynamic list append vs preallocate large array; dynamic is safer.
- Performance: Break inner pentagonal loop when n−g(k)<0 to avoid unnecessary work.
- Starting values: p(0)=1 base case required; missing leads to zeros everywhere.

## Complexity
- ~O(n^{3/2}) terms across n due to pentagonal growth; practical with modulo.

## Practical examples and business impact
- Partition counts with modular targets.
  - Impact: Efficient recurrence avoids full DP table.

## Key Takeaways
- Implement pentagonal recurrence with modulo; stop at first n with p(n)≡0.


## Java implementation (Euler078.java)

- Class: `Euler078`
- Maintains `p[0]=1` and computes p(n) modulo 1,000,000 using generalized pentagonal numbers ±k(3k−1)/2 and alternating signs.
- Stops and prints n at the first p(n)≡0 mod 1e6; includes a safe capacity bound to run within time here.
