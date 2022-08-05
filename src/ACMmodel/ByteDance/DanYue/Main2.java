package ACMmodel.ByteDance.DanYue;

import java.util.Scanner;

/**这题的价值，也是难点在于，理解了不需要理会那些兵，理由：
 * 一个兵不会卡象腿的兵，永远不会卡象腿，吃它于不吃他没有区别
 * 一个兵卡象腿，用于也不发吃掉它
 * 根本原因：象棋智能走田，当当前x/y坐标是偶数，就一直是偶数，不能变奇数
 * */
/*
in:
3 3
1
2 2
1 1 3 3

out:
-1
*/
public class Main2 {

    public static int[][] dist = new int[][]{{2,2},{2,-2},{-2,2},{-2,-2}};
    public static int[][] vis;
    public static int row;
    public static int col;
    public static int[][] bin;
    public static int ans = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        vis = new int[row][col];
        sc.nextLine();
        int k = sc.nextInt();
        bin = new int[k][2];
        sc.nextLine();
        for(int i=0;i<k;i++){
            bin[i][0] = sc.nextInt();
            bin[i][1] = sc.nextInt();
            sc.nextLine();
        }
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int xt = sc.nextInt();
        int yt = sc.nextInt();
        sc.nextLine();
        vis[x0-1][y0-1] = 1;
        dfs(x0-1,y0-1,xt-1,yt-1,0);
        System.out.println(ans);
    }
    public static void dfs(int x0, int y0, int xt, int yt, int step){
        if(x0 == xt && y0 == yt ){
            if(step<ans) ans = step;
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x0+dist[i][0];
            int ny = y0+dist[i][1];
            if(nx>=0 && nx<row && ny>=0 &&ny<col && canGo(x0,y0,nx,ny) && vis[nx][ny]==0 ){
                vis[nx][ny] = 1;
                dfs(nx,ny,xt,yt,step+1);
                vis[nx][ny] = 0;
            }
        }
    }
    public static boolean canGo(int x,int y,int nx,int ny){
        int mx = (x+nx)/2;
        int my = (y+ny)/2;
        for(int i=0;i<bin.length;i++){
            if(bin[i][0] == mx && bin[i][1]==my) return false;
        }
        return true;
    }
}
