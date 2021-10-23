package Hot100.Medium.Arrays;

public class SubarraySumSo1 {
    /**我的解
     * 这种解的思路， 可以优化到空间复杂度为 O(1)
     * 如果我们知道 [j,i]子数组的和，就能 O(1)推出 [j-1,i]的思想*/
   /* public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int res = nums[0]==k? 1 :0;

        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
            if(sum[i] == k) res++;
        }

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(sum[j]-sum[i]==k) res++;
            }
        }

        return res;
    }*/
    /**优化空间*/
    public int subarraySum(int[] nums, int k) {

       int res = 0;
        for(int i=0;i<nums.length;i++){
            int sumi2j = 0;
            for(int j=i;j<nums.length;j++){
                sumi2j += nums[j];
                if(sumi2j == k) res++;
            }

        }
        return res;
    }

}
