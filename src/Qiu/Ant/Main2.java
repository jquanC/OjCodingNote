package Qiu.Ant;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static BigInteger ans = new BigInteger("0");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();//不包含0
        int k = sc.nextInt();
//        sc.nextLine();
        for(int i=0;i<line.length();i++){
            cou(line,i,0,k);
        }
        System.out.println(ans.toString(10));
    }
    public  static void cou(String line,int idx,long val,int k){
        if(idx == line.length() ) return;
        val = val*10 + (line.charAt(idx)-'0');
        if(val >=k) return;
//        ans++;
        ans = ans.add(BigInteger.ONE);
        cou(line,idx+1,val,k);
    }
}
