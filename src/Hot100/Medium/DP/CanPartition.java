package Hot100.Medium.DP;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
/*//滚动数组优化空间=未完成
public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0, target = 0;
        for (int e :
                nums) {
            sum += e;
        }
        if (sum % 2 != 0) return false;
        else target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;


        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) dp[i][j] = dp[i - 1][j];
                else { //j>=nums[i] , nums[i]可选可不选
//                    选 || 不选
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];

                }
            }
        }
        return dp[nums.length - 1][target];
    }
}*/

//复杂度：时间：O(n*target) 空间：O(n*target)

public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0, target = 0;
        for (int e :
                nums) {
            sum+=e;
        }
        if(sum%2!=0) return false;
        else target = sum/2;

        boolean[][] dp = new boolean[nums.length][target+1];
        //初始化
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<=target;j++){
            if(nums[0] == j) dp[0][j] = true;
            else dp[0][j] = false;
        }


        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                if(nums[i]>j) dp[i][j] = dp[i-1][j];
                else{ //j>=nums[i] , nums[i]可选可不选
//                    选 || 不选
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];

                }
            }
        }
        return dp[nums.length-1][target];
    }
}
