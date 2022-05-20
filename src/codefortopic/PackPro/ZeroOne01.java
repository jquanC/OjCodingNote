package codefortopic.PackPro;

import java.util.Scanner;

/*二维的dp*/
public class ZeroOne01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //物品数量
        int V= sc.nextInt();    //背包体积
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            if(i!=N) sc.nextLine();
        }

        //dp[i][j]: 考虑0-i 个物品，背包容量为j 时的最大收益
        //dp[i][j]: dp[i][j] = max{dp[i-1][j],dp[i-1][j-ci]+wi}
        int[][] dp = new int[N+1][V+1];

        //非要求恰好装满背包的初始化：
        for(int j=0;j<=V;j++){
            dp[0][j] = 0; //考虑0件物品的状态
        }
        for(int i=0;i<=N;i++){
            dp[i][0] = 0; // 容量为0背包，最大收益始终是0
        }

        //**如果要求恰好装满背包的最大值；除了F[0] = 0; 其余F[1...V]均初始化为负无穷
        //二维的话 dp[i][0] = 0, i:0 to N ; dp[0][v] = min, v:1 to V
    /*
        for(int j=1;j<=V;j++){
            dp[0][j] = min;
        }
        for(int i=0;i<=N;i++){
            dp[i][0] = 0; // 容量为0背包，最大收益始终是0
        }
    */

        //dp 求解
        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){
                if(j>=arr[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][V]);


    }
}
