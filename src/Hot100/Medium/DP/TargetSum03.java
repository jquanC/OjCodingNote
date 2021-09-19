package Hot100.Medium.DP;

/*动态规划-滚动数组优化空间*/
public class TargetSum03 {
    public int findTargetSumWays(int[] nums,int target){
        int sum=0;
        int neg=0;

        for (int e:nums
             ) {
            sum+=e;
        }
        if(sum<target)  return  0 ;
        if((sum-target)%2!=0) return 0;

        neg = (sum-target)/2;
        int[] dp = new int[neg+1];
        dp[0]=1;//i=0,j=0,解是1，表示不考率任何数，要求的目标是neg为0 时的情况

        for(int i=1;i<=nums.length;i++){
            int num = nums[i-1];
            for(int j=neg;j>=0;j--){
                if(num>j) dp[j] = dp[j];
                else{
                    dp[j] = dp[j]+dp[j-num];
                }
            }
        }
        return dp[neg];

    }
}
