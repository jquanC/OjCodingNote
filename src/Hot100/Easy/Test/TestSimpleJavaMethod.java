package Hot100.Easy.Test;

import java.util.Arrays;

public class TestSimpleJavaMethod {
    public static void main(String args[]){
        /*int[] nums = {1,2,3};
        int[] numsL = Arrays.copyOfRange(nums,0,2);
        int[] numsR = Arrays.copyOfRange(nums,2,3);
        System.out.println(Arrays.toString(numsL));
        System.out.println(Arrays.toString(numsR));
*/
        int[] nums2 = {1,2};
        System.out.println(nums2.length);
        int[] nums2L = Arrays.copyOfRange(nums2,0,1);
        int[] nums2R = Arrays.copyOfRange(nums2,2,2);
        System.out.println(Arrays.toString(nums2L));
        System.out.println(Arrays.toString(nums2R));


    }
}
