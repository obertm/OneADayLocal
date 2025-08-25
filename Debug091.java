public class Debug091 {
    public static void main(String[] args) {
    int N=50; long brute=brute(N); long formula=current(N); long alt=altFormula(N); long naive = naiveFormula(N); long three = threeN2PlusSum(N); System.out.println("N="+N+" brute="+brute+" current="+formula+" alt="+alt+" naive="+naive+" threeN2Sum="+three);
    }
    static long brute(int N){ long cnt=0; for(int x1=0;x1<=N;x1++) for(int y1=0;y1<=N;y1++) for(int x2=0;x2<=N;x2++) for(int y2=0;y2<=N;y2++){ if(x1==0&&y1==0) continue; if(x2==0&&y2==0) continue; if(x1==x2&&y1==y2) continue; int ax=x1, ay=y1, bx=x2, by=y2; // origin is (0,0)
            int v1x=ax, v1y=ay, v2x=bx, v2y=by; if(v1x*v2x+v1y*v2y==0) cnt++; // right at origin
            int v3x=bx-ax, v3y=by-ay; if(v1x*v3x+v1y*v3y==0) cnt++; if(v2x*(-v3x)+v2y*(-v3y)==0) cnt++; }
        return cnt/2; }
    static long current(int N){ long total=1L*N*N; for(int x=1;x<=N;x++) for(int y=1;y<=N;y++){ int g=gcd(x,y); int dx=y/g, dy=x/g; int k1=Math.min(x/dx,(N-y)/dy); int k2=Math.min((N-x)/dx,y/dy); total+=k1+k2;} return total; }
    static long altFormula(int N){ long total=1L*N*N; for(int x=1;x<=N;x++) for(int y=1;y<=N;y++){ int g=gcd(x,y); long add=2L*Math.min( (long)(N-y)*g/x, (long)x*g/y ); total+=add;} return total; }
    static long naiveFormula(int N){ long total=1L*N*N; for(int x=1;x<=N;x++) for(int y=1;y<=N;y++){ int g=gcd(x,y); total+=2L*g; } return total; }
    static long threeN2PlusSum(int N){ long total=3L*N*N; long sum=0; for(int x=1;x<=N;x++) for(int y=1;y<=N;y++) sum+=gcd(x,y); return total+2*sum; }
    static int gcd(int a,int b){ while(b!=0){int t=a%b; a=b; b=t;} return a; }
}
