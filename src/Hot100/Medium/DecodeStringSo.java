package Hot100.Medium;

import javafx.beans.binding.When;
import org.junit.Test;

import javax.swing.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeStringSo {

    String s;

    public String decodeString(String str) {
        s = str;
        return decode(0, s.length());

    }

    private String decode(int start, int end) { //s[start,end);
        int scan = start;
        StringBuilder res = new StringBuilder();
        int plusNum = 1;
        while (scan < end) {
            if (Character.isDigit(s.charAt(scan))) {//是数字，求出数字，注意数字可能不值一位
                int len = 1;
                while (Character.isDigit(s.charAt(scan + len))) len++;
                plusNum = str2Num(scan, scan + len);

                scan += len;
            } else if (Character.isLetter(s.charAt(scan))) { //普通字符字节插入
                res.append(s.charAt(scan));
               /* else {
                    while (plusNum > 0) {
                        res.append(s.charAt(scan));
                        plusNum--;
                    }
                    plusNum = 1;
                }*/
                scan++;
            } else if(s.charAt(scan) == '['){ // 遇到左括号，直接寻找其对应的右括号
                int count = 1;
                int len = 1;
                while (!(count == 1 && s.charAt(scan + len) == ']')) {
                    if (s.charAt(scan + len) == '[') count++;
                    if (s.charAt(scan + len) == ']') count--;
                    len++;
                }
                String subStr = decode(scan+1, scan + len);
                //数字

                if (plusNum == 1) res.append(subStr);
                else {
                    while (plusNum > 0) {
                        res.append(subStr);
                        plusNum--;
                    }
                    plusNum = 1;
                }
                scan = scan+len;
            }else{
                scan++;
            }

        }
        return res.toString();
    }

    private int str2Num(int start, int end) {
        int num = 0;
        while (start < end) {
            num = num * 10 + s.charAt(start)-'0';
            start++;
        }
        return num;
    }


    @Test
    public void test() {
        String s = "ac3[ab]2[a2[bc]]";
        String res = decodeString(s);
        System.out.println(res);
    }
}
