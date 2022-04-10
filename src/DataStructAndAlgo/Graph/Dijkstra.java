package DataStructAndAlgo.Graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_49688477/article/details/118681671
 * 输入样例： n个点m条边
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 */

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] edge = new int[n][n];
        int[] dis = new int[n];
        Arrays.fill(dis, 0x3f3f3f3f);
        //初始edge[][]也需要初始化
        for(int [] arr:edge) Arrays.fill(arr,0x3f3f3f3f);

        boolean[] state = new boolean[n];
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            if(from != to) edge[from - 1][to - 1] = w;//如果题目复杂点，加这个if可以减去无意义的自环
            sc.nextLine();
        }
        int ans = dijkstra(0, n - 1, edge, dis, state);
        System.out.println(ans);


    }

    public static int dijkstra(int s, int e, int[][] edge, int[] dis, boolean[] state) {
        //不管e点是谁，循环n次，求出以s为单源起点，到其它所有点的最短路径
        int n = dis.length;
        int cou = 1;
        //初始化
        dis[s] = 0;
        state[s] = true;//初始化S集合只有start点
        for(int j=0;j<n;j++){
            dis[j] = Math.min(dis[j], dis[0] + edge[0][j]);
        }

        while (cou < n) {
            //从U集中选择dis[t]最小的点加入S集合，我们不需要显式的写一个U集合
            int t = -1;//假设这个点是t

            for (int j = 0; j < n ; j++) {//state[j]==false 实现了我们枚举U集
                if (state[j]==false &&( t == -1 || dis[j] < dis[t])) {
                    t = j;
                }
            }
            state[t] = true;
            //更新 其它点的dis,注意dis的定义是其他点与源点的最短距离
            for (int j = 0; j < n ; j++) { //放宽松一点这里不要  state[j] == false 试试
                dis[j] = Math.min(dis[j], dis[t] + edge[t][j]);//初始化为0x3f3f3f3f就是为了避免这里溢出
            }
            cou++;
        }
        return dis[e] >= 0x3f3f3f3f ? -1 : dis[e];
    }
}
