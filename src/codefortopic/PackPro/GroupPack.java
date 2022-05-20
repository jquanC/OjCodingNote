package codefortopic.PackPro;

import java.util.Scanner;

/**分组背包问题 ： 01 背包  每组有多个物品，每组可以取一个*/
public class GroupPack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        sc.nextLine();
        int[][][] arr = new int[N+1][][];
        for(int i=1;i<=N;i++){
            int aGroupNum = sc.nextInt();
            sc.nextLine();
            arr[i] = new int[aGroupNum+1][2];
            for(int j=1;j<=aGroupNum;j++){
                arr[i][j][0] = sc.nextInt();
                arr[i][j][1] = sc.nextInt();
            }
            if(i!=N) sc.nextLine();
        }
        int[] F = new int [V+1];
        for(int i=1;i<=N;i++){
            for(int j=V;j>=1;j--){

                for(int t=1;t<arr[i].length;t++){ // < 不是 <= 哦
                    if(j>=arr[i][t][0])
                    F[j] = Math.max(F[j],F[j-arr[i][t][0]]+arr[i][t][1]);
                }
            }
        }
        System.out.println(F[V]);
    }
}
