package ACMmodel.ByteDance.ShuanYue;
// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class JulyN4 {
    public static long minAns = 0x3f3f3f3f;
    public static boolean reach = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n + 1];
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.nextLine();
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            if (edges[x] == null) {
                edges[x] = new ArrayList<Integer>();
            }
            edges[x].add(y);
        }
        int target = sc.nextInt();
        sc.nextLine();
        dfs(1, 0, 0, edges, new HashSet<Integer>(), prices, target);
        //System.out.println(ans);
        if (reach) System.out.println(minAns);
        else System.out.println(-1);
    }

    public static void dfs(int cur, int feel, long cost, ArrayList<Integer>[] edges, HashSet<Integer> path, int[] prices, int target) {
        //重复进入判定
        if (path.contains(cur)) {
            //需要更新下记录
            if (feel >= target) {
                reach = true;
                if (cost < minAns) {
                    minAns = cost;
                }
            }

            return;
        }

        //会满意吗？
        if (edges[cur] == null) {
            //需要更新下记录
            if (feel >= target) {
                reach = true;
                if (cost < minAns) {
                    minAns = cost;
                }
            }
            return;
        }
        //对该直播间满意
        path.add(cur);
        feel++;
        cost += prices[cur];
        //
        if (feel >= target) {
            reach = true;
            if (cost < minAns) {
                minAns = cost;
            }
        }
        //
        for (int e : edges[cur]) {
            dfs(e, feel, cost, edges, path, prices, target);
        }
        feel--;
        cost -= prices[cur];
        path.remove(cur);

    }

}