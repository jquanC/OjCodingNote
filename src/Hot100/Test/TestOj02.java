package Hot100.Test;

import org.junit.Test;

public class TestOj02 {
    public int maximalSquare(char[][] matrix) {
        if( matrix == null) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][]dp = new int[row][col];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]>ans) ans = dp[i][0];

        }
        for(int j=0;j<col;j++){
            dp[0][j] = matrix[0][j]-'0';
            if(dp[0][j]>ans) ans = dp[0][j];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j] == '0') dp[i][j]=0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    if(dp[i][j]>ans) ans = dp[i][j];
                }
            }
        }
        return ans*ans;

    }


}
