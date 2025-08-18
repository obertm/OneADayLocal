# Euler059 — XOR decryption

Decrypt a text encrypted with repeating-key XOR (lowercase 3-letter key) and return the sum of ASCII values of the decrypted text.

## Approach

- Read cipher bytes. For each key position 0..2, try 'a'..'z' and pick the key char that maximizes plausibility (e.g., frequency of spaces/letters) or brute-force all 26^3 keys.
- Validate by checking common words or character class distributions, then compute ASCII sum.

## Complexity
- O(26^3 × N) brute force; still tiny for provided input sizes.

## Real-world analogues and impact
- Simple cryptanalysis via n-gram/space heuristics.
  - Impact: Demonstrates effectiveness of statistical signals against weak ciphers.

## Takeaways
- Either per-position frequency or full brute-force; verify plaintext heuristically; then sum ASCII.


## Java implementation (Euler059.java)

- Class: `Euler059`
- Input: Expects `p059_cipher.txt` in the workspace; otherwise prints `DATA_FILE_NOT_FOUND` to match the dataset pattern used in other problems.
- Method: Brute-force lower-case 3-letter keys; XOR-decrypt; score plaintext by simple heuristic (spaces/letters punctuation) and pick best-scoring key; return the ASCII sum of best plaintext.
- Output: Sum as a string; or `DATA_FILE_NOT_FOUND` if the file is missing.
