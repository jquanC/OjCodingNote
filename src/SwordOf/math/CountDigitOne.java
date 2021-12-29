package SwordOf.math;

import org.junit.Test;

public class CountDigitOne {
    public int countDigitOne(int n) {
        int k = 0;
        int res = 0;

        while(Math.pow(10.0,k)<=n){
            res+=Math.floor(n/Math.pow(10,k+1))*Math.pow(10,k);
            res+=Math.min(Math.max(n%Math.pow(10.0,k+1)-Math.pow(10.0,k)+1,0),Math.pow(10.0,k));
            k++;
        }
//        res+=Math.min(Math.max(n%Math.pow(10.0,k+1)-Math.pow(10.0,k)+1,0),Math.pow(10.0,k));
        return res;

    }
    @Test
    public void test(){
        int n =12;
        int res = countDigitOne(n);
        System.out.println(res);
    }
}
