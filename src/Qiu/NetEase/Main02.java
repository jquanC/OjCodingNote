package Qiu.NetEase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k>=1000){
            System.out.println(20);
            return;
        }
        if(k<25){
            System.out.println(0);
            return;
        }
        if(k<100){
            System.out.println(1);
            return;
        }


    }
    //
    public int calLess1000(int k){
        int cou = 0;
        String str = String.valueOf(k);
        int len = str.length();
        if(str.charAt(0)>='2'&& str.charAt(1)>='5'){
            cou += Math.pow(10,(len-2));
        }
//        cou += (str.charAt(0)-'0')*()
        return 0;

    }

}
