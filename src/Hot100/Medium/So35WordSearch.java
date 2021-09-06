package Hot100.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class So35WordSearch {
    public boolean exist(char[][] board, String word) {
        int[][] vis = new int[board.length][board[0].length];

        char startLetter = word.charAt(0);
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == startLetter && res == false) {
                    res = dfs(i, j, board, vis, 0, word);
                }
            }
        }
        return res;

    }

    private boolean dfs(int x, int y, char[][] board, int[][] vis, int k, String word) {

        if (k==word.length()) { //记录找到答案结果，此路返回
            return true;
        }

        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] != word.charAt(k) || vis[x][y] == 1)
            return false; //该空格不可以走
        else {//该空格可以走
            vis[x][y] = 1;

            //尝试往4个方向走
            if (dfs(x - 1, y, board, vis, k + 1, word)) return true;
            else if (dfs(x, y - 1, board, vis, k + 1, word)) return true;
            else if (dfs(x + 1, y, board, vis, k + 1, word)) return true;
            else if(dfs(x, y + 1, board, vis, k + 1, word)) return true;
            else {

                vis[x][y]=0;

            }


        }

    return false;
    }

}
