# Euler020 — Factorial digit sum (n!)

Compute the sum of digits of n!.

## Method

1) Exact factorial
- Multiply 1..n using `BigInteger` to avoid overflow.

2) Sum digits
- Convert to string and sum characters − '0', or mod/divide 10 in a loop.

3) Complexity
- O(n · M(n)) to compute factorial with big-int multiplication; digit sum is O(d) where d is digits in n!.

## Real-world analogues and impact
- Big combinatorial numbers in analytics; sanity checks via digit sums.
  - Impact: Correctness with arbitrary precision; avoids floating errors.

## Takeaways
- Use big ints for factorials; digit sum is straightforward afterward.
