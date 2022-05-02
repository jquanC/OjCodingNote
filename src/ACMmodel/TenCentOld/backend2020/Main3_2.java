package ACMmodel.TenCentOld.backend2020;


import java.util.Scanner;

/**
 * 垃圾做法
 * 多状态动态规划
 */
public class Main3_2 {
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
        int[] dp_r = new int[n]; //第i天选择休息结束后，前i天最少需要休息天数
        int[] dp_w = new int[n];
        int[] dp_g = new int[n];
        dp_r[0] = 1;
        dp_w[0] = (w[0] == 1 ? 0 : 0x3f3f3f3f); //初始化是0
        dp_g[0] = (g[0] == 1 ? 0 : 0x3f3f3f3f);// 初始化是0 吗的

        for(int i=1;i<n;i++){
            dp_r[i] = Math.min(Math.min(dp_r[i-1],dp_w[i-1]),dp_g[i-1])+1;
            if(w[i]==1){
                dp_w[i] = Math.min(dp_g[i-1],dp_r[i-1]);
            }else dp_w[i] = 0x3f3f3f3f;

            if(g[i]==1){
                dp_g[i] = Math.min(dp_w[i-1],dp_r[i-1]);
            }else dp_g[i] = 0x3f3f3f3f;
        }
        System.out.println(Math.min(Math.min(dp_g[n-1],dp_r[n-1]),dp_w[n-1]));
    }

}
