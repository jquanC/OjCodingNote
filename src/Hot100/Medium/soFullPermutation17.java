package Hot100.Medium;

import java.util.ArrayList;
import java.util.List;

public class soFullPermutation17 {
    public List<List<Integer>> permute(int[] nums){
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> oneRes = new ArrayList<>();
       int[] vs = new int[nums.length];
       for(int i=0;i<vs.length;i++) vs[i]=0;
       dfs(nums,vs, oneRes, ans);
       return ans;

    }
    private void dfs(int[] nums , int[] vs, List<Integer> oneRes ,List<List<Integer>> ans){
        if(oneRes.size() == nums.length){
            ans.add(new ArrayList<Integer>(oneRes));
            return ;
        }
        for(int i =0;i<nums.length;i++){
            if(vs[i] == 0){
                vs[i] = 1;
                oneRes.add(nums[i]);
                dfs(nums,vs,oneRes,ans);
                vs[i]=0;
                oneRes.remove(oneRes.size()-1);
            }
        }
        return ;

    }
}
