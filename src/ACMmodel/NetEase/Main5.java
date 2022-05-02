package ACMmodel.NetEase;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int[][] dp = new int[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            dp[i][i] = arr[i];
            ans+=cal0(arr[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j] = dp[i][j-1]*arr[j];
                ans+=cal0(dp[i][j]);
            }
        }
        System.out.println(ans);
    }
    public static long cal0(long x){
        long mod = 10;
        long ans = 0;
        while(x % mod ==0){
            mod*=10;
            ans++;
        }
        return ans;
    }
}
