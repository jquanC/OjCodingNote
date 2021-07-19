package Hot100.Medium;

public class So21JumpArray {
    private boolean res = false;
    private int[] vis;
    public boolean canJump( int[] nums){
        vis = new int[nums.length];
        dfsJump(0,nums,vis);
        return res;
    }
    private void dfsJump(int ipx ,int[]nums,int[] vis){
        vis[ipx] =1 ;
        if(ipx == nums.length-1 || nums[ipx]+ipx >= nums.length-1){
            res = true;
            return;
        }
        for(int jumpLen = nums[ipx];jumpLen>0;jumpLen--){
            if(vis[ipx+jumpLen] == 0){
                dfsJump(ipx+jumpLen,nums,vis);
            }

        }

    }
}
