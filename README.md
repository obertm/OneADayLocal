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
