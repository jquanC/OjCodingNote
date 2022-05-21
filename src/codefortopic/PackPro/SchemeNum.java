package codefortopic.PackPro;


import java.util.Scanner;


public class SchemeNum {
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        int modV = (int)1e9+7;

        long[] f = new long[K+1];
        f[0] = 1;

        for(int i=0;i<x;i++){
            for(int j=K;j>=a;j--){
                f[j] = (f[j] + f[j-a])%modV;
            }
        }
        for(int i=0;i<y;i++){
            for(int j=K;j>=b;j--){
                f[j] = (f[j]+f[j-b])%modV;
            }
        }
        System.out.println(f[K]);

    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        int modV = (int)1e9+7;

        //先计算杨辉三角
        long[][] C_mn = new long[105][105];//第m行n列的值（m，n从0开始）!!! 题目给了上界 ; 要是long， 不然就只过60%
//        for(int i=0;i<=x;i++) C_mn[i][0] = 1;

        C_mn[0][0] = 1;
        for(int i=1;i<105;i++){
            C_mn[i][0] = 1;
            for(int j=1;j<105;j++){
                C_mn[i][j] = (C_mn[i-1][j-1]+C_mn[i-1][j])%modV;
            }
        }
        long sum =0;
        for(int i=0;i<=x;i++){
            if( i*a<=K && (K-i*a)%b==0 && (K-i*a)/b <=y){ //不要忘了这两个个约束 i*a<=K && (K-i*a)/b <=y
//                sum += (C_mn[x][i] * C_mn[y][(K-i*a)/b])%modV; //错的只过60% , 少了1次求模
                sum = (sum + (C_mn[x][i] * C_mn[y][(K-i*a)/b])%modV)%modV;
            }
        }
        System.out.println(sum);


    }

}
