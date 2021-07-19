package Hot100.Medium;

import java.lang.reflect.Array;
import java.time.zone.ZoneRulesException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoFullPermutationV218 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        int[] vs = new int[nums.length];
        Arrays.sort(nums);
        dfs2(nums, vs, oneRes, ans);
        return ans;
    }

    public void dfs2(int[] nums, int[] vs, List<Integer> oneRes, List<List<Integer>> ans) {
        if (oneRes.size() == nums.length) {

            ans.add(new ArrayList<>(oneRes));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (vs[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && vs[i - 1] == 1)) {
                    continue;
                }

                if (vs[i] == 0) {
                    vs[i] = 1;
                    oneRes.add(nums[i]);
                    dfs2(nums, vs, oneRes, ans);
                    oneRes.remove(oneRes.size() - 1);
                    vs[i] = 0;
                }

            }
        }

    }


    /*private void  dfs(int[] nums ,int[] vs, List<Integer>oneRes, List<List<Integer>> ans){
        if(oneRes.size()==nums.length){
            //查重
            for(int i=0;i<ans.size();i++){
                List<Integer> e = ans.get(i);
                if(compareTwoList(e, oneRes)){
                    return ;
                }
            }
            ans.add(new ArrayList<>(oneRes));
            return ;

        }else{
            for(int i=0; i<nums.length;i++){
                if(vs[i]==0){
                    vs[i] = 1;
                    oneRes.add(nums[i]);
                    dfs(nums,vs,oneRes,ans);
                    oneRes.remove(oneRes.size()-1);
                    vs[i]= 0 ;
                }
            }

        }


    }*/
   /* private boolean  compareTwoList(List<Integer> e1,List<Integer>e2){
        if(e1.size() != e2.size()) return false;
        else{
            for(int i=0;i<e1.size();i++){
                if(e1.get(i) != e2.get(i)) return false;
            }
        }
        return true;
    }*/

}
