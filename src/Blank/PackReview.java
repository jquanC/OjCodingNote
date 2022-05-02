package Blank;

import java.util.Scanner;

public class PackReview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//组号
        int V = sc.nextInt();
        sc.nextLine();
        int[][] goodsW = new int[N + 1][];
        int[][] goodsV = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            int total = sc.nextInt();
            sc.nextLine();
            goodsW[i] = new int[total + 1];
            goodsV[i] = new int[total + 1];
            for (int j = 1; j <= total; j++) {
                goodsV[i][j] = sc.nextInt();
                goodsW[i][j] = sc.nextInt();
                if (i != N && j != total) sc.nextLine();
            }
        }
        int[] F = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            for (int t = V; t >= 1; t--) {
                for (int j = 1; j <= goodsV[i].length - 1; j++) {
                    if(t>=goodsV[i][j])
                    F[t] = Math.max(F[t], F[t - goodsV[i][j]] + goodsW[i][j]);

                }
            }

        }
        System.out.println(F[V]);
    }
}
