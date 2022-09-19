package Qiu.DIDI;

import java.util.Scanner;
/*
*第一行有三个正整数n,p,q(1<=n<=100000,1<=p,q<=n)，代表刷漆的次数，以及两个参数 p 和 q。

第二到四行给出了一个大小为3*n的矩阵，第 i 列的三个数从上到下记为l,r,t(1<=l,r<=1000000000,1<=t<=2)，
* 代表第i次刷漆将编号在 l 到 r 之间的栅栏刷了一遍 t号油漆。
in:
5 2 2
1 1 2 3 2
3 5 4 5 4
1 2 1 1 2

out:3
* */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pOne = sc.nextInt();
        int qTwo = sc.nextInt();
        sc.nextLine();
        //差分数组
        int[] pCou = new int[1000000000+2];
        int[] qCou = new int[1000000000+2];
        int[][] arr = new int[3][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        for(int i=0;i<n;i++){
            int l = arr[0][i];
            int r = arr[1][i];
            if(arr[2][i]==1){ //刷p
                pCou[l]++;
                pCou[r+1]--;

            }else{
                qCou[l]++;
                qCou[r+1]--;
            }
        }
        //通过查分求计数
        int cou = 0;
        int s1 = 0;
        int s2 = 0;
        for(int i=1;i<=n;i++){
            s1+=pCou[i];
            s2+=qCou[i];
            if(s1>=pOne && s2>=qTwo ) cou++;
        }
        System.out.println(cou);
    }
}
