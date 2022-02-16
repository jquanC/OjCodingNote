package test.redo;

import org.junit.Test;

public class canDiveSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int e : nums){
            total   += e;
        }
        if(total %2 !=0) return false;


        boolean[][] dp = new boolean[nums.length][total/2+1];
        //初始化
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<=total/2;j++){
            if(nums[0] == j) dp[0][j] = true;
            else dp[0][j] = false;
        }

       for(int i=1;i<nums.length;i++){
           for(int j=1;j <= total/2; j++){ //j [1,total/2]
               if(nums[i]>j) dp[i][j] = dp[i-1][j];
               else{
                   dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
               }
           }
       }
       return dp[nums.length-1][total/2];


    }


    @Test
    public void test(){
        int[] nums = new int[]{1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
