package Qiu.MEIT;



import java.util.Scanner;

/*
* in:
* 4
* 25
* 35
* 15
* 3
* out should be:
* u
* w
* w
* i
* */

//初始字符串为MetTuan，每次对字符串做 str = str + str.reverse() + "wow"的操作，无限循环。后面给你一个k，问你位置k的字符为什么。
public class Main5 {
    public static String baseStr = new String("MeiTuannauTieMwow");
    public static int baseLen = baseStr.length();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            int k = sc.nextInt();
            System.out.println(cal(k));
        }

    }
    public static char cal(int k){
        int len = baseLen;
        while(len<k){
            len = len*2+3;
        }
        //模拟所求字符下标，字符串长度len;当前字符串长度len,可以分为 [S][revS][wow]，分四种情况处理
        int index = k;
        while(true){
            if(len-index<3){ //0 1 2
                return new String("wow").charAt(len-index);
            }else if(index < baseLen){
                return baseStr.charAt(index-1);//减一，最后取字符，字符串下标是从0开始
            }else if(index < (len-3)/2){
                len = (len-3)/2;
            }else{
                index = len - 3 - index +1;//是个规律，revS部分自己也是对称的
            }
        }

    }



}
