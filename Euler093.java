// Euler 093: Arithmetic expressions
// Using four distinct digits, find the set that produces the longest set of consecutive positive integers via arithmetic operations.
// https://projecteuler.net/problem=93
public final class Euler093 {
    public static void main(String[] args) {
        String bestKey = null;
        int bestLen = -1;
        int[] digits = new int[4];
        for (int a = 0; a <= 6; a++) {
            for (int b = a + 1; b <= 7; b++) {
                for (int c = b + 1; c <= 8; c++) {
                    for (int d = c + 1; d <= 9; d++) {
                        digits[0] = a; digits[1] = b; digits[2] = c; digits[3] = d;
            boolean[] seen = evalAll(digits);
                        int len = 0; while (len + 1 < seen.length && seen[len + 1]) len++;
            if (len > bestLen) { bestLen = len; bestKey = ""+a+b+c+d; }
                    }
                }
            }
        }
        System.out.println(bestKey);
    }

    private static boolean[] evalAll(int[] ds) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        int[] a = ds.clone();
        // Permute digits
        java.util.Arrays.sort(a);
        do {
            double A=a[0],B=a[1],C=a[2],D=a[3];
            // operators: 0:+,1:-,2:*,3:/
            for (int o1=0;o1<4;o1++) for (int o2=0;o2<4;o2++) for (int o3=0;o3<4;o3++) {
        // Parenthesizations (5 forms)
        addIfInt(set, ap(ap(op(A,B,o1), C, o2), D, o3));                    // ((A o1 B) o2 C) o3 D
        addIfInt(set, ap(ap(A, op(B,C,o2), o1), D, o3));                      // (A o1 (B o2 C)) o3 D
        addIfInt(set, ap(op(A,B,o1), op(C,D,o3), o2));                        // (A o1 B) o2 (C o3 D)
        addIfInt(set, ap(A, ap(op(B,C,o2), D, o3), o1));                      // A o1 ((B o2 C) o3 D)
        addIfInt(set, ap(A, ap(B, op(C,D,o3), o2), o1));                      // A o1 (B o2 (C o3 D))
            }
        } while (nextPerm(a));
        int max = 10000;
        boolean[] seen = new boolean[max];
        for (int v : set) if (v < max) seen[v] = true;
        return seen;
    }

    private static boolean nextPerm(int[] a) {
        int i=a.length-2; while(i>=0 && a[i]>=a[i+1]) i--; if(i<0) return false; int j=a.length-1; while(a[j]<=a[i]) j--; int t=a[i]; a[i]=a[j]; a[j]=t; for(int l=i+1,r=a.length-1;l<r;l++,r--){t=a[l];a[l]=a[r];a[r]=t;} return true;
    }
    private static Double op(double x,double y,int o){ if(o==0)return x+y; if(o==1)return x-y; if(o==2)return x*y; if(o==3){ if(y==0) return null; return x/y;} return null; }
    private static Double ap(Double x, Double y, int o){ if(x==null||y==null) return null; return op(x, y, o);}    
    private static void addIfInt(java.util.HashSet<Integer> set, Double v){ if(v==null) return; if(v>0 && Math.abs(v - Math.rint(v)) < 1e-9) set.add((int)Math.rint(v)); }
}
