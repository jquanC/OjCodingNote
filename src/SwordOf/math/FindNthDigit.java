package SwordOf.math;

import org.junit.Test;

public class FindNthDigit {
    public int findNthDigit(int n) {
        int k=1,record = n;
        int resNum=0,resDigit = 0;


        while(Math.pow(10,k)*k<=n){
             n-=(Math.pow(10,k)- (k-1==0?0:Math.pow(10,k-1)))*k;
            k++;
        }
        int couDigit = n%k;
        int couNum = n/k;
        int base = k==1?0:(int)Math.pow(10,k-1);
        resNum = base+couNum;
        String resNumStr = String.valueOf(resNum);
        resDigit = resNumStr.charAt(couDigit)-'0';
        return resDigit;
    }
    @Test
    public void test(){
        int n=1000;
        int res = findNthDigit(n);
        System.out.println(res);
    }
}
