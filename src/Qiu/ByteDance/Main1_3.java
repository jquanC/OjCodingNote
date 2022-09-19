package Qiu.ByteDance;



import java.util.Scanner;

public class Main1_3 {
//    static int curAns=0;
//    static int ans = 0;
    static int [][] f = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M= sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[N][M];
        f = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = sc.nextInt();
                f[i][j] = -1;
            }
            sc.nextLine();
        }


        int ans = 0;
        for(int j=0;j<M;j++){
            f[0][j]=calBest(grid,0,j);
            ans = Math.max(ans,f[0][j]);
        }
        System.out.println(ans);

    }
    public static int calBest(int[][] grid,int x,int y){
        int N = grid.length;
        int M = grid[0].length;
        if(x>=0&&x<N && y>=0 && y<M && f[x][y]!=-1){
            return f[x][y];
        }
        if(y<0 || y>=M) return -0x3f3f3f3f;

        //到底部了
        if(x == N){
//            System.out.println("x==n");
//            if(sum>ans) ans = sum;
            return 0;
        }
        if(grid[x][y]==-1){
            f[x][y] =  Math.max(calBest(grid,x+1,y-1),calBest(grid,x+1,y+1)) ;
            return f[x][y];

        }else if(grid[x][y]==0){
            f[x][y] = calBest(grid,x+1,y);
            return f[x][y];
        }else{
            f[x][y] =  grid[x][y]+calBest(grid,x+1,y);
            return f[x][y];
        }

    }
}
