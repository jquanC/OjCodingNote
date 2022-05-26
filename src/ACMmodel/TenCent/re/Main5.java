package ACMmodel.TenCent.re;

import java.util.Scanner;
/**
 * 输入：n , m
 * 6 2
 * 2 3 1 1 1 2
 * 输出:
 * 6
 * */
public class Main5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  m =sc.nextInt();
        int[] price = new int[n+1];
        for(int i=1;i<=n;i++){
            price[i] = sc.nextInt();
        }
        int[][] dp = new int[n+10][n+10];

        for (int i = 0; i <= n+1; i++) {
            for (int j = 0; j <= n+1; j++) {
                dp[i][j] = -0x3f3f3f3f;
            }
        }

        dp[0][0] = m; //第i天持有j支股票的最大现金
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j] = dp[i-1][j];

                //买入一只股票
                if(j-1>=0 && dp[i-1][j-1]>=price[i]){   //&& 忽视了后面这个条件
                  dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]-price[i]) ;
                }
                //卖出一只股票
                if(j+1<=i-1){
                   dp[i][j] = Math.max(dp[i][j], dp[i-1][j+1]+price[i]);
                }
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int j=0;j<=n;j++){
            int cur = dp[n][j] + price[n]*j;
            if(cur>maxProfit) maxProfit = cur;
        }
        System.out.println(maxProfit);

    }
}
