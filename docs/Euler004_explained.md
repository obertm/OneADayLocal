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

## Real-world patterns and business impact

- Search with symmetry and pruning
  - Mirror-based candidate generation (palindromes) is a symmetry trick. Similar ideas apply to SKU codes, checksums, and ID formats with constraints.
  - Impact: Faster candidate generation → less compute, quicker answers.

- Bounded optimization on discrete grids
  - Many problems are “best product/sum over a rectangle of integers.”
  - Impact: The prune-on-upper-bound pattern generalizes to cost savings on combinatorial searches.

## Key takeaways
- Start with nested loops + a fast property check.
- Use descending order + upper-bound pruning to cut the search space.
- Consider generating candidates directly using symmetry.
