# OneADays – Project Euler Java

This repo contains Java solutions to Project Euler problems, named `EulerNNN.java`.

## Runner
Use the included `EulerRunner` to discover and run problems easily.

### Build
```bash
javac EulerRunner.java
```

### Usage
- Interactive (default):
  ```bash
  java EulerRunner
  ```
- List discovered problems:
  ```bash
  java EulerRunner list
  ```
- Run a specific problem (optionally with args):
  ```bash
  java EulerRunner run 3
  java EulerRunner run 2 4000000
  ```
- Run all discovered problems:
  ```bash
  java EulerRunner all
  ```

The runner will auto-compile `EulerNNN.java` on demand if the `.class` is missing.

## Conventions
- File/class names follow `EulerNNN` (3-digit padded), e.g., `Euler001`, `Euler042`.
- Each class should provide a `public static void main(String[] args)` entrypoint.
- Standard input/output only; avoid requiring external files or libraries.

## Adding a new problem
1. Create `EulerNNN.java` with a `main` method.
2. Optionally compile it:
   ```bash
   javac EulerNNN.java
   ```
3. Run via the runner:
   ```bash
   java EulerRunner run NNN
   ```

## Examples
```bash
java EulerRunner run 1      # 233168
java EulerRunner run 2 100  # 44
java EulerRunner run 3      # 6857
java EulerRunner run 4      # 906609
```

