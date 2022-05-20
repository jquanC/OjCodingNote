package codefortopic.PackPro;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SchemeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        sc.nextLine();
        long[][] scheme = new long[N+1][V+1];
        long[][] best = new long[N+1][V+1];
        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int P = (int) (1e9+7);

        for(int i=1;i<=N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            if(i!=N)
            sc.nextLine();
        }
        //初始化一 算法一
        /*for(int i=0;i<=N;i++){
            scheme[i][0] = 1; //当v为0，不管考虑几件物品，best的解是什么都不选，所以scheme解为1
        }*/
       /* //初始化二 算法一
        scheme[0][0] = 1;*/


        //初始化三 算法二
        for(int j=0;j<=V;j++){
            scheme[0][j] = 1;
        }
        for(int i=0;i<=N;i++){ //当v为0，不管考虑几件物品，best的解是什么都不选，所以scheme解为1
            scheme[i][0] = 1;
        }

        for(int i=1;i<=N;i++){
            for(int j = 0; j<=V; j++){
                if(j>=v[i])
                    best[i][j] = Math.max(best[i-1][j],best[i-1][j-v[i]]+w[i]);
                else best[i][j] = best[i-1][j];

                scheme[i][j] = 0;
                if(best[i][j] == best[i-1][j]){
                    scheme[i][j] = scheme[i-1][j];
                }
                if(j>=v[i] && best[i][j] == best[i-1][j-v[i]]+w[i]){
                    scheme[i][j] += scheme[i-1][j-v[i]];
                }
                if(scheme[i][j]>=P) scheme[i][j] %= P;
            }
        }


        //算法一需要累加
     /*   long ans = 0;
        for(int j=0;j<=V;j++){ //枚举的是v， 而不能是物品件数
            if(best[N][j] == best[N][V]){
                ans += scheme[N][j];
                if(ans>P) ans %=P;
            }
        }
*/

        //算法一
//        System.out.println(ans);
        //算法二
        System.out.println(scheme[N][V]);
    }
}
