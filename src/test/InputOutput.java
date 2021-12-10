package test;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**next忽略前面前面的空白，nextline一个不会*/

      /*  String str1 = in.next();
        System.out.println("str1="+str1);

        String str2 = in.next();
        System.out.println("str2="+str2);*/

         /** next遇到空格换行等字符，自动结束,不接受有效字符后面的字符
          *  nextline可以接收空白和换行符*/
        String str1 = in.nextLine();
        System.out.println("str1="+str1);

        String str2 = in.next();
        System.out.println("str2="+str2);

    }
}

