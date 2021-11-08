package SwordOf.dynamicPro;

import org.junit.Test;

import java.util.Arrays;

public class FibFast {
    int MOD = 1000000007;

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[][] start = new int[][]{{1}, {0}};
        int[][] matrix = new int[][]{{1, 1}, {1, 0}};
        matrix = powMatrix(matrix, n - 1);
        int[][] res = matrixMultiply(matrix, start);

        return res[0][0];
    }

    //矩阵的幂乘
    public int[][] powMatrix(int[][] A, int k) {

        int[][] eachMultiply = A;
        int[][] res = new int[A.length][A.length];
        for (int i = 0; i < res.length; i++) res[i][i] = 1;

        while (k > 0) {
            if ((k & 1) == 1) {
                res = matrixMultiply(res, eachMultiply);
            }
            eachMultiply = matrixMultiply(eachMultiply, eachMultiply);
            k = k >> 1;
        }
        return res;
    }


    //两个矩阵相乘
    /*A(m*n) , B(n*t)*/
    public int[][] matrixMultiply(int[][] A, int[][] B) {
        if (A.length == 0 || A == null || B.length == 0 || B.length == 0) return null;
        if (A[0].length != B.length) return null;
        int m = A.length;
        int n = A[0].length;
        int t = B[0].length;
        int[][] res = new int[m][t];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < t; j++) {
                int oneEle = 0;
                for (int k = 0; k < n; k++) {
                    oneEle += 1l*A[i][k] * B[k][j] % MOD;
                }
                res[i][j] = oneEle;
            }
        }
        return res;
    }

    //两个数的快速幂乘算法
    public long myPower(int x, long k) {
        int check = 1;
        int eachMultiply = x;
        int res = 1;
        while (k > 0) {
            if ((k & check) == 1) {
                res *= eachMultiply;
            }
            eachMultiply *= eachMultiply;
            k = k >> 1;
        }
        return res;
    }


    @Test
    public void test2(){
        int res = fib(2);
        System.out.println(res);
    }

    @Test
    public void test() {
        int mod1 = (int) 1e9;
        double mod2 = 1e9;
        System.out.println(mod1);
        System.out.println(mod2);
    }
}
