# Euler016 — Power digit sum (2^n)

Compute the sum of digits of 2^n.

## Reliable method

1) Use exact integers
- 2^n can be built via `BigInteger.ONE.shiftLeft(n)` or `BigInteger.valueOf(2).pow(n)`.
- Convert to string and sum digits, or repeatedly mod/divide by 10.

2) Complexity
- O(d) where d is digits in 2^n (~ n·log10(2)); space O(d).

## Real-world analogues and impact
- Checksums and digital roots of big integers.
  - Impact: Quick integrity checks without floating point.

## Takeaways
- Use big-int exponentiation; sum digits straightforwardly.
