package Hot100.Medium;
/*
*
* 64. 最小路径和
* 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
* */
public class So28MinPathSum {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] minDps = new int[m][n];

        //边界条件
        minDps[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            minDps[i][0] = minDps[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            minDps[0][j]= minDps[0][j-1] + grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                minDps[i][j] = Math.min(minDps[i-1][j],minDps[i][j-1])+grid[i][j];
            }
        }
        return minDps[m-1][n-1];
    }
}
