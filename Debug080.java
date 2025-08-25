import java.math.BigDecimal;import java.math.MathContext;import java.math.RoundingMode;import java.math.BigInteger;public class Debug080 {
    public static void main(String[] args) {
        for (int n=2;n<=15;n++) {
            int r=(int)Math.sqrt(n); if (r*r==n) continue;
            int sumAlgo = Euler080_digitSum(n);
            int sumAlgo101 = Euler080_digitSum101(n);
            int sumBD = bigDecimalSum(n);
            System.out.println("n="+n+" algo100="+sumAlgo+" algo101="+sumAlgo101+" bigDec100="+sumBD);
        }
        int totalAlgo100=0,totalAlgo101=0,totalBD=0,totalFrac100=0;
        for(int n=1;n<=100;n++){
            int r=(int)Math.sqrt(n); if(r*r==n) continue;
            totalAlgo100+=Euler080_digitSum(n);
            totalAlgo101+=Euler080_digitSum101(n);
            totalBD+=bigDecimalSum(n);
            totalFrac100+=fractional100(n);
        }
        System.out.println("TOTAL algo100="+totalAlgo100+" algo101="+totalAlgo101+" bigDec100="+totalBD+" frac100Only="+totalFrac100);
    }
    static int Euler080_digitSum(int n){ // replicate current 100-digit method
        String s = Integer.toString(n);
        if ((s.length() & 1) == 1) s = "0" + s;
        int pairIndex=0;BigInteger rem=BigInteger.ZERO, root=BigInteger.ZERO;int sum=0;
        for(int produced=0;produced<100;produced++){
            int pair; if (pairIndex < s.length()){pair=Integer.parseInt(s.substring(pairIndex,pairIndex+2));pairIndex+=2;} else pair=0;
            rem=rem.multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(pair));
            BigInteger base = root.multiply(BigInteger.valueOf(20));
            int x=0; while(x<9){BigInteger test = base.add(BigInteger.valueOf(x+1)).multiply(BigInteger.valueOf(x+1)); if(test.compareTo(rem)>0) break; x++;}
            rem=rem.subtract(base.add(BigInteger.valueOf(x)).multiply(BigInteger.valueOf(x)));
            root=root.multiply(BigInteger.TEN).add(BigInteger.valueOf(x));
            sum+=x;
        }
        return sum;
    }
    static int Euler080_digitSum101(int n){
        String s = Integer.toString(n); if ((s.length() & 1)==1) s="0"+s; int pairIndex=0;BigInteger rem=BigInteger.ZERO,root=BigInteger.ZERO;int sum=0;for(int produced=0;produced<101;produced++){int pair; if(pairIndex<s.length()){pair=Integer.parseInt(s.substring(pairIndex,pairIndex+2));pairIndex+=2;} else pair=0; rem=rem.multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(pair)); BigInteger base=root.multiply(BigInteger.valueOf(20)); int x=0; while(x<9){BigInteger test=base.add(BigInteger.valueOf(x+1)).multiply(BigInteger.valueOf(x+1)); if(test.compareTo(rem)>0) break; x++;} rem=rem.subtract(base.add(BigInteger.valueOf(x)).multiply(BigInteger.valueOf(x))); root=root.multiply(BigInteger.TEN).add(BigInteger.valueOf(x)); sum+=x;} return sum;}
    static int bigDecimalSum(int n){ // integer part + first 99 fractional digits
        BigDecimal bd = new BigDecimal(n);
        MathContext mc = new MathContext(110, RoundingMode.DOWN);
        BigDecimal x = new BigDecimal(Math.sqrt(n)); // seed
        // Newton refine
        for(int i=0;i<20;i++){
            x = x.add(bd.divide(x, mc)).divide(BigDecimal.valueOf(2), mc);
        }
        String digits = x.toPlainString().replace(".", "");
        if(digits.length()<100) digits = digits + "0".repeat(100-digits.length());
        return digits.substring(0,100).chars().map(c->c-'0').sum();
    }
    static int fractional100(int n){ // first 100 fractional digits only
        BigDecimal bd = new BigDecimal(n);
        MathContext mc = new MathContext(120, RoundingMode.DOWN);
        BigDecimal x = new BigDecimal(Math.sqrt(n));
        for(int i=0;i<25;i++) x = x.add(bd.divide(x, mc)).divide(BigDecimal.valueOf(2), mc);
        String s = x.toPlainString();
        int dot = s.indexOf('.');
        String frac = s.substring(dot+1);
        if(frac.length()<100) frac = frac + "0".repeat(100-frac.length());
        frac = frac.substring(0,100);
        return frac.chars().map(c->c-'0').sum();
    }
}
