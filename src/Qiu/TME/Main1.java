package Qiu.TME;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 so = new Main1();
        int n = so.minOperations("1001101");
        System.out.println(n);
    }
    public int minOperations (String str) {
        // write code here
//        char[] crr = line.toCharArray();
        //要么改0，要么改1,逻辑上统计即可，都算一遍
        int cou0T1 = 0;
        int cou1T0 = 0;
        int idx = 0;
        while(idx<str.length()){
            char ch = str.charAt(idx);
            if(ch == '0'){
                cou0T1++;
                idx+=2;
            }else  idx++;
        }
        idx = 0;
        while(idx<str.length()){
            char ch = str.charAt(idx);
            if(ch == '1'){
                cou1T0++;
                idx+=2;
            }else idx++;
        }
       return Math.min(cou0T1,cou1T0);

    }
}
