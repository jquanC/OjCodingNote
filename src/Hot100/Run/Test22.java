package Hot100.Run;

import Hot100.Medium.So22MergeIntervals;

import java.util.Arrays;

public class Test22 {
    public static void main(String args[]){
        int[][] nums = new int[][]{ {15,18},{1,3},{8,10},{2,6}};
        So22MergeIntervals so22 = new So22MergeIntervals();
        int[][] ans = so22.merge(nums);
        System.out.println("return:");
        for (int[] e: ans
        ) {
            System.out.println(Arrays.toString(e));
        }
    }
}
