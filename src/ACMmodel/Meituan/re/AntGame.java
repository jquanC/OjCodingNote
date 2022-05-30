package ACMmodel.Meituan.re;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 树状dp
 */
public class AntGame {
    static int[] val;
    static ArrayList<Integer>[] edge;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n + 10][2];
        int[][] min = new int[n + 10][2];//取得dp状态解时，全部节点的最大的最小值； 存的是一个状态的节点最小值
        sc.nextLine();
        val = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextInt();
        }
        sc.nextLine();
        edge = new ArrayList[m + 10];
        for(int i=0;i<m+10;i++) edge[i] = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edge[x].add(y);
//            edge[y].add(x);
            sc.nextLine();
        }
        //父节点是0，表示cur 是树根节点
        dfs(1, 0, dp, min);

        //输出
        long ans1= 0, ans2 = 0;
        for(int i=1;i<=n;i++){
            ans1 = Math.max(ans1,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.print(ans1+" ");
        for(int i=1;i<=n;i++){
            if(ans1 == dp[i][0]) ans2 = Math.max(ans2,min[i][0]);
            if(ans1 == dp[i][1]) ans2 = Math.max(ans2,min[i][1]);
        }
        System.out.println(ans2);

    }

    public static void dfs(int cur, int father, int[][] dp, int[][] min) {
        //dp过程允许的一个初始化状态
        dp[cur][1] = val[cur];
        min[cur][1] = val[cur];
        dp[cur][0] = 0;
        min[cur][0] = 0x3f3f3f;//或者在外面统一初始化
        if(edge[cur].size()==0) return;
        //遍历当前层全部子节点
        for (int son :edge[cur]){
//            if(son == father) continue;// ？
            dfs(son,cur,dp,min);
            //选
            dp[cur][1] +=dp[son][0];
            min[cur][1] = Math.min(min[cur][1] , min[son][0]);
            //不选
            dp[cur][0] = Math.max(dp[son][1],dp[son][0]);
            if(dp[son][1]>dp[son][0]){
                min[cur][0] = Math.min(min[son][1],min[cur][0]);
            }else if(dp[son][1]<dp[son][0]){
                min[cur][0] = Math.min(min[son][0],min[cur][0]);
            }else{
                //min[][]需要初始化为很大；
                min[cur][0] = Math.min(min[cur][0],Math.max(min[son][0],min[son][1]));//为什么里面是max,根据提议我们想要最大的最小值
            }
        }
    }
}
