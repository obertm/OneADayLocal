// Euler 100: Arranged probability
// Find the number of blue discs such that the probability of taking two blue discs at random and without replacement is exactly 1/2, first exceeding 10^12 total discs.
// https://projecteuler.net/problem=100
public final class Euler100 {
    public static void main(String[] args) {
        java.math.BigInteger B = java.math.BigInteger.valueOf(15);
        java.math.BigInteger N = java.math.BigInteger.valueOf(21);
        java.math.BigInteger TWO = java.math.BigInteger.TWO;
        java.math.BigInteger THREE = java.math.BigInteger.valueOf(3);
        java.math.BigInteger FOUR = java.math.BigInteger.valueOf(4);
        java.math.BigInteger LIMIT = java.math.BigInteger.TEN.pow(12);
        while (N.compareTo(LIMIT) <= 0) {
            // Next solution
            java.math.BigInteger b2 = THREE.multiply(B).add(TWO.multiply(N)).subtract(TWO);
            java.math.BigInteger n2 = FOUR.multiply(B).add(THREE.multiply(N)).subtract(THREE);
            B = b2; N = n2;
        }
        System.out.println(B.toString());
    }
}
