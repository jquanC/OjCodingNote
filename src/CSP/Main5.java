package CSP;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n][2];
        for(int i =0; i<n ; i++){
          input[i][0] =  scanner.nextInt();
          input[i][1] = scanner.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+= input[i][0]*input[i][1];
        }
        System.out.println( sum<0 ? 0 : sum );

    }
}
