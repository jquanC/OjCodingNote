package Hot100.Medium.DP;

import org.junit.Test;

public class LongestSubsequence {
    //动态规划方法一
    /**
     * d[i]表示以nums[i]结尾的最长递增子序列的长度
     * d[i+1] = ？？？
     * */
 /*   public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        d[0]=1;
        int maxResult =1;
        for(int i =1;i<nums.length;i++) {
            d[i]=1;
            for(int j=0;j<i;j++){
               if(nums[i]>nums[j]){
                   d[i] =  Math.max(d[i],d[j]+1);
               }
            }
            if(d[i]>maxResult) maxResult = d[i];

        }
        return maxResult;

    }*/

    /**
     * dp[i] 表示长度为i的最长递增子序列的末尾元素
     * 根据定义，子序列是严格递增的，显然dp[i]是单调递增
     * 如果 nums[i]>dp[i-1], dp[i]=num[i];
     * 如果 nums[i]<dp[i-1], 在dp[]中 find nums[i]>dp[j],更新dp[j+1] = nums[i];贪心的维护长度为j+1的序列的末尾元素尽量小
     * 贪心的维护子序列的末尾元素尽量小，使得求最长递增子序列尽可能的长
     * */
    public int lengthOfLIS(int[] nums){
        int [] dp = new int[nums.length+1];
        dp[1] = nums[0];
        int len =1 ;
        for(int i=1;i<nums.length;i++){

            if(nums[i]>dp[len]){
                dp[++len] = nums[i];
            }else{
                int pos = 0;
                int l=1;
                int r=len;
                //二分查找：寻找第一个小于nums[i] 的dp[]位置pos
                while(l<=r){
                    int mid = (l+r)>>1;
                    if(dp[mid] < nums[i]){
                        pos = mid;//纪录一个pos , 但可能不是‘第一个’，搜索右区间(dp[]是单调递增的)
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }
                dp[pos+1] = nums[i];
            }

        }
        return len;

    }

    @Test
    public void test(){
        int[] nums = new int[]{ 3,5,6,2,5,4,19,5,6,7,12};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
