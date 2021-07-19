package Hot100.Run;

import Hot100.Medium.SoCombinedNumofTarget16;

import java.util.ArrayList;
import java.util.List;

public class Test16 {
    public static void main(String args[]){
        int [] nums = new int[]{3,2,5};
        int target = 8;
        SoCombinedNumofTarget16 so16 = new SoCombinedNumofTarget16();
        List<List<Integer>> ans = new ArrayList<>();
        ans = so16.combinationSum(nums,target);
        System.out.println(ans);


    }
}
