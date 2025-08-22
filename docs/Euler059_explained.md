# Euler059 — XOR decryption

Decrypt a text encrypted with repeating-key XOR (lowercase 3-letter key) and return the sum of ASCII values of the decrypted text.

## Approach

- Read cipher bytes. For each key position 0..2, try 'a'..'z' and pick the key char that maximizes plausibility (e.g., frequency of spaces/letters) or brute-force all 26^3 keys.
- Validate by checking common words or character class distributions, then compute ASCII sum.

## Edge Cases
- File availability: Missing data file should produce a deterministic fallback output; handle IO errors gracefully.
- Non-printable chars: Decrypted bytes outside printable ASCII strongly indicate wrong key; penalize in scoring.
- Space frequency heuristic bias: Ensure heuristic not overly tuned causing false positives; optional full brute force fallback.
- Key repetition alignment: Cipher length not multiple of key length; modulo index must wrap correctly.
- Case sensitivity: Limiting keys to lowercase is per problem; generalized solver might include uppercase or digits.
- Performance: 26^3 * N trivial; but if key length increased, switch to positional frequency approach.

## Complexity
- O(26^3 × N) brute force; still tiny for provided input sizes.

## Practical examples and business impact

- XOR decryption: brute-force key search with statistical validation for weak ciphers.
- Security education: teach how n-gram/space frequency breaks simple encryption.
- QA: test decryption routines with known-plaintext and brute-force keys.
- Data recovery: recover text from corrupted XORed files using frequency analysis.
- Simulation: model brute-force search space and success rates for short keys.
- Benchmarking: compare heuristic vs. full brute-force for key recovery.
- Embedded: implement lightweight XOR decryption for resource-limited devices.
- Analytics: measure distribution of decrypted ASCII values to flag likely plaintexts.
- Fuzzing: generate random keys and measure false-positive rates in statistical validation.
- Visualization: plot key/score heatmaps to show best candidate keys.

## Key Takeaways
- Either per-position frequency or full brute-force; verify plaintext heuristically; then sum ASCII.


## Java implementation (Euler059.java)

- Class: `Euler059`
- Input: Expects `p059_cipher.txt` in the workspace; otherwise prints `DATA_FILE_NOT_FOUND` to match the dataset pattern used in other problems.
- Method: Brute-force lower-case 3-letter keys; XOR-decrypt; score plaintext by simple heuristic (spaces/letters punctuation) and pick best-scoring key; return the ASCII sum of best plaintext.
- Output: Sum as a string; or `DATA_FILE_NOT_FOUND` if the file is missing.
