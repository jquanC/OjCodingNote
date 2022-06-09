package ACMmodel.LiX;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger ans = feibo(n);
        System.out.println(ans);
    }
    public  static BigInteger feibo(int n){
        if(n == 0) return new BigInteger("0");
        if(n == 1) return new BigInteger("1");

        return feibo(n-1).add(feibo(n-2));
    }
}
