package Qiu.ByteDance;



import java.util.Scanner;

public class Main {
//    static int curAns=0;
    static int ans = 0;
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

        for(int j=0;j<M;j++){
            calBest(0,grid,0,j);
//            ans = Math.max(ans,curAns);
        }
        System.out.println(ans);

    }
    public static void calBest(int sum,int[][] grid,int x,int y){
        int N = grid.length;
        int M = grid[0].length;
        if(y<0 || y>=M) return ;

        //到底部了
        if(x == N){
//            System.out.println("x==n");
            if(sum>ans) ans = sum;
            return;
        }

        if(grid[x][y]==-1){
            calBest(sum,grid,x+1,y-1);
            calBest(sum,grid,x+1,y+1);
        }else if(grid[x][y]==0){
            calBest(sum,grid,x+1,y);
        }else{
            calBest(sum+grid[x][y],grid,x+1,y);
        }

    }
}
