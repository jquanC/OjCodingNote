package ACMmodel.TenCentOld.spring2018;

import java.util.Scanner;


public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] color = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                color[i][j] = line.charAt(j);
            }
        }
        getMinStep(n, m, color);

    }

    public static void getMinStep(int n, int m, char[][] color) {
        int step = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //划'\' 斜率 45 度
                if (color[i][j] == 'Y') {
                    step++;
                    dfs_y(n, m, i, j, color);
                } else if (color[i][j] == 'B') {
                    step++;
                    dfs_b(n, m, i, j, color);
                } else if (color[i][j] == 'G') {
                    step++;
                    dfs_y(n, m, i, j, color);
                    step++;
                    dfs_b(n, m, i, j, color);
                }
            }
        }
        System.out.println(step);
    }

    public static void dfs_y(int n, int m, int x, int y, char[][] color) {
        if (x >= 0 && y >= 0 && x < n && y < m && (color[x][y] == 'Y' || color[x][y] == 'G')) {
            if (color[x][y] == 'G') {
                color[x][y] = 'B';// 如果当前位置要求画的是G,那么画了Y之后下一次只能画B
            } else {
                color[x][y] = 'X';
            }
            dfs_y(n, m, x + 1, y + 1, color);
            dfs_y(n, m, x - 1, y - 1, color);
        }
    }

    public static void dfs_b(int n, int m, int x, int y, char[][] color) {
        if (x >= 0 && y >= 0 && x < n && y < m && (color[x][y] == 'B' || color[x][y] == 'G')) {
            if (color[x][y] == 'G') {
                color[x][y] = 'Y';// 如果当前位置要求画的是G,那么画了B之后下一次只能画Y
            } else {
                color[x][y] = 'X';
            }
            dfs_b(n, m, x - 1, y + 1, color);
            dfs_b(n, m, x + 1, y - 1, color);
        }
    }
}
