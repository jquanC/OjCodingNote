package ACMmodel.TenCent;

import java.util.Arrays;
import java.util.Scanner;

public class MainRedo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] prices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.nextLine();

        //dp[i][j]: 前i天结束，并持有j支股票的最大现金数
        int[][] dp = new int[n + 10][n + 10]; //假设资金充足，最多持有n+1支股票

        for (int i = 0; i <= n+1; i++) {
            for (int j = 0; j <= n+1; j++) {
                dp[i][j] = -0x3f3f3f3f;
            }
        }
        dp[0][0] = m;//唯一的合法起始状态；其它的状态都可以从这个状态正确的得到；
        for (int i = 1; i <= n; i++) {
            //每天的状态只可能来自3种子状态
            for (int j = 0; j <= n; j++) {
                //什么也不做
                dp[i][j] = dp[i - 1][j];
                //买入一手股票
                if (j >= 1 && dp[i - 1][j - 1] >= prices[i]) //prices[i]
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] - prices[i]);

                //卖出一手股票
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + prices[i]);
            }
        }
        long ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = Math.max(ans, dp[n][j] + j * prices[n]);
        }
        System.out.println(ans);
    }

}
