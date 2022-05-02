/*
package ACMmodel.TenCentOld.wh2021;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] ans = new int[T];
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            UnionFind uf = new UnionFind();
            int n = sc.nextInt();
            sc.nextLine();
            for (int t = 0; t < n; t++) {
                uf.union(sc.nextInt(), sc.nextInt());
                sc.nextLine();
            }
            ans[i] = uf.calMaxQNum();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(ans[i]);
        }
    }
}

class UnionFind {
    HashMap<Integer, Integer> core;

    public UnionFind() {
        core = new HashMap<>();
    }

    public void union(int x, int y) {
        if (core.containsKey(x) == false && core.containsKey(y)==false) {
            core.put(x, 0);
            core.put(y, x);
        } else if (core.containsKey(x) == true && core.containsKey(y) == false) {
            int leader = find(x);
            core.put(y, leader);
        } else if (core.containsKey(x) == false && core.containsKey(y) == true) {
            int leader = find(y);
            core.put(x, leader);
        } else {
            core.put(find(x), find(y));
        }
    }

    public int find(int x) {
        int leader = core.get(x);
        if (leader == 0) return x;
        else {
            leader = find(leader);
            core.put(x, leader);
            return leader;
        }
    }

    public int calMaxQNum() {
        HashMap<Integer, Integer> cal = new HashMap<>();//leader , num
        for (int e : core.keySet()) {
            int ql = find(e);
            cal.put(ql, cal.getOrDefault(ql, 0) + 1);
        }
        int max = 0;
        for (int t : cal.keySet()) {
            int val = cal.get(t);
            if (val > max) max = val;
        }
        return max;
    }
}
*/
