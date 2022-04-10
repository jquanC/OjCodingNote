package Others.PackPro;

import java.util.Scanner;

/*一维的dp*/
public class ZeroOne02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //物品数量
        int V= sc.nextInt();    //背包体积
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++){
            arr[i][0] = sc.nextInt();//vi 体积
            arr[i][1] = sc.nextInt(); //wi 价值
            if(i!=N) sc.nextLine();
        }

        //优化空间复杂度
        int[] F = new int[V+1];
        //不要求装满
        for(int i=0;i<=V;i++) F[i]=0;
    /*要求恰好装满
    for(int i=0;i<=V;i++){
        if(i==0) F[i]=0;
        else F[i] = min;
    }
    */
        for(int i=1;i<=N;i++){
            for(int j=V;j>=0;j--){ //记住需要V往下更新
                if(j >= arr[i][0]) F[j] = Math.max(F[j],F[j-arr[i][0]]+arr[i][1]);
                else F[j] = F[j];
            }
        }
        System.out.println(F[V]);

    }
}
