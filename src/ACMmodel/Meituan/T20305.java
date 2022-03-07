package ACMmodel.Meituan;

import org.junit.Test;

import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * 题目大意：给出长度为n的数组，可以翻转任意一段，问翻转一段之后的数组最大子段和为多少
 * n < = 1 e 5 , − 1 e 3 < = a [ i ] < = 1 e 3 n<=1e5,-1e3<=a[i]<=1e3n<=1e5,−1e3<=a[i]<=1e3
 *
 * 思路：
 * 可翻转，即可以任意选择两个字段连接
 * 前后缀dp求解，唯一一个preMax,拼接及判断即可*/
public class T20305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int[] dp1 = new int[n];//以arr[i] 为结尾的最大连续子数组和
        dp1[0] = arr[0];
        int[] dp2 = new int[n];//以arr[i] 为起始的往后的最大连续子数组和
        dp2[n-1] = arr[n-1];
        int[] preMax = new int[n];//表示以 i 为界，[0,i]中最大的连续字数组和
        preMax[0] = dp1[0];
        int maxPre = preMax[0];
        for(int i=1;i<n;i++){
            dp1[i] = dp1[i-1]>0 ? (dp1[i-1]+arr[i]) : arr[i];
            preMax[i] = Math.max(maxPre,dp1[i]);
            maxPre = preMax[i];
        }
        for(int i=n-2;i>=0;i--){
            dp2[i] = dp2[i+1]>0 ? (dp2[i+1]+arr[i]):arr[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            ans = Math.max(ans,preMax[i]+dp2[i+1]);
        }
        System.out.println(ans);
    }

}
/**test
 * 5
 * 1 2 3 4 5 ans:15
 * 7
 * -1 -2 3 5 -2 -4 4  ans:12
 * 8
 * 2 1 -3 2 -3 1 1 5   ans:10
 * */
