package Hot100.Medium.DP;

public class SoSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        //初始化
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
        }


        //求解 dp[][]
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0 ;
                    continue;
                }
                int subLen;
                if (dp[i - 1][j] == dp[i][j - 1]) {
                    subLen = dp[i - 1][j];
                    if (matrix[i - subLen][j - subLen] == '1') {
                        dp[i][j] = subLen + 1;
                    } else {
                        dp[i][j] = subLen;
                    }
                } else {
                    subLen = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = subLen + 1;
                }

            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] > res) res = dp[i][j];
            }
        }
        return res * res;

    }
}
