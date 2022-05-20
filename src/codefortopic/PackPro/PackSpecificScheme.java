package codefortopic.PackPro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PackSpecificScheme {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[][] best = new int[N + 2][V + 1];
        int[] v = new int[N + 2];
        int[] w = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            if (i != N) in.nextLine();
        }
        for (int i = N; i >= 1; i--) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) //开始粗心写成 >了
                    best[i][j] = Math.max(best[i + 1][j], best[i + 1][j - v[i]] + w[i]);
                else best[i][j] = best[i + 1][j];
            }
        }
        //best解在 best[1][V]中
        List<Integer> ans = new ArrayList<>();
        int resV = V;
        //这个找答案也很巧妙，需要依次枚举的是N，而v是跳跃的，这样完成了对二位结果数据的查找
        for (int i = 1; i <= N; i++) {

            if ( resV-v[i]>=0 && best[i][resV] == best[i + 1][resV - v[i]] + w[i]) {
                ans.add(i);
                resV -= v[i];
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if(i != ans.size()) System.out.print(" ");
        }
        System.out.println();
    }


}

