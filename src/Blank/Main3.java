package Blank;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        int upMax = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > 0) upMax += nums[i];
        }
        sc.nextLine();
        int rLenBound = nums.length / 2;
        int rlen = 2;
        int ans = Integer.MIN_VALUE;
        while (rlen <= rLenBound) {

            //i 枚举区间起点
            for (int i = 0; i + rlen < nums.length; i++) {
                int start = i;
                int end = i + rlen - 1;
                int[] tnums = Arrays.copyOf(nums, nums.length);
                while (start < end) {
                    int tem = tnums[end];
                    tnums[end] = tnums[start];
                    tnums[start] = tem;
                    start++;
                    end--;
                }
                int t = calMaxSumOfSubArr(tnums);
                if (t > ans) ans = t;
                if (ans == upMax) {
                    System.out.println(ans);
                    return;
                }

            }
            rlen++;
        }
        System.out.println(ans);

    }

    public static int calMaxSumOfSubArr(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) dp[i] = nums[i];
            else dp[i] = dp[i - 1] + nums[i];

            if (dp[i] > max) max = dp[i];
        }
        return max;
    }



}