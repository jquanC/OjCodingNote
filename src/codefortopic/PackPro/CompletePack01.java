package codefortopic.PackPro;

import java.util.Scanner;

/** 完全背包问题：每件物品有无限件 二维朴素做法 */
public class CompletePack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            if(i!=N) sc.nextLine();
        }

        int[][] dp = new int[N+1][V+1];
        //初始化为0，都不用初始化了

        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){
                //该物品可能拿的件数
                for(int k=0;k<=j/arr[i][0];k++){
                    //体现的正是：F[i,v] = max{F[i-1,v-kCi]+kWi}
                    //Math.max 的右边包含了全部情况，Math.max左边相当于记录最优解
                  dp[i][j] =  Math.max(dp[i][j],dp[i-1][j-k*arr[i][0]]+k*arr[i][1]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
