package ACMmodel.WeBank;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str =  sc.nextLine();
//        StringBuilder sb = new StringBuilder(str);

        int ans = 0;
        int upNum = Integer.parseInt(str);
        int num = 0 ;
        int beishu = 0;
//        HashSet<String> ansSet = new HashSet<>();
        //枚举能被k整除的数num
        while(num<=upNum){
            num= beishu*k;
            String curStrVal = String.valueOf(num);
            if(str.contains(curStrVal)){
                ans++;
                String tStr = "0"+curStrVal;
                while(str.contains(tStr)){
                    ans++;
                    tStr = "0"+tStr;
                }
            }
            beishu++;
        }

        System.out.println(ans);

    }
}
