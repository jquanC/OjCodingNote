package EeacDay;

import java.util.ArrayList;
import java.util.List;

public class M0712 {
    public static void main(String[] args) {
        Solution220712 so = new Solution220712();
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}
        };
       int ans =  so.numIslands(grid);
        System.out.println(ans);
    }
}
class Solution220712 {

    int[] dr = new int[]{1,0,-1,0};
    int[] dc = new int[]{0,1,0,-1};
    int index =1;
    char[][] grid ;
    int rMax;
    int cMax;
    public int numIslands(char[][] grid) {
        this.grid  = grid;
        rMax = grid.length-1;
        cMax = grid[0].length-1;
        for(int i=0;i<=rMax;i++){
            for(int j=0;j<=cMax;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,++index);
                }
            }
        }
        return index-1;
    }
    public void dfs(int r,int c,int index){
        if(grid[r][c]!='1') return;

        grid[r][c] = (char)('0'+index);
        List<int[]> moves = neighbors(r,c);
        for(int[] m : moves){
            dfs(m[0],m[1],index);
        }
    }
    List<int[]> neighbors(int r , int c){
        List<int[] > moves = new ArrayList();
        for(int k=0;k<4;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];
            if(nr>=0 && nc >=0 && nr<=rMax && nc <=cMax ){
                moves.add(new int[]{nr,nc});
            }
        }
        return moves;
    }
}
