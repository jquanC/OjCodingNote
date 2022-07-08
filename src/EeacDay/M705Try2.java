package EeacDay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class M705Try2 {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,0},{0,1}};
        int[][] grid = new int[][]{{1,0,1,0,1},{0,1,1,0,1},{1,1,1,0,0},{1,0,1,1,1},{0,0,1,1,0}};
        M705Try2 so = new M705Try2();
        int ans  = so.largestIsland(grid);
        System.out.println(ans);

    }

    int grid[][];
    int[] dr = new int[]{1,0,-1,0};
    int[] dc = new int[]{0,1,0,-1};
    int N;
    public int largestIsland(int[][] grid) {
        int ans = 0;
        this.grid = grid;
        N = grid.length;// Q: 如果grid不是正方形要怎么编码;一样，N取长/宽都行，都能保证一个坐标得到唯一编码，反正可以解码还原
        int index = 2;
        int[] area = new int[N*N+2];//为什么要加2？0，1 原来的grid都有含义，不用
        //求解不翻转下，原来grid每个联通块的面积，结果保存在area中，并在grid上把每个连通块标记为自己的编号
        for(int i=0;i<N;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    area[index] = dfs(i,j,index);
                    ans = Math.max(ans,area[index++]);
                }
            }
        }
        //求翻转情况下可能得到的最大值
        for(int i=0;i<N;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> seen = new HashSet<>();//保存翻转该格子可以连接的不同index域
                    for(int move : neighbors(i,j)){
                        int nr = move/N;
                        int nc = move%N;
                        if(!(nr<0||nc<0||nr>=N||nc>=N)){
                            seen.add(grid[nr][nc]);
                        }
                    }
                    int sum = 1;
                    for(int e:seen){
                        sum+=area[e];
                    }
                    ans = Math.max(ans,sum);
                }
            }
        }
        return ans;

    }
    /**
     * @param index 给当前所求联通块的编号*/
    public int dfs(int row,int col,int index){
        int ans = 0;
        //避免无限递归，不需要用set的原因在于，走过的格子已经标记为grid[][] = index
        if(grid[row][col]==1){
            ans = 1;
            grid[row][col] = index;
            for(int move : neighbors(row,col)){
                ans+=dfs(move/N,move%N,index);
            }
        }

        return ans;

    }
    public List<Integer> neighbors(int row,int col){
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            //一定要在编码地址之前，做有效性检查，而不是返回解码后再检查，否则会导致程序出错！！
            //e.g.grid[][]是5*5，返回一个无效地址(3,5)的编码 3*5+5+20;解码得到一个（4,0）是一个有效地址
            if(0<=nr && nr<N && 0<=nc  && nc<N)  ans.add(nr*N+nc);
        }
        return ans;
    }

}


