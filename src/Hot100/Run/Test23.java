package Hot100.Run;

import Hot100.Medium.So23InsertIntervals;

import java.util.Arrays;

public class Test23 {
    public static void main(String args[]) {
        So23InsertIntervals so = new So23InsertIntervals();
        int[][] nums = new int[][]{{1, 3}, {6, 9}};
        int[] newIntervals = new int[]{2, 5};

        int[][] ans = so.insert(nums, newIntervals);
        for (int[] e : ans
        ) {
            System.out.println(Arrays.toString(e));
        }
    }
}
