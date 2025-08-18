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
