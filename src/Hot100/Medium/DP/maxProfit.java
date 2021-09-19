package Hot100.Medium.DP;

public class maxProfit {

    public int maxProfit(int[] nums) {
        int[][] f = new int[nums.length][3];
        f[0][0] = -nums[0];
        f[0][1] = 0;
        f[0][2] = 0;

        for (int i = 1; i < nums.length; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - nums[i]);
            f[i][1] = f[i - 1][0] + nums[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[nums.length-1][1],f[nums.length-1][2]);


    }
}
