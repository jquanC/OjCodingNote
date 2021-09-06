package Hot100.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class So34AllSubset {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            List<Integer> oneAns = new ArrayList<>();
            if (i == 0) ans.add(new ArrayList<>(oneAns)); //空子集
            else if (i == nums.length) { //最大子集合
                for(int j=0;j<nums.length;j++) oneAns.add(nums[j]);

                ans.add(new ArrayList<>(oneAns));
            }else{
                //（n,k） k>=1 & k<n
                dfsWithCut(oneAns,ans,0,i,nums);

            }
        }
        return ans;

    }
    void dfsWithCut(List<Integer> oneAns,List<List<Integer>> ans,int step,int k,int[] nums){
        if(oneAns.size() == k ){
            ans.add(new ArrayList<>(oneAns));
            return;
        }
        if(step == nums.length) return ;
        if(oneAns.size()+nums.length-step<k) return; //截肢

        oneAns.add(nums[step]);
        dfsWithCut(oneAns,ans,step+1,k,nums);
        oneAns.remove(oneAns.size()-1);
        dfsWithCut(oneAns,ans,step+1,k,nums);

    }
}
