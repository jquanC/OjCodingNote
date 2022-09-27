package Qiu.Ant;

import java.util.Scanner;

public class MainO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int odd = 1, even = 2;
        boolean type = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) type = !type;
                if (type) {
                    if (odd > n * n) {
                        System.out.println(-1);
                        return;
                    }
                    matrix[i][j] = odd;
                    odd += 2;
                } else {
                    if (even > n * n) {
                        System.out.println(-1);
                        return;
                    }
                    matrix[i][j] = even;
                    even += 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

}
