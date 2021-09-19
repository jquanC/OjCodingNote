package Hot100.Medium.DP;
/*用动态规划做*/

public class TargetSum02 {
    public int findTargetSumWays(int[] nums,int target){

        int neg =0;
        int sum=0;
        for (int e:nums
             ) {
            sum+=e;
        }
        if(sum<target) return 0;
        if((sum-target)%2!=0) return  0 ;
        neg = (sum-target)/2;

        int[][] dp = new int[nums.length+1][neg+1];

        //初始化
        for(int j=0;j<=neg;j++){
            dp[0][j]= (j==0)? 1 : 0;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j = 0 ; j<=neg;j++){
                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
    return dp[nums.length][neg];
    }
}
