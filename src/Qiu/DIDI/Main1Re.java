package Qiu.DIDI;

import java.util.Scanner;

/**
 * 一个标书证书的字符串，其中有几位是问号，知道这个数字满足
 * 1，可被3整除；
 * 2，相邻数字不同；
 * 3，首位不为0
 *
 * */

/**
 in:
 ?2?034?
 out：
 1210340

 * */

public class Main1Re {
//    static String ans = "";
    static int ans  = 0;
    static boolean find = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] crr = str.toCharArray();
        reCurCal(crr,0,0);
        System.out.println(ans);


    }
    public static void reCurCal(char[] crr,int index,int val){
        if(find) return;
        if(index == crr.length  ){
            if(val%3==0){
                ans = val;
                find = true;
                return;
            }
            return;

        }
        if(crr[index]!='?'){
            if(index>=1 && crr[index] == crr[index-1]) return;
            reCurCal(crr,index+1,val*10+(crr[index]-'0'));
        }else{
            char ch = '0';
            for(int j=0;j<=9 && !find;j++){
                ch = (char)('0'+j);
                if(index == 0 && j==0) continue;
                if(index==0||crr[index-1]!=ch){ /**关键是这里导致我没选择用递归，浪费了太多时间。
                 每一位只要每次只需要从小开始枚举，和前一位比较，不同即可。不需要考虑和后一位比较的情况*/
                    crr[index] = ch;
                    reCurCal(crr,index+1,val*10+(ch-'0'));
                }
            }
        }
    }
}
