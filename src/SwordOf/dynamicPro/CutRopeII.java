package SwordOf.dynamicPro;

public class CutRopeII {

    /**n:绳子长度*/
    /**
     * 最快解法，快速幂
     */
   /* public int cuttingRope(int n) {
        if (n <= 3) return n - 1;

        long rem = 1;
        long x = 3;
        int b = n % 3;
        int p = 1000000007;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int)((rem * 3) % p);
        if (b == 1) return (int)((rem * 4) % p);

        return (int)((rem * 6) % p);

    }*/


    /**n:绳子长度*/
    /** 快速幂解法2 */
    public int cuttingRope(int n) {
        if (n <= 3) return n-1;


        int b = n / 3;
        int p = 1000000007;

        long res=0;
        if (n % 3 == 0) {
            res = reminder(3, b, p);
        } else if(n%3 ==1){
            res = (4*reminder(3, b-1, p))%p;
        }else{
            res = (2*reminder(3, b, p))%p;
        }
        return (int)res;
    }

    private long reminder(int x, int a, int p) {

        if(a==0) return 1;
        if (a == 1) return x;
        long res = reminder(x, a / 2, p);
        if (a % 2 == 0) {
            res = (res*res) % p;
        } else {
            res = ((res * res)%p * x) % p;
        }
        return res;
    }


}
