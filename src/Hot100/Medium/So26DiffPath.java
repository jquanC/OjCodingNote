package Hot100.Medium;

public class So26DiffPath {

    private int[][] ans;
    //ans[i][j] 表示从 Grid[i][j] 走到 Grid[m-1][n-1] 的路径数；（只能往下或者往右走）
    //边界条件ans[m-1][*] = 1 Grid[*][n-1] = 1
    //填表


    public int uniquePaths(int m, int n) {
        ans = new int[m][n];
        for (int i = 0; i < m; i++) ans[i][n - 1] = 1;
        for (int j = 0; j < n; j++) ans[m - 1][j] = 1;

        //递归动态规划解法
        // return dps(0, 0);

        //循环动态规划
        for(int i = m-2;i>=0;i--){
            for(int j = n-2 ; j>=0 ; j--){
                ans[i][j] = ans[i+1][j]+ans[i][j+1];
            }
        }
        return ans[0][0];

    }
/*

    int dps(int x, int y) {
        if (ans[x][y] != 0) return ans[x][y];

        ans[x][y] = dps(x + 1, y) + dps(x, y + 1);
        return ans[x][y];
    }
*/


}
