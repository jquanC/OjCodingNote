package Hot100.Medium.DP;

/*用回溯法做*/
public class TargetSum01 {
    public int cou = 0;


    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, 0,target);
        return cou;
    }

    private void backTrack(int[] nums, int index,int sum, int target) {

        if (index == nums.length){
            if(target == sum ){
                cou++;
            }
        }else{
            backTrack(nums,index+1,sum+nums[index],target);
            backTrack(nums,index+1,sum-nums[index],target);
        }
    }


}
