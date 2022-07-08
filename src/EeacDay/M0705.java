package EeacDay;

import java.util.HashSet;

public class M0705 {
    public static void main(String[] args) {
        M0705 m705 = new M0705();
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        int ans = m705.largestIsland(grid);
        System.out.println(ans);

    }

    int maxS = Integer.MIN_VALUE;

    public int largestIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue; //全1怎么办?不就漏了吗？
                } else {
                    grid[i][j] = 1;
                    dfs(0, i, j, grid, new HashSet<Point>());
                    grid[i][j] = 0;
                }
            }
        }
        return maxS;
    }

    public void dfs(int s, int x, int y, int[][] grid, HashSet<Point> path) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        Point curP = new Point(String.valueOf(x), String.valueOf(y));
        if (grid[x][y] == 0 || path.contains(curP)) return;
        path.add(curP);
        if (path.size() > maxS) maxS = path.size();
        dfs(s, x + 1, y, grid, path);
        dfs(s, x - 1, y, grid, path);
        dfs(s, x, y + 1, grid, path);
        dfs(s, x, y - 1, grid, path);

    }


}

class Point {
    String x;
    String y;

    public Point(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        Point comp = (Point) obj;
        if (this.x.equals(comp.x)  && this.y.equals(comp.y)) { //字符串比较记得不要用 ==
            return true;
        } else return false;
    }

    public int hashCode() {
        return x.hashCode() + y.hashCode();
    }
}