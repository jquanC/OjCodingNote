package Others.PackPro;

import java.util.Scanner;

/**有 N 种物品和一个容量是 V 的背包。

 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 输出最大价值。

 朴素解法， 和朴素完全背包问题一样，注意物品数量上界 */
public class MultiPack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        int[][] arr = new int[N+1][3];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            arr[i][2] = sc.nextInt(); // si 数量
            if(i!=N) sc.nextLine();
        }
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){
                for(int k=0;k<=arr[i][2];k++){
                    if(j>=k*arr[i][0]) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*arr[i][0]]+k*arr[i][1]);
                }
            }
        }
        System.out.println(dp[N][V]);

    }
}
