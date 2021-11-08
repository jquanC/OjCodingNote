package SwordOf.dynamicPro;

import org.junit.Test;

public class Fib {

    public int fib(int n) {
        int[] fArr = new int[n+1];
        fibProcess(n,fArr);

        return fArr[n];
    }

    public int fibProcess(int n,int[] fArr) {
        int MOD = 1000000007;
        if (n == 0) return 0;
        if(n==1){
            fArr[n] = 1;
            return 1;
        }
        if(fArr[n]!=0) return fArr[n];

        fArr[n]= (fibProcess(n - 1,fArr) + fibProcess(n - 2,fArr))%MOD;//求解过程就要边MOD，否则会出错
        return fArr[n];
    }
    @Test
    public void test(){
        int mod1= (int)1e9;
        double mod2 = 1e9;
        System.out.println(mod1);
        System.out.println(mod2);
    }
}
