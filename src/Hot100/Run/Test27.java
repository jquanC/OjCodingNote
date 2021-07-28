package Hot100.Run;

import Hot100.Medium.So27DiffPathII;

public class Test27 {
    public static void main(String args[]){
        So27DiffPathII so = new So27DiffPathII();
        //int[][] grid = new int[][]{{0}};
        //int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] grid = new int[][]{{0,0}};
        int ans = so.uniquePathsWithObstacles(grid);
        System.out.println(ans);
    }
}
