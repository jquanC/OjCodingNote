package Hot100.Run;

import Hot100.Medium.SoSumIsZero06;

public class Test06 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,-2,-1};
        SoSumIsZero06 so6 = new SoSumIsZero06();
        System.out.println(so6.threeSum(nums).toString());
    }
}
