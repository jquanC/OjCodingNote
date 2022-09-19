package Qiu.ByteDance;

import java.util.Scanner;

public class Main1_2 {
//    static int curAns=0;
//    static int ans = 0;
    static boolean [][] vis = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M= sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        vis = new boolean[N][M];
        int ans = 0;
        for(int j=0;j<M;j++){
            int curAns = calBest(grid,0,j);
            ans = Math.max(ans,curAns);
        }
        System.out.println(ans);

    }
    public static int calBest(int[][] grid,int x,int y){
        int N = grid.length;
        int M = grid[0].length;
        if(y<0 || y>=M) return -0x3f3f3f;

        //到底部了
        if(x == N){
            return 0;
        }

        if(vis[x][y]) return 0;//只需要返回 fen 越过边
        vis[x][y] = true;


        if(grid[x][y]==-1){
            int oneW =  calBest(grid,x+1,y-1);
            int twoW =  calBest(grid,x+1,y+1);
            return Math.max(oneW,twoW);
        }else if(grid[x][y]==0){
            return calBest(grid,x+1,y);
        }else{
           return grid[x][y]+ calBest(grid,x+1,y);
        }

    }
}
