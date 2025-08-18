# Euler027 — Quadratic primes

Find coefficients a and b for n^2 + a n + b that produce the longest run of consecutive primes starting at n=0, with |a|<A, |b|≤B.

## Practical strategy

1) Constrain b
- At n=0, value = b must be prime (and positive). Precompute primes up to B.

2) Scan a
- Iterate a in [-(A-1)..A-1]. For each (a,b), count consecutive n where the polynomial yields a prime.

3) Prime testing
- Use a sieve-generated prime set and trial division up to √value.

## Complexity
- O(A·B·L) where L is avg run length; manageable with pruning (b prime).

## Real-world analogues and impact
- Parameter search with domain constraints to reduce compute.
  - Impact: Dramatically smaller search space with simple necessary conditions.

## Takeaways
- b must be prime; then brute-force a and count runs using a fast primality check.
