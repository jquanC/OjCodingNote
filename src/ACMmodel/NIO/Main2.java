package ACMmodel.NIO;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
       /* String reStr = "";
        for (int i = 0; i < K - 1; i++) {
            reStr = str.charAt(i) + reStr;
        }*/

        char[] revrr = new char[K-1];
        for (int i = 0; i < K - 1; i++) {
            revrr[K-i-2] = str.charAt(i);//k-2 因为本来就是K-1
        }
        String reStr = String.valueOf(revrr);
        String ans = str.substring(K - 1);
        if ((str.length() + K) % 2 == 0) {
            ans += reStr;
        } else {
            ans += str.substring(0, K - 1);
        }
        System.out.println(ans);


    }
}
