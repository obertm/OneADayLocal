# Euler004 — Largest palindrome product (n digits)

Find the largest palindrome number made from the product of two n-digit numbers.

## Problem statement

- Input: n (digits, n ≥ 1). Two factors are in [10^(n-1), 10^n − 1].
- Output: maximum product i*j that reads the same forward and backward.

## Step-by-step reasoning

1) Start with a straightforward search + palindrome check
- Iterate i from high down to low.
- For each i, iterate j from i down to low (avoid duplicates, i*j=j*i).
- Check if `prod = i*j` is a palindrome:
  - Reverse digits numerically or compare string to its reverse.
- Track the max palindrome.

2) Pruning to speed up
- If `i * high <= currentMax`, break outer loop for that i (no better product exists with smaller j).
- If `i * j <= currentMax`, break inner loop and move to next i.
- Optional: generate palindromes first (by mirroring) and test factorability within range—often faster for large n.

3) Complexity
- Worst-case O(R^2) products where R is the range size. Pruning reduces work a lot in practice.

4) Reusable template
- For “find max satisfying property over product pairs,” iterate descending, prune with best-known bounds, and test the property efficiently.

## Practical examples and business impact

- Search with symmetry and pruning
  - Problem: Generate candidates that satisfy mirrored or checksum patterns (SKUs, IDs).
  - Model: Mirror digits/characters to produce valid shapes; test constraints.
  - Impact: Less compute; faster feasibility checks.

- Bounded optimization on discrete grids
  - Problem: Find best pair/product under constraints.
  - Model: Descend from upper bounds; prune when no improvement possible.
  - Impact: Big search‑space cuts with simple heuristics.

- Image processing pattern matches
  - Problem: Search for symmetric kernels/patterns efficiently.
  - Model: Generate symmetric candidates first; early reject others.
  - Impact: Faster template matching.

- Inventory pairing for bundles
  - Problem: Maximize value of product bundles from two catalogs.
  - Model: Iterate descending by price; prune on current best.
  - Impact: Rapid bundle recommendation.

- Network design with latency budgets
  - Problem: Choose two nodes whose combined property (e.g., latencies) is optimal and symmetric.
  - Model: Palindrome‑like constraints act as quick filters.
  - Impact: Feasible designs found faster.

- E‑commerce coupon codes
  - Problem: Validate codes with palindromic or mirrored sections.
  - Model: Numeric reversal/string comparison as fast predicate.
  - Impact: Low‑cost validation at scale.

- Testing harnesses
  - Problem: Create worst‑case inputs for palindrome detection.
  - Model: Generate descending palindromes; check factoring.
  - Impact: Solid regression suites.

- Game design (procedural content)
  - Problem: Create symmetric artifacts (maps, numbers) with high “score.”
  - Model: Mirror generation + prune by best score.
  - Impact: Quality content with less search.

- Financial product combos
  - Problem: Pair lots/contracts to maximize palindromic identifiers for audit traceability.
  - Model: Palindrome check as compliance rule; prune pairs.
  - Impact: Compliance‑friendly operations.

## Key takeaways
- Start with nested loops + a fast property check.
- Use descending order + upper-bound pruning to cut the search space.
- Consider generating candidates directly using symmetry.

## Java implementation (Euler004.java)

- Helper: `isPalindrome(int n)` reverses digits numerically and compares to the original.
- Core: `largestPalindromeProductNDigits(int digits)`
  - Sets `high = 10^digits - 1`, `low = 10^(digits-1)`.
  - Iterates `i` from `high` down to `low`; inner loop `j` from `i` down to `low` to avoid duplicates.
  - Prunes when `i*high <= max` and when `i*j <= max`; updates `max` on palindrome.
  - Returns `max`.
- CLI: `main(String[] args)` defaults to `digits = 3` and prints the computed maximum; accepts an optional first arg to override.
