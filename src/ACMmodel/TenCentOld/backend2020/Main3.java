package ACMmodel.TenCentOld.backend2020;


import java.util.Arrays;
import java.util.Scanner;

/**垃圾做法
 * 多状态动态规划*/
public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        sc.nextLine();
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextInt();
        }
        sc.nextLine();
        int[] chose = new int[n];//1 休息 2工作 3 健身房
        int ans = dfs(0, n, chose, w, g);
        System.out.println(ans);
    }

    public static int dfs(int step, int n, int[] chose, int[] w, int[] g) {
        if (step == n) return 0;

        int ans1 = 0x3f3f3f3f;
        int ans2 = 0x3f3f3f3f;
        int ans3 = 0x3f3f3f3f;
        if (w[step] == 1 && g[step] == 1) {
            if (step == 0 || chose[step - 1] != 2) {//工作
                chose[step] = 2;
                ans1 = dfs(step + 1, n, chose, w, g);
            }
            if (step == 0 || chose[step - 1] != 3) {//健身
                chose[step] = 3;
                ans2 = dfs(step + 1, n, chose, w, g);
            }
            chose[step] = 1;
            ans3 = 1 + dfs(step + 1, n, chose, w, g);

            return Math.min(Math.min(ans1, ans2), ans3);
        }
        if (w[step] == 1 && g[step] == 0) {
            if (step > 0 && chose[step - 1] == 2) { //前一天工作了
                chose[step] = 1;//休息
                return 1 + dfs(step + 1, n, chose, w, g);
            } else {
                chose[step] = 1;
                ans1 = 1 + dfs(step + 1, n, chose, w, g);
                chose[step] = 2;
                ans2 = dfs(step + 1, n, chose, w, g);
                return Math.min(ans1, ans2);
            }
        }
        if (w[step] == 0 && g[step] == 1) {
            if (step > 0 && chose[step - 1] == 3) {
                chose[step] = 1;//休息
                return 1 + dfs(step + 1, n, chose, w, g);
            } else {
                chose[step] = 1;
                ans1 = 1 + dfs(step + 1, n, chose, w, g);
                chose[step] = 3;
                ans2 = dfs(step + 1, n, chose, w, g);
                return Math.min(ans1, ans2);
            }

        }
//        if(w[step]==0 && g[step]==0){
        chose[step] = 1;
        return 1 + dfs(step + 1, n, chose, w, g);
//        }
    }
}
