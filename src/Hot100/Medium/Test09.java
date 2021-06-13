package Hot100.Medium;

import java.util.Arrays;
import java.util.List;

public class Test09 {
    public static void main(String args[]){
        SoFourNumSum09 so9 = new SoFourNumSum09();
        //int[] nums = new int[]{1,0,-1,0,-2,2};
        int[] nums = new int[]{2,2,2,2,2};
        List<List<Integer>> ansList =  so9.fourSum(nums,8);
        System.out.println(Arrays.toString(ansList.toArray()));
    }
}
