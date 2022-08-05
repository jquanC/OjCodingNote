package EeacDay;

public class M0801 {
    public static void main(String[] args) {
        M0801 so = new M0801();
        int[][] arr = new int[][]{{1,0}};
        int ans = so.uniquePathsWithObstacles(arr);
        System.out.println(ans);

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];
        boolean flag = false;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0 && !flag){
                ans[i][0] = 1;
            }else{
                ans[i][0] = 0;
                flag = true;
            }
        }
        flag = false;
        for(int j=0;j<n;j++){

            if(obstacleGrid[0][j]==0 && !flag){
                ans[0][j] = 1;
            }else{
                ans[0][j] = 0;
                flag = true;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    ans[i][j] = 0;
                    continue;
                }
                ans[i][j] = ans[i-1][j] + ans[i][j-1];
            }
        }
        return ans[m-1][n-1];

    }

}
