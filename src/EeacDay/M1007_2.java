package EeacDay;

public class M1007_2 {
    public static void main(String[] args) {
        M1007_2 so  = new M1007_2();
        int[] a  = new int[]{1};
        int ans = so.findTargetSumWays(a,1);
        System.out.println(ans);

    }

        public static int ans = 0;
        public static int[] postSum = null;
        public int findTargetSumWays(int[] nums, int target) {
            postSum = new int[nums.length];
            for(int i=nums.length-1;i>=0;i--){
                if(i==nums.length-1) postSum[i] = nums[i];
                else{
                    postSum[i] = postSum[i] + postSum[i+1];
                }
            }
            cal(nums,0,0,target);
            return (int) ans;

        }
        public void cal(int[] nums,int step,int curSum,int target){
            if(step == nums.length ){
                if(target == curSum) ans++;
                return ;
            }
            //截枝条件
            if(curSum + postSum[step]< target && curSum - postSum[step]>target) return;
            cal(nums,step+1,curSum+nums[step],target);
            cal(nums,step+1,curSum-nums[step],target);
        }

}
