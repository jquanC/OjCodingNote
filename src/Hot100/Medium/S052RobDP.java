package Hot100.Medium;

import java.util.Map;

public class S052RobDP {
    //maxM[i] 表示搜索第i个房间，前 1~i个房间(对应数组下标0~ i-1)时的最佳偷窃解-->这样得到的似乎不是全部解；
    //maxM[i] 表示考虑 前 1~i个房间时最佳搜索策略得到的解；但我不知道i-1房间是有没有被搜，怎么写DP方程?可以写！
    /*
    * maxM[i] = max(maxM[i-1],maxM[i-2]+nums[i],maxM[i-3]);
    * */
   /* public int rob(int nums[]){
        int[] maxM = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0],nums[1]);
        if(nums.length ==3) return Math.max(nums[0]+nums[2],nums[1]);

        maxM[0]= nums[0];
        maxM[1] =Math.max(nums[0],nums[1]);
        maxM[2] = Math.max(nums[0]+nums[2],nums[1]);
        for(int i = 3;i<nums.length;i++){
            maxM[i] = Math.max(Math.max(maxM[i-2]+nums[i],maxM[i-3]+nums[i]),maxM[i-1] );
        }

        return maxM[nums.length-1];
    }*/

    public int rob(int nums[]){
        int[] maxM = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0],nums[1]);
        if(nums.length ==3) return Math.max(nums[0]+nums[2],nums[1]);

        int finalRes = Integer.MIN_VALUE;
        int preThirdRes = nums[0];
        int preTwoRes = Math.max(nums[0],nums[1]);
        int preOneRes = Math.max(nums[0]+nums[2],nums[1]);

        for(int i = 3;i<nums.length;i++){
            finalRes = Math.max(Math.max(preTwoRes+nums[i],preThirdRes+nums[i]),preOneRes );
            preThirdRes = preTwoRes;
            preTwoRes = preOneRes;
            preOneRes = finalRes;
        }
        return finalRes;
    }
}
