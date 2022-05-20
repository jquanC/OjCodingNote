package codefortopic.PackPro;

import java.util.Scanner;

/**有 N 种物品和一个容量是 V 的背包。

 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 输出最大价值。

 二进制优化算法  转为 01 背包问题*/

public class MultiPack02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V =sc.nextInt();
        int[][] arr = new int[12010][2];
        int cnt = 1;//计数转为 0 1背包的index
        for(int i=1;i<=N;i++){
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            for(int k=1;k<=s; k<<=1 ) { // k<<1 不对，要赋值
                arr[cnt][0] = k * v;//vi 体积
                arr[cnt][1] = k * w; //wi 价值
                s-=k; // 是 s-k ! 并且，为什么s-k 是正确的?因为 2^k 大于 2^0 +..+2^k-1 之和
                cnt++;
            }
            //s 恰好为0 也没关系，容许一些冗余状态
            arr[cnt][0] = s * v;//vi 体积
            arr[cnt][1] = s * w; //wi 价值
            cnt++;//注意这里要 cnt++
            if(i!=N) sc.nextLine();
        }
        int[] F = new int[V+1];

        System.out.println("cnt="+cnt);
        // 一维 0 1 背包
        for(int i=1;i<cnt;i++){
            for(int j=V;j>=arr[i][0];j--){
                F[j] = Math.max(F[j], F[j-arr[i][0]]+arr[i][1]);
            }
        }

        System.out.println(F[V]);
    }
}
