package SwordOf.math;

import org.junit.Test;

public class CountDigitOneII {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        char[] carr = s.toCharArray();
        int  k = carr.length;
        int cou = 0;
        for(int j=1;j<=k;j++){ //each for loop, cal k git 的1.比如依此求出个位的1个数， 十位的1个数，...

            if(j<=k-1)cou+= Math.pow(10,j-1);

            int i=j;
            while(i<=k-2){
                cou += 9 * Math.pow(10,i-1);
            }
            int t=1,tem=1;
            while(t<=k){
                if(t!=j){
                    if(t<k) tem *= (carr[k-t]-'0'+1);
                    else tem*= (carr[k-t]-'0');
                }
                t++;
            }
            cou +=tem;

        }
        return cou;
    }
    @Test
    public void test(){
        int n =12;
        int res = countDigitOne(n);
        System.out.println(res);
    }
}
