package Qiu.JD;

import java.util.Scanner;

public class Main3 {
    static int P = 1000000000+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<6){
            System.out.println(0);
            return;
        }
        if(n==6){
            System.out.println(1);
            return;
        }
        long ans = 0;

        //枚举第一个 red的右端点
        for(int i=3;i<=n-3;i++){
            int preDigitCou = i-3;
            long firstCou = (long)Math.pow(26,preDigitCou);
            if(firstCou>P) firstCou %= P;
            long secondCou = calSecondPart(n-i);
            ans += firstCou*secondCou;//firstCou*secondCou 不是 firstCou+secondCou;
            if(ans>P) ans%=P;

        }
        System.out.println(ans);
        System.out.println(Math.pow(2,3));

    }
    public static int calSecondPart(int len){//3 4
        long secondCou = (long)((len-3+1)*Math.pow(26,len-3));
        if(secondCou>P) secondCou %= P;
        return (int)secondCou;

    }
}