## Docs index
- Problem walkthroughs with approach, rationale, and real-world applications:
  - [Euler001 – Sum of multiples of 3 or 5](docs/Euler001_explained.md)
  - [Euler002 – Sum of even Fibonacci numbers](docs/Euler002_explained.md)
  - [Euler003 – Largest prime factor](docs/Euler003_explained.md)
  - [Euler004 – Largest palindrome product](docs/Euler004_explained.md)
  - [Euler005 – Smallest multiple (LCM up to n)](docs/Euler005_explained.md)
  - [Euler006 – Sum square difference](docs/Euler006_explained.md)
  - [Euler007 – nth prime](docs/Euler007_explained.md)
  - [Euler008 – Largest product in a series](docs/Euler008_explained.md)
  - [Euler009 – Special Pythagorean triplet](docs/Euler009_explained.md)
  - [Euler010 – Summation of primes below n](docs/Euler010_explained.md)
  - [Euler011 – Largest product in a grid](docs/Euler011_explained.md)
  - [Euler012 – Highly divisible triangular number](docs/Euler012_explained.md)
  - [Euler013 – First ten digits of large sum](docs/Euler013_explained.md)
  - [Euler014 – Longest Collatz sequence](docs/Euler014_explained.md)
  - [Euler015 – Lattice paths](docs/Euler015_explained.md)
  - [Euler016 – Power digit sum](docs/Euler016_explained.md)
  - [Euler017 – Number letter counts](docs/Euler017_explained.md)
  - [Euler018 – Maximum path sum I](docs/Euler018_explained.md)
  - [Euler019 – Counting Sundays](docs/Euler019_explained.md)
  - [Euler020 – Factorial digit sum](docs/Euler020_explained.md)
  - [Euler021 – Amicable numbers](docs/Euler021_explained.md)
  - [Euler022 – Names scores](docs/Euler022_explained.md)
  - [Euler023 – Non-abundant sums](docs/Euler023_explained.md)
  - [Euler024 – Lexicographic permutations](docs/Euler024_explained.md)
  - [Euler025 – 1000-digit Fibonacci index](docs/Euler025_explained.md)
  - [Euler026 – Reciprocal cycles](docs/Euler026_explained.md)
  - [Euler027 – Quadratic primes](docs/Euler027_explained.md)
  - [Euler028 – Number spiral diagonals](docs/Euler028_explained.md)
  - [Euler029 – Distinct powers](docs/Euler029_explained.md)
  - [Euler030 – Digit fifth powers](docs/Euler030_explained.md)
  - [Euler031 – Coin sums](docs/Euler031_explained.md)
  - [Euler032 – Pandigital products](docs/Euler032_explained.md)
  - [Euler033 – Digit cancelling fractions](docs/Euler033_explained.md)
  - [Euler034 – Digit factorials](docs/Euler034_explained.md)
  - [Euler035 – Circular primes](docs/Euler035_explained.md)
  - [Euler036 – Double-base palindromes](docs/Euler036_explained.md)
  - [Euler037 – Truncatable primes](docs/Euler037_explained.md)
  - [Euler038 – Pandigital concatenated product](docs/Euler038_explained.md)
  - [Euler039 – Integer right triangles](docs/Euler039_explained.md)
  - [Euler040 – Champernowne’s constant digits](docs/Euler040_explained.md)
  - [Euler041 – Pandigital prime](docs/Euler041_explained.md)
  - [Euler042 – Coded triangle numbers](docs/Euler042_explained.md)
  - [Euler043 – Sub-string divisibility](docs/Euler043_explained.md)
  - [Euler044 – Pentagon numbers](docs/Euler044_explained.md)
  - [Euler045 – Triangular, pentagonal, hexagonal](docs/Euler045_explained.md)
  - [Euler046 – Goldbach’s other conjecture](docs/Euler046_explained.md)
  - [Euler047 – Distinct prime factors (run of K)](docs/Euler047_explained.md)
  - [Euler048 – Self powers (last 10 digits)](docs/Euler048_explained.md)
  - [Euler049 – Prime permutations in arithmetic progression](docs/Euler049_explained.md)
  - [Euler050 – Consecutive prime sum](docs/Euler050_explained.md)
  - [Euler051 – Prime digit replacements](docs/Euler051_explained.md)
  - [Euler052 – Permuted multiples](docs/Euler052_explained.md)
  - [Euler053 – Combinatoric selections](docs/Euler053_explained.md)
  - [Euler054 – Poker hands](docs/Euler054_explained.md)
  - [Euler055 – Lychrel numbers (reverse-and-add)](docs/Euler055_explained.md)
  - [Euler056 – Powerful digit sum](docs/Euler056_explained.md)
  - [Euler057 – Square root convergents](docs/Euler057_explained.md)
  - [Euler058 – Spiral primes ratio](docs/Euler058_explained.md)
  - [Euler059 – XOR decryption](docs/Euler059_explained.md)
  - [Euler060 – Prime pair sets](docs/Euler060_explained.md)
  - [Euler061 – Cyclical figurate numbers](docs/Euler061_explained.md)
  - [Euler062 – Cubic permutations](docs/Euler062_explained.md)
  - [Euler063 – Powerful digit counts](docs/Euler063_explained.md)
  - [Euler064 – Odd period square roots](docs/Euler064_explained.md)
  - [Euler065 – Convergents of e](docs/Euler065_explained.md)
  - [Euler066 – Diophantine equation (Pell)](docs/Euler066_explained.md)
  - [Euler067 – Maximum path sum II](docs/Euler067_explained.md)
  - [Euler068 – Magic 5-gon ring](docs/Euler068_explained.md)
  - [Euler069 – Totient maximum](docs/Euler069_explained.md)
  - [Euler070 – Totient permutation](docs/Euler070_explained.md)
  - [Euler071 – Ordered fractions (left of 3/7)](docs/Euler071_explained.md)
  - [Euler072 – Counting reduced proper fractions](docs/Euler072_explained.md)
  - [Euler073 – Counting fractions in a range (1/3, 1/2)](docs/Euler073_explained.md)
  - [Euler074 – Digit factorial chains](docs/Euler074_explained.md)
  - [Euler075 – Singular integer right triangles](docs/Euler075_explained.md)
  - [Euler076 – Counting summations](docs/Euler076_explained.md)
  - [Euler077 – Prime summations](docs/Euler077_explained.md)
  - [Euler078 – Coin partitions divisible by one million](docs/Euler078_explained.md)
  - [Euler079 – Passcode derivation](docs/Euler079_explained.md)
  - [Euler080 – Square root digital expansion](docs/Euler080_explained.md)
  - [Euler081 – Path sum: two ways](docs/Euler081_explained.md)
  - [Euler082 – Path sum: three ways](docs/Euler082_explained.md)
  - [Euler083 – Path sum: four ways](docs/Euler083_explained.md)
  - [Euler084 – Monopoly odds](docs/Euler084_explained.md)
  - [Euler085 – Counting rectangles](docs/Euler085_explained.md)
  - [Euler086 – Cuboid route](docs/Euler086_explained.md)
  - [Euler087 – Prime power triples](docs/Euler087_explained.md)
  - [Euler088 – Product-sum numbers](docs/Euler088_explained.md)
  - [Euler089 – Roman numerals](docs/Euler089_explained.md)
  - [Euler090 – Cube digit pairs](docs/Euler090_explained.md)
  - [Euler091 – Right triangles with integer coordinates](docs/Euler091_explained.md)
  - [Euler092 – Square digit chains](docs/Euler092_explained.md)
  - [Euler093 – Arithmetic expressions using four digits](docs/Euler093_explained.md)
  - [Euler094 – Almost equilateral triangles](docs/Euler094_explained.md)
  - [Euler095 – Amicable chains](docs/Euler095_explained.md)
  - [Euler096 – Su Doku](docs/Euler096_explained.md)
  - [Euler097 – Large non-Mersenne prime](docs/Euler097_explained.md)
  - [Euler098 – Anagramic squares](docs/Euler098_explained.md)
  - [Euler099 – Largest exponential](docs/Euler099_explained.md)
  - [Euler100 – Arranged probability](docs/Euler100_explained.md)
