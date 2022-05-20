package codefortopic.PackPro;

import java.util.Scanner;

/**0 1 背包问题 除了容量， 增加了体积这一维度*/
public class TwoDPack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int M = sc.nextInt();

        int [][] F = new int[V+1][M+1];
        int[] v_arr = new int[N+1];
        int[] m_arr = new int[N+1];
        int[] w_arr = new int[N+1];
        for(int i=1;i<=N;i++){
            v_arr[i] = sc.nextInt();
            m_arr[i] = sc.nextInt();
            w_arr[i] = sc.nextInt();
        }
        for(int i=1;i<=N;i++){
            for(int j=V;j>=v_arr[i];j--){
                for(int t = M;t>=m_arr[i];t--){
                    F[j][t] = Math.max(F[j][t],F[j-v_arr[i]][t-m_arr[i]]+w_arr[i]);
                }
            }
        }
        System.out.println(F[V][M]);
    }
}
