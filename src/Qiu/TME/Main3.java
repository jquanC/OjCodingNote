/*
package Qiu.TME;

import java.util.Arrays;

public class Main3 {

    //当且仅当该矩阵所有2*2矩阵数字和为偶数
    static long ans = 0;
    static long P = 1000000007;
    public int numsOfGoodMatrix (int n, int m, int x) {
        // write code here
        int[] lastRow = new int[m];
        allStart(lastRow,0,x,n,m);
    }
    public void allStart(int[] lastRow,int step,int x,int n,int m ){
        if(step == lastRow.length){
            //求解
            int[] dArr = Arrays.copyOf(lastRow,0);
            cal(dArr,n,m,x);
            return;
        }
        for(int i=1;i<=x;i++){
            lastRow[step] = x;
            allStart(lastRow,step+1,x,n,m);
        }
    }
    public void cal(int[]dArr,int n,int m,int num){
        long curAns = 0;
        int lastNum = 1;

        for(int x = 1;x<n;x++){
            for(int y=1;y<m;y++){
                for(int t=1;t<=num;t++ ){
                    lastNum = t;
                    for()

                }
            }
        }

    }
}
*/
