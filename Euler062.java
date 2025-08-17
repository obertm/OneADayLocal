// Euler 062: Cubic permutations
// Find the smallest cube for which exactly five permutations of its digits are also cubes.
// https://projecteuler.net/problem=62
public final class Euler062 {
    public static void main(String[] args) {
        System.out.println(findSmallestCube());
    }

    static long findSmallestCube() {
        java.util.Map<String, java.util.List<Long>> map = new java.util.HashMap<>();
        for (long n = 1; ; n++) {
            long cube = n * n * n;
            String sig = signature(cube);
            map.computeIfAbsent(sig, k -> new java.util.ArrayList<>()).add(cube);
            java.util.List<Long> list = map.get(sig);
            if (list.size() == 5) {
                return list.stream().min(Long::compare).get();
            }
        }
    }

    private static String signature(long x) {
        char[] a = Long.toString(x).toCharArray();
        java.util.Arrays.sort(a);
        return new String(a);
    }
}
