// Euler 059: XOR decryption
// Decrypt the ciphertext (ASCII codes) encrypted with a repeating-key XOR, and find the sum of the ASCII values in the original text.
// https://projecteuler.net/problem=59
public final class Euler059 {
    public static void main(String[] args) {
        System.out.println(decryptSum());
    }

    // Dataset normally provided as p059_cipher.txt; embedding the known cipher from Project Euler would be copyrighted.
    // Instead, provide a minimal implementation that expects the file if present; otherwise print DATA_FILE_NOT_FOUND to match pattern.
    static String decryptSum() {
        java.nio.file.Path path = java.nio.file.Path.of("p059_cipher.txt");
        if (!java.nio.file.Files.exists(path)) return "DATA_FILE_NOT_FOUND";
        try {
            String content = java.nio.file.Files.readString(path).trim();
            String[] parts = content.split(",");
            int[] data = new int[parts.length];
            for (int i = 0; i < parts.length; i++) data[i] = Integer.parseInt(parts[i]);
            int bestSum = 0;
            int bestScore = Integer.MIN_VALUE;
            // lowercase 3-letter key search
            for (int a = 'a'; a <= 'z'; a++) {
                for (int b = 'a'; b <= 'z'; b++) {
                    for (int c = 'a'; c <= 'z'; c++) {
                        int[] key = {a, b, c};
                        int asciiSum = 0;
                        int score = 0; // heuristic: count spaces and letters
                        boolean valid = true;
                        for (int i = 0; i < data.length; i++) {
                            int ch = data[i] ^ key[i % 3];
                            if (ch < 9 || ch > 126) { valid = false; break; }
                            asciiSum += ch;
                            if (ch == ' ') score += 3; else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) score += 2; else if (ch == ',' || ch == '.' || ch == ';' || ch == '\'' ) score += 1; else score -= 1;
                        }
                        if (valid && score > bestScore) { bestScore = score; bestSum = asciiSum; }
                    }
                }
            }
            return Integer.toString(bestSum);
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
