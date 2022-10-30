package ACMmodel.TenCent.re221013;

public class Main4 {
    public static void main(String[] args) {

    }
    /**
     *
     在第i天，买一支/多支股票，总资产不变； 买一支还是多支，影响的是第i+1,i+2,...之后的收益
     第i天 现金m  持有x只股票
    状态定义： dp[i][j]: 第i天 持有j只股票**能拥有的最大现金额度**
    最终解： ans = Max{d[n-1][j]+j*num[n-1]}
     转移方程：dp[i][j] = max{dp[i-1][j], dp[i-1][j-1]-num[i],dp[i-1][j+1]+num[i]}
     边界条件：dp[0][1-j] = M-num[0]*j
     */
  /*  public int calMaxProfit(int[] nums,int m){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i*nums[0]<=m;i++){
            dp[0][i] = m-i*nums[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j*nums[i]<m;j++){

            }
        }

    }*/
}
