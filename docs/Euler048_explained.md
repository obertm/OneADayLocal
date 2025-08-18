# Euler048 — Self powers (last 10 digits)

Compute the last 10 digits of Σ_{i=1..N} i^i with N=1000.

## Method

- Use modular exponentiation with modulus M=10^10; compute powmod(i, i, M) and sum mod M.
- Be careful with overflow; use long with mod or BigInteger.modPow.

## Complexity
- O(N log i) exponentiation steps; trivial for N=1000.

## Real-world analogues and impact
- Modular arithmetic for checksums and rolling signatures.
  - Impact: Efficient tail-digit computations without big integers in memory.

## Takeaways
- Apply mod 10^10 throughout; sum modulo M to keep numbers small.


## Java implementation (Euler048.java)

- Class: `Euler048`
- Uses `BigInteger.modPow` with modulus `10^10` to compute each `i^i (mod M)` and maintains a running `sum = (sum + term) mod M`.
- Default N=1000, but you can pass a different N as the first argument; prints the last 10 digits as a number (leading zeros may be dropped when printed as a long).
