package ACMmodel.Shein;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        String test =  "3[a]2[bc]";
        Solution so = new Solution();
        String ans = so.decodeString(test);
        System.out.println(ans);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        // write code here
        char[] crr = s.toCharArray();
        int index = 0;
        while (index < s.length()) {
            if (crr[index] >= '0' && crr[index] <= '9') {
                break;
            }
            index++;
        }
        String preStr = s.substring(0,index);
        //全字符
        if (index == crr.length) return preStr;
        //求数字
        int num = 0;
        while (index < crr.length) {
            if (crr[index] >= '0' && crr[index] <= '9') {
                num = num * 10 + (crr[index] - '0');
                index++;
                continue;
            }
            break;
        }
        int s1 = index+1;
        //找右边括号标记
        int leftCou = 0;
        while (index < crr.length) {
            if (crr[index] == '[') {
                leftCou++;
                index++;
                continue;
            }
            if (crr[index] == ']') {
                leftCou--;
                if (leftCou == 0) {
                    break;
                }
               // index++;
            }
            index++;
        }
        String sub1 = decodeString(s.substring(s1, index));
        String realSub1 = "";
        for (int i = 0; i < num; i++) realSub1 += sub1;
        String sub2 = "";
        if (index < crr.length ) sub2 = decodeString(s.substring(index+1));
        return preStr + realSub1 + sub2;

    }
}