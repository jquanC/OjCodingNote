package Others.PackPro;

import java.util.Scanner;

/**
 * 混合背包问题  一维dp 解法
 */
public class MixPack03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] arr = new int[100000][3];
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            if (s == -1) {
                arr[cnt][0] = v;
                arr[cnt][1] = w;
                arr[cnt][2] = 1;//-1 改1 表示  01 背包
                cnt++;
            }
            if (s == 0) { // 0  完全背包
                arr[cnt][0] = v;
                arr[cnt][1] = w;
                arr[cnt][2] = 0;//0
                cnt++;
            }
            if (s > 0) { // >0 多重背包 要转 0 1 背包
                for (int k = 1; k <= s; k <<= 1) { // 乘以2 是<<1 , 不是<<2
                    arr[cnt][0] = v * k;
                    arr[cnt][1] = w * k;
                    arr[cnt][2] = 1;
                    s-=k;
                    cnt++;
                }
                if (s > 0) {
                    arr[cnt][0] = v*s;
                    arr[cnt][1] = w*s;
                    arr[cnt][2] = 1;
                    cnt++;
                }

            }

            if (i != N) sc.nextLine();
        }
        int[] F = new int[V + 1];

        for (int i = 1; i < cnt; i++) {
            // 0 1 pack
            if (arr[i][2] == 1) {
                for(int j=V;j>=1;j--){
                    if(j>=arr[i][0])
                    F[j] = Math.max(F[j],F[j-arr[i][0]]+arr[i][1]);

                }

            } else { // 完全pack

                for(int j=1;j<=V;j++){
                    if(j>=arr[i][0])
                    F[j] = Math.max(F[j],F[j-arr[i][0]]+arr[i][1]);

                }
            }
        }
        System.out.println(F[V]);

    }
}
