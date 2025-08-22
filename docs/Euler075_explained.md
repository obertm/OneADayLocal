# Euler075 — Singular integer right triangles

For perimeters P ≤ 1,500,000, count how many P can be formed in exactly one way as a+b+c=P with integer right triangles.

## Approach

- Generate primitive triples via Euclid: a=m^2−n^2, b=2mn, c=m^2+n^2 with m>n, coprime, not both odd.
- For each primitive perimeter p0=2m(m+n), increment counts for all multiples k·p0 ≤ P.
- Answer is count of P with occurrences==1.

## Edge Cases
- Coprimality: Must enforce gcd(m,n)=1 and opposite parity; missing either yields duplicates.
- Overflow: 2m(m+n) for m up to sqrt(P/2) fits in 32-bit; for larger P consider long.
- Counting multiples: Ensure each multiple counted once; loop k from 1 while k·p0 ≤ P.
- Array sizing: Count array must be P+1; memory ~1.5M ints fine; larger P requires memory check.
- Early break: If p0 > P, break inner n loop to reduce iterations.

## Complexity
- ~O(P log P) with small constants; very fast.

## Practical examples and business impact
- Counting unique representations via structured generators and multiple coverage.
  - Impact: Accurate uniqueness detection without brute forcing a,b,c.

## Key Takeaways
- Generate perimeters from primitive triples; mark multiples; count those with exactly one representation.


## Java implementation (Euler075.java)

- Class: `Euler075`
- For m>n with opposite parity and gcd(m,n)=1, perimeter `p0 = 2m(m+n)`; for k*p0 ≤ 1,500,000, increment `count[p]` and maintain a running result of perimeters with count==1.
- Output: Print the number of perimeters that are singular.
