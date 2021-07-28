package Hot100.Medium;

//

public class So27DiffPathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid==null||obstacleGrid.length==0) return 0;

        int xBoundary = obstacleGrid.length;
        int yBoundary = obstacleGrid[0].length;
        int [][] dpsGrid = new int[xBoundary][yBoundary];
        //dpsGrid[i][j] means the num of ways from (i,j) to (xBoundary,yBoundary)

        for(int i = xBoundary-1; i>=0;i--){
           if(obstacleGrid[i][yBoundary-1] == 1) break;
           else dpsGrid[i][yBoundary-1] = 1;
        }

        for(int j = yBoundary-1; j>=0;j--){
            if(obstacleGrid[xBoundary-1][j] == 1) break;
            else dpsGrid[xBoundary-1][j] = 1;
        }

        for(int i = xBoundary-2;i>=0;i--){
            for(int j=yBoundary-2;j>=0;j--){
                if(obstacleGrid[i][j]==1) continue;//障碍物不填,为0
                else{
                    dpsGrid[i][j]= (obstacleGrid[i+1][j]==1 ? 0: dpsGrid[i+1][j]) + (obstacleGrid[i][j+1]==1 ? 0 : dpsGrid[i][j+1]);
                }

            }
        }
        return dpsGrid[0][0];
    }


}