<!-- BEGIN: EULER_RESULTS -->
## Results

| # | Answer | Time (ms) |
|---:|:------|---------:|
| 001 | 233168 | 5.603 |
| 002 | 4613732 | 0.159 |
| 003 | 6857 | 0.853 |
| 004 | 906609 | 1.318 |
| 005 | 232792560 | 0.168 |
| 006 | 25164150 | 0.281 |
| 007 | 104743 | 15.510 |
| 008 | 23514624000 | 0.328 |
| 009 | 31875000 | 0.159 |
| 010 | 142913828922 | 9.653 |
| 011 | 70600674 | 8.059 |
| 012 | 76576500 | 3.906 |
| 013 | 5537376230 | 1.739 |
| 014 | 837799 | 633.142 |
| 015 | 137846528820 | 2.979 |
| 016 | 1366 | 0.910 |
| 017 | 21124 | 24.600 |
| 018 | 1074 | 0.250 |
| 019 | 171 | 0.930 |
| 020 | 648 | 1.234 |
| 021 | 31626 | 8.847 |
| 022 | 871198282 | 23.808 |
| 023 | 4179871 | 43.572 |
| 024 | 2783915460 | 0.258 |
| 025 | 4782 | 4.775 |
| 026 | 983 | 1.770 |
| 027 | -59231 | 38.915 |
| 028 | 669171001 | 0.264 |
| 029 | 9183 | 40.712 |
| 030 | 443839 | 12.871 |
| 031 | 73682 | 4.199 |
| 032 | 45228 | 41.845 |
| 033 | 100 | 0.564 |
| 034 | 40730 | 41.853 |
| 035 | 55 | 73.245 |
| 036 | 872187 | 35.672 |
| 037 | 748317 | 70.072 |
| 038 | 932718654 | 4.955 |
| 039 | 840 | 137.523 |
| 040 | 210 | 0.181 |
| 041 | 7652413 | 11.435 |
| 042 | 162 | 5.758 |
| 043 | 16695334890 | 162.874 |
| 044 | 5482660 | 93.184 |
| 045 | 1533776805 | 3.579 |
| 046 | 5777 | 7.606 |
| 047 | 134043 | 27.541 |
| 048 | 9110846700 | 46.352 |
| 049 | 296962999629 | 29.624 |
| 050 | 997651 | 27.149 |
| 051 | 121313 | 70.557 |
| 052 | 142857 | 72.565 |
| 053 | 4075 | 0.812 |
| 054 | 376 | 69.161 |
| 055 | 249 | 161.727 |
| 056 | 972 | 127.255 |
| 057 | 153 | 36.246 |
| 058 | 26241 | 77.418 |
| 059 | 129448 | 27.148 |
| 061 | 28684 | 17.580 |
| 062 | 127035954683 | 26.465 |
| 063 | 49 | 1.597 |
| 064 | 1322 | 4.507 |
| 065 | 272 | 0.515 |
| 066 | 661 | 26.834 |
| 067 | 7273 | 18.805 |
| 068 | 6531031914842725 | 113.339 |
| 069 | 510510 | 0.204 |
| 070 | 8319823 | 55.139 |
| 081 | 427337 | 30.130 |
| 082 | 260324 | 11.571 |
| 083 | 425185 | 24.957 |
| 084 | 101524 | 38.085 |
| 085 | 2772 | 3.217 |
| 086 | 1818 | 29.738 |
| 087 | 1097343 | 65.965 |
| 088 | 7587457 | 12.696 |
| 089 | 743 | 7.556 |
| 090 | 1217 | 7.375 |
<!-- END: EULER_RESULTS -->


