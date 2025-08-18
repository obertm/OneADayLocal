# Euler029 — Distinct powers

Count distinct terms of a^b for 2 ≤ a ≤ A and 2 ≤ b ≤ B.

## Simple and safe

1) Big integers
- Compute BigInteger.valueOf(a).pow(b) and insert into a HashSet.

2) Optional math optimization
- Normalize perfect powers by prime factorization to avoid duplicates analytically, but BigInteger+Set is sufficient here.

## Complexity
- O(A·B) big-int exponentiations and hashing; fine for A=B=100.

## Real-world analogues and impact
- Canonicalization of exponentiated terms (e.g., deduplicating generated keys/signatures).
  - Impact: Reliable uniqueness with exact arithmetic.

## Takeaways
- Exact exponentiation + hash set deduplication is clear and robust for these bounds.

## Java implementation (Euler029.java)

We enumerate a and b, compute exact powers, and deduplicate via a hash set.

- State: parse optional four args (aMin, aMax, bMin, bMax) or default to 2..100 for both.
- Core: nested loops over a and b. For each, compute `BigInteger.valueOf(a).pow(b)` and `set.add(...)`.
- Output: print `set.size()`.

Classroom notes:
- BigInteger is required to avoid overflow; a^b grows quickly.
- HashSet<BigInteger> handles equality by value; no normalization is needed at this scale.
