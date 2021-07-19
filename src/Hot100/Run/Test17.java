package Hot100.Run;

import Hot100.Medium.soFullPermutation17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test17 {
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        soFullPermutation17 so = new soFullPermutation17();
        ans = so.permute(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
