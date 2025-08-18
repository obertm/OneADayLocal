# Euler097 — Large non-Mersenne prime

Compute the last ten digits of 28433×2^7830457 + 1.

## Method

- Modular exponentiation: powmod(2, 7830457, 10^10). Multiply by 28433 mod 10^10, add 1, then mod 10^10.
- Be careful to keep all operations modulo 10^10 to avoid overflow.

## Complexity
- O(log exponent) multiplications; trivial.

## Real-world impact
- Efficient tail-digit calculations for large exponents.

## Java implementation (Euler097.java)
- Computes powmod using binary exponentiation: `modPow2(7_830_457, 10^10)`.
- Forms `(28433 * pow + 1) mod 10^10` and prints 10 digits with zero-padding.
- All math in long with modulo 10^10 to avoid overflow.
