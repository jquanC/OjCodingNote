package CSP;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] param = new int[4];
        for(int i =0;i<4;i++){
            param[i] = scanner.nextInt();
        }

        int n = param[0];
        int L = param[1];
        int r = param[2];
        int t = param[3];
        int[][] A = new int [n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j]=scanner.nextInt();

            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(calThreshold(A,i,j,r)<=t) count++;
            }
        }

        System.out.println(count);

    }
    private static double calThreshold(int[][] A,int x,int y,int r){
        int res=0;
        int startX= x-r;
        int startY = y-r;
        int endX = x+r;
        int endY = y+r;

        int count=0;
        for(int i = startX;i<=endX;i++){
            if(i <0 || i>=A.length) continue;
            for(int j = startY;j<=endY;j++){
                if(j<0||j>=A.length){
                    continue;
                }else{
                    count++;
                    res+=A[i][j];
                }
            }
        }


        return (double) res/count;
    }
}
