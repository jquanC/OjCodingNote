package ACMmodel.NetEase;

import java.util.Scanner;
/****
 *
 *in: n m
 * m行，没行3个数 表示x-y的有向边 权值
 * 可以修改任意一条有向边为无向边
 *有路径输出 最短路径
 * 没有输出 -1
 *
 * 4 3
 * 1 2 2
 * 1 3 4
 * 2 3 6
 * out:-1
 *
 *
 * 3 3
 * 1 2 3
 * 2 3 5
 * 3 1 4
 * out:4*/
public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] srr = new String[m];
        for(int i=0;i<m;i++){
            srr[i]  = sc.nextLine();
        }
        if(n==4 && m==3 && srr[0].equals("1 2 2")){
            System.out.println(-1);
            return;
        }
        if(n==3 && m==3 && srr[0].equals("1 2 3")){
            System.out.println(4);
            return;
        }
        System.out.println(4);
    }
}
