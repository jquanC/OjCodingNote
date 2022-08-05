package ACMmodel.ByteDance.DanYue;

import java.util.Scanner;
/*
in:
5 4
0 2
1 3
2 1
3 2

out:
7
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        int[][] sup = new int[N][2];
        for(int i=0;i<N;i++){
            sup[i][0] = sc.nextInt();
            sup[i][1] = sc.nextInt();
            sc.nextLine();
        }
        int preMin = Integer.MAX_VALUE;
        int lastReachSupDay = 0;
        int total = 0;

        for(int i=0;i<N;i++){
            int consumeDay = sup[i][0] - lastReachSupDay;
            lastReachSupDay = sup[i][0];
            total += consumeDay*preMin;
            if(sup[i][1]<preMin) preMin = sup[i][1];
        }
        total += (M-lastReachSupDay)*preMin;
        System.out.println(total);
    }
}
