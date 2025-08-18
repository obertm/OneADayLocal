# Euler078 — Coin partitions divisible by one million

Find the least n such that the number of partitions p(n) is divisible by 1,000,000.

## Pentagonal recurrence

- Use generalized pentagonal numbers g(k)=k(3k−1)/2 for k=1,−1,2,−2,...
- Recurrence: p(n)=Σ (-1)^{k-1} p(n−g(k)), summing terms while n−g(k)≥0.
- Compute p(n) mod 1_000_000 iteratively until p(n)≡0.

## Complexity
- ~O(n^{3/2}) terms across n due to pentagonal growth; practical with modulo.

## Real-world analogues and impact
- Partition counts with modular targets.
  - Impact: Efficient recurrence avoids full DP table.

## Takeaways
- Implement pentagonal recurrence with modulo; stop at first n with p(n)≡0.
