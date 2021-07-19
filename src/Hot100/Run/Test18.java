package Hot100.Run;

import Hot100.Medium.SoFullPermutationV218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test18 {
    public static void main(String args[]){
        int[] nums = new int[]{1,1,2};
        SoFullPermutationV218 so = new SoFullPermutationV218();
        List<List<Integer>> ans = so.permuteUnique(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
