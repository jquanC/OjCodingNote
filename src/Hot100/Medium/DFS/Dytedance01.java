package Hot100.Medium.DFS;

import org.junit.Test;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 网上一道字节二面题
 */
public class Dytedance01 {

    public int maxRes(int[][] A) {
        if (A == null) return 0;

        HashSet<String> path = new HashSet<>();
        int[][] ans = new int[A.length][A[0].length];
        for(int[] e : ans){
            Arrays.fill(e, Integer.MIN_VALUE);
        }

        dfs(A, ans,0, 0, 0, path);

        return ans[A.length - 1][A[0].length - 1];

    }

    private void dfs(int[][] A, int[][]ans, int row, int col, int curSum, HashSet<String> path) {
        int rowMax = A.length - 1;
        int colMax = A[0].length - 1;
        if (row < 0 || row > rowMax || col < 0 || col > colMax) return;
        String curPoint = String.valueOf(row) + String.valueOf(col);

        if (path.contains(curPoint)) return;

        //没有说最后终点值可不可以是负，单为这种情况加个判断条件
        if (row == rowMax && col == colMax && A[row][col] + curSum > ans[row][col]) {
            ans[row][col] = A[row][col] + curSum ;
//            path.add(curPoint);
            return;
        }
        //不是终点，<0 的情况可以提前回溯；
        if (curSum + A[row][col] >= 0 ) { //不可以加 &&  curSum + A[row][col] > ans[row][col] 限制
            if(curSum + A[row][col] > ans[row][col])    ans[row][col] =  A[row][col] + curSum;
            curSum+=A[row][col];
            path.add(curPoint);
            //其它搜索
            dfs(A, ans,row - 1, col, curSum, path);
            dfs(A, ans,row + 1, col, curSum, path);
            dfs(A, ans,row, col + 1, curSum, path);
            dfs(A, ans,row, col - 1, curSum, path);

            curSum-=A[row][col];
            path.remove(curPoint);
        }
        return;
    }

    @Test
    public void test() {
        int[][] A = new int[][]{{10, -10, 10, 10, 10},
                {10, -10, 10, -10, 10},
                {10, -10, 10, -10, 10},
                {10, -10, 10, -10, 10},
                {10, 10, 10, 10, 10}};
        int ans = maxRes(A);
        System.out.println(ans);
    }
}
