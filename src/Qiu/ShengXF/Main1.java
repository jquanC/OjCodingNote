package Qiu.ShengXF;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 so = new Main1();
    }
    public int ncov_defect (int[][] grid) {
        // write code here
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 || grid[i][j]==2) continue;
                setGrid(i,j,grid);
            }
        }
        int cou=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) cou++;
            }
        }
        return cou;

    }
    public void setGrid(int x,int y,int[][] grid){
        if(x-1>=0 && grid[x-1][y] == 1) grid[x][y] = 2;
        if(x+1<grid.length && grid[x+1][y] == 1) grid[x][y] = 2;
        if(y-1>=0 && grid[x][y-1] == 1) grid[x][y] = 2;
        if(y+1<grid[0].length && grid[x][y+1] == 1) grid[x][y] = 2;
    }
}
