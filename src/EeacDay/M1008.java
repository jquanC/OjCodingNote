package EeacDay;

import java.util.ArrayList;
import java.util.List;

/** n 皇后问题*/
public class M1008 {
    public static void main(String[] args) {
        M1008 so = new M1008();
        List<List<String>> ans =  so.solveNQueens(5);
        for(List<String> e: ans){
            System.out.println(e);
        }
    }

    //int[][] grid;
    boolean[] vis;
    int[] x; //x[i]:第i行棋下在第x[i]列
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList();
        vis = new boolean[n];
        x = new int[n];
        //grid = new int[n][n];
        go(0,n);
        return ans;

    }
    public void go(int step,int n){
        if(step == n){
            //记录一个可行解
            List<String> oneAns = new ArrayList();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(j==x[i]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                oneAns.add(sb.toString());
            }
            ans.add(oneAns);
            return;
        }

        for(int i=0;i<n;i++){//枚举列
            if(vis[i]==false && check(step,i)){
                x[step] = i;
                vis[i] = true;
                go(step+1,n);
                //不需要对x[step]回溯
                vis[i] = false;

            }
        }
    }
    public boolean check(int row,int col){
        for(int i=0;i<row;i++){//枚举行
            if(x[i] == col || Math.abs(x[i]-col)==Math.abs(row-i)){ // 4/3 = 1 实际是1.x不在一斜线上，被错误判定了
                return false;
            }
        }
        return true;
    }
}
