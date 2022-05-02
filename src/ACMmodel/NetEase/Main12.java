package ACMmodel.NetEase;

import java.util.Arrays;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        long sum = 0 ;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        sc.nextLine();
        long ans=0;
        for(int i=0;i<n;i++){
            long base = (sum-arr[i])%x;
            if(p<(x-base)) continue;
            long contribute = (p- (x-base))/x +1;
            if(sum %x ==0 && arr[i]<=p) contribute--;
            ans+=contribute;
        }
        System.out.println(ans);

    }
}
