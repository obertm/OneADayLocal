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
<!-- BEGIN: EULER_RESULTS -->
## Results

| # | Answer | Time (ms) |
|---:|:------|---------:|
| 001 | 233168 | 10.506 |
| 002 | 4613732 | 0.185 |
| 003 | 6857 | 0.190 |
| 004 | 906609 | 5.986 |
| 005 | 232792560 | 0.206 |
| 006 | 25164150 | 0.200 |
| 007 | 104743 | 22.985 |
| 008 | 23514624000 | 0.338 |
| 009 | 31875000 | 0.205 |
| 010 | 142913828922 | 13.543 |
| 011 | 70600674 | 2.934 |
| 012 | 76576500 | 6.576 |
| 013 | 5537376230 | 5.025 |
| 014 | 837799 | 483.784 |
| 015 | 137846528820 | 0.838 |
| 016 | 1366 | 0.765 |
| 017 | 21124 | 18.750 |
| 018 | 1074 | 0.430 |
| 019 | 171 | 0.351 |
| 020 | 648 | 0.648 |
| 021 | 31626 | 3.494 |
| 022 | 871198282 | 32.866 |
| 023 | 4179871 | 59.729 |
| 024 | 2783915460 | 0.276 |
| 025 | 4782 | 4.547 |
| 026 | 983 | 3.173 |
| 027 | -59231 | 51.836 |
| 028 | 669171001 | 0.239 |
| 029 | 9183 | 44.917 |
| 030 | 443839 | 19.363 |
| 031 | 73682 | 0.404 |
| 032 | 45228 | 46.225 |
| 033 | 100 | 0.595 |
| 034 | 40730 | 89.387 |
| 035 | 55 | 100.613 |
| 036 | 872187 | 34.464 |
| 037 | 748317 | 69.796 |
| 038 | 932718654 | 4.674 |
| 039 | 840 | 134.961 |
| 040 | 210 | 0.244 |
| 041 | 7652413 | 4.894 |
| 042 | 162 | 2.793 |
| 043 | 16695334890 | 168.783 |
| 044 | 5482660 | 90.332 |
| 045 | 1533776805 | 3.314 |
| 046 | 5777 | 7.951 |
| 047 | 134043 | 26.909 |
| 048 | 9110846700 | 47.949 |
| 049 | 296962999629 | 8.991 |
| 050 | 997651 | 26.243 |
<!-- END: EULER_RESULTS -->

