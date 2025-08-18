# Euler097 — Large non-Mersenne prime

Compute the last ten digits of 28433×2^7830457 + 1.

## Method

- Modular exponentiation: powmod(2, 7830457, 10^10). Multiply by 28433 mod 10^10, add 1, then mod 10^10.
- Be careful to keep all operations modulo 10^10 to avoid overflow.

## Complexity
- O(log exponent) multiplications; trivial.

## Real-world impact
- Efficient tail-digit calculations for large exponents.
