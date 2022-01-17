package SwordOf.Search;

import org.junit.Test;

public class Exist {
    public boolean exist(char[][] board, String word) {
        if( board == null || board.length ==0) return false;
        int m = board.length;
        int n = board[0].length;
        char[] wordArr = word.toCharArray();
        boolean[][] valid = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==wordArr[0]){
                    if(search(board,valid,wordArr,i,j,0)) return true;
                }
            }
        }
        return false;

    }

    private boolean search(char[][]board, boolean[][] valid,char[] wordArr,int col,int rol,int index){
        if(index == wordArr.length) return true;
        int m = board.length;
        int n = board[0].length;
        boolean res = false;
        if(col<0 ||col>=m || rol<0 || rol>=n) return false;
        if(board[col][rol] == wordArr[index] && valid[col][rol]==false){
            valid[col][rol] = true;
            res = search(board,valid,wordArr,col+1,rol,index+1)||
                    search(board,valid,wordArr,col,rol+1,index+1)||
                    search(board,valid,wordArr,col-1,rol,index+1)||
                    search(board,valid,wordArr,col,rol-1,index+1);//应该用index+1
            if(res == false) valid[col][rol] = false;
        }
        return res;
    }

    @Test
    public void test(){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean res = exist(board,word);
        System.out.println(res);
    }

}
