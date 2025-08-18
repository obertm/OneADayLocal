# Euler021 — Amicable numbers under N

Find the sum of all amicable numbers < N. Two numbers a ≠ b are amicable if d(a) = b and d(b) = a, where d(x) is the sum of proper divisors of x.

## Approach you can reuse

1) Precompute d(x)
- Use a sieve-like pass: initialize sums with 1 (for x>1), then for each factor f from 2..√N add f and x/f to multiples.
- Or classic divisor-sum sieve: for m from 2..N/2, add m to all multiples 2m,3m,...

2) Detect amicable pairs
- For each a in [2..N): b = d(a); if b < N, b ≠ a, and d(b) = a → add a (and b if iterating carefully).

## Complexity
- Divisor-sum sieve ~ O(N log N); detection O(N).

## Real-world analogues and impact
- Mutual relationships detection (A credits B and B credits A) in ledgers.
  - Impact: Fast precomputation avoids quadratic pair checks.

## Takeaways
- Sieve the divisor sums once; then check the amicable condition in O(1) per a.
