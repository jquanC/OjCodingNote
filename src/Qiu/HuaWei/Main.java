package Qiu.HuaWei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int ans = calPathNums(m,n);
        System.out.println(ans);

    }
    public static int calPathNums(int m,int n){
        int[][] grid = new int[m][n];
        //边界
        for(int i=0;i<m;i++){
            grid[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            grid[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){

                grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[m-1][n-1];


    }
}
