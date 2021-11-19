package SwordOf.Search.Recurse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Exist {
    boolean res = false;

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                exist(board, visited, i, j, word, 0);
                if(res == true) break;
            }
            if(res == true) break;
        }

        return res;
    }

    public void exist(char[][] board, boolean[][] visited, int row, int col, String word, int index) {

        char ch = board[row][col];

        if (ch == word.charAt(index)) {
            visited[row][col] = true;
            index++;
            if(index == word.length()){
                res = true;
                return;
            }

            //从这一步递归
            if (row > 0 && visited[row - 1][col] == false && res == false)
                exist(board, visited, row - 1, col, word, index );
            if (row < visited.length - 1 && visited[row + 1][col] == false && res == false)
                exist(board, visited, row + 1, col, word, index);
            if (col > 0 && visited[row][col - 1] == false && res == false)
                exist(board, visited, row, col - 1, word, index);
            if (col < visited[0].length - 1 && visited[row][col + 1] == false && res == false)
                exist(board, visited, row, col + 1, word, index);

            index--;
            visited[row][col] = false;

        }

    }


    @Test
    public void test() {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String str = "abcd";
        boolean res = exist(board, str);
    }

}

