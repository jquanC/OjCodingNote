package SwordOf.dynamicPro;

import org.junit.Test;

public class UglyNum {
    public int nthUglyNumber(int n) {
       int [] dp = new int[n+1];
       dp[1]=1;
       //ptrI表示上一个还未使用质因子I求新丑数的下标
       int ptr2=1, ptr3=1,ptr5=1;
       for(int i=2;i<=n;i++){
           dp[i] = minOf3(dp[ptr2]*2,dp[ptr3]*2,dp[ptr5]*5);
           if(dp[i]==dp[ptr2]*2) ptr2++;
           if(dp[i]==dp[ptr3]*3) ptr3++;
           if(dp[i]==dp[ptr5]*5) ptr5++;
       }
       return dp[n];

    }
    private int minOf3(int a,int b, int c){
        return Math.min(Math.min(a,b),c);
    }



}
