package test.MS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int solution(int[][] A) {
        if(A==null||A.length == 0) return 0;

        int row = A.length;
        int col = A[0].length;
        int moveCou = 0;
        //对全部格子遍历一遍，将能一步到位的棋子 走完
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                boolean canOneStep = true;
                while(A[i][j]!=1 && A[i][j]!=0 && canOneStep ){
                    canOneStep = false;
                    if(i-1>=0 && A[i-1][j]==0){
                        A[i-1][j] = 1;
                        A[i][j]--;
                        moveCou++;
                        canOneStep = true;
                        continue;
                    }
                    if(i+1<row && A[i+1][j]==0){
                        A[i+1][j] = 1;
                        A[i][j]--;
                        moveCou++;
                        canOneStep = true;
                        continue;
                    }
                    if(j-1>=0 && A[i][j-1]==0){
                        A[i][j-1] = 1;
                        A[i][j] --;
                        moveCou++;
                        canOneStep = true;
                        continue;
                    }
                    if(j+1<col && A[i][j+1]==0){
                        A[i][j+1] = 1;
                        A[i][j] --;
                        moveCou++;
                        canOneStep = true;
                        continue;
                    }
                }
            }
        }
        //再次遍历，对于每个还需调整的棋子，贪心的选择最小解即可所有
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A[i][j] == 1 || A[i][j] ==0) continue;
                else{
                    while(A[i][j]!=1){
                        int lessMove = lessToMove(A,i,j);
                        moveCou+=lessMove;
                    }
                }
            }
        }
        return moveCou;

    }
    public int lessToMove(int[][]A,int curRow,int curCol){
        int row = A.length;
        int col = A[0].length;
        int minCou = Integer.MAX_VALUE;
        int toCol=-1;
        int toRow=-1;
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(A[i][j] == 0){
                    int temp = Math.abs(i-curRow)+Math.abs(j-curCol);
                    if(temp<minCou){
                        minCou = temp;
                        toRow = i;
                        toCol = j;
                    }
                }
            }
        }
        A[toRow][toCol]=1;
        A[curRow][curCol]--;
        return minCou;

    }
    @Test
    public void test(){
        int[][] A = new int[][]{{1,0,1},{1,3,0},{2,0,1}};
        int res = solution(A);
        System.out.println(res);

    }


}
