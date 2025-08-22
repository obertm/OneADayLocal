# Euler097 — Large non-Mersenne prime

Compute the last ten digits of 28433×2^7830457 + 1.

## Method

- Modular exponentiation: powmod(2, 7830457, 10^10). Multiply by 28433 mod 10^10, add 1, then mod 10^10.
- Be careful to keep all operations modulo 10^10 to avoid overflow.

## Edge Cases
- Leading zeros: Result may start with zeros; pad to 10 digits when printing.
- Overflow: Use long; intermediate multiplication `(res*base) % mod` safe if mod < 2^33; here 10^10 < 2^34.
- Negative mod: Not applicable; all operands positive.
- Exponent loop: Fast exponentiation required; linear multiply would be too slow (but still feasible); ensure binary method used.
- Mod constant: Use long 10000000000L; int overflow if cast improperly.

## Complexity
- O(log exponent) multiplications; trivial.

## Practical examples and business impact
- Cryptography: trailing block extraction of large exponentiations.
- Streaming: track low-order digits for checksum-like monitoring.
- Distributed computing: verifying partial results via tail-digit signatures.

## Key Takeaways
- Binary modular exponentiation keeps numbers bounded; apply factors & additions modulo.

## Java implementation (Euler097.java)
- Computes powmod using binary exponentiation: `modPow2(7_830_457, 10^10)`.
- Forms `(28433 * pow + 1) mod 10^10` and prints 10 digits with zero-padding.
- All math in long with modulo 10^10 to avoid overflow.
