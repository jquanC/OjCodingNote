package codefortopic.PackPro;

import java.util.Scanner;

/** 混合背包问题 朴素解法 */
/*4 5
1 2 -1
2 4 1
3 4 0
4 5 2
out:8*/
public class MixPack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        int[][] arr = new int[N+1][3];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            arr[i][2] = sc.nextInt(); // si 数量： -1 表示0-1 ；0 表示无限 ；>0：表示该使用上限次数
            if(i!=N) sc.nextLine();
        }
        int [][] dp = new int[N+1][V+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){
                if(arr[i][2] == -1){
                    if(j>=arr[i][0]) dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                    else dp[i][j] = dp[i-1][j];

                }else if(arr[i][2]==0){
                    for(int k=0;k<=j/arr[i][0];k++){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*arr[i][0]]+k*arr[i][1]);
                    }
                }else{
                    for(int k=0;k<=arr[i][2];k++){
                        if(j>=k*arr[i][0])
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*arr[i][0]]+k*arr[i][1]);
                    }
                }
            }
        }
        System.out.println(dp[N][V]);

    }
}
