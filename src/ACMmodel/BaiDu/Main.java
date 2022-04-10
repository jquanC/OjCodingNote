package ACMmodel.BaiDu;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        scan.nextLine();
        int[][] arrIn = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arrIn[i][j] = scan.nextInt();
            }
            scan.nextLine();
        }
        int[][] arrOut = new int[K*N][K*N];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int sRow = (i-1)*K;
                int sCol = (j-1)*K;
                int num = arrIn[i-1][j-1];
                for(int m=sRow;m<sRow+K;m++){
                    for(int n=sCol;n<sCol+K;n++){
                        arrOut[m][n] = num;
                    }
                }
            }
        }
        for(int i=0;i<K*N;i++){
            for(int j=0;j<K*N;j++){
                System.out.print(arrOut[i][j]);
                if(j!=K*N-1) System.out.print(" ");
                else System.out.println();
            }
        }
    }
}
