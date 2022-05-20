package codefortopic.PackPro;

import java.util.Scanner;

/** 完全背包问题：每件物品有无限件  一维做法 */
public class CompletePack02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            if(i!=N) sc.nextLine();
        }

        int[] F = new int[V+1];
        //初始化为0，都不用初始化了

        for(int i=1;i<=N;i++){
            //理解此题解最重要的是理解：为什么v正向递增就可以
            //01背包一维，v递减是为了保证，每次状态更新是从拿了 1 件该物品来的，在完全背包问题，没有件数的限制
            for(int j=1;j<=V;j++){
                if(j-arr[i][0]>=0){
                    F[j] = Math.max(F[j],F[j-arr[i][0]]+arr[i][1]);
                }
            }
        }
        System.out.println(F[V]);
    }
}
