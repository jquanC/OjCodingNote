package Qiu.Ant;

import java.util.Scanner;
/**
 輸入n，往n*n矩阵填 1-n^2, 使得任意2*2子矩阵和是奇数
 in
 3
out
 1 3 2
 7 4 6
 9 5 8
 * */

/**
 * T F T F....
 * F T F T....
 * ....
 * ....
 *
 * 填充即可
 * */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean type = false;
        int odd = 1;
        int even = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                type = !type;
                if(type){
                    if(odd>n*n){
                        System.out.println(-1);
                        return;
                    }
                    arr[i][j] = odd;
                    odd+=2;
                }else{
                    if(even>n*n){
                        System.out.println(-1);
                        return;
                    }
                    arr[i][j] = even;
                    even+=2;
                }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]);
                if(j!=n-1) System.out.print(" ");
            }
            System.out.println();
        }


    }
}
