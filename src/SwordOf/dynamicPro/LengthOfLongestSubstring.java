package SwordOf.dynamicPro;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    /*剑指上s的值只是小写字母，但leetcode则没有这一限制；
    所以不能用一个小数组来记录下标了，需要用HashMap<字符，上一次出现的值>*/
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

      /*  int[] preAppearPosition = new int[26];
        for (int i = 0; i < 26; i++) {
            preAppearPosition[i] = -1;
        }*/
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        int len = 0;//len表示当前字符到到上一次该字符出现的情况；len>=1, 1就是相邻aa的情况;
        int fPre = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //该字符从未出现过

            if (!map.containsKey(ch)) {
//                fPre = fPre++;
                fPre++;
                map.put(ch, i);

            } else { //该字符出现过
                //先求两个该字符间的距离，再分两种情况处理
                len = i - map.get(ch);
                map.put(ch,i);

                if (len <= fPre) fPre = len;
                else {
                    //fPre = fPre++;什么玩意
                    fPre++;
                }
            }

            if (fPre > maxLen) maxLen = fPre;
        }
        return maxLen;
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);

    }

    @Test
    public void test2() {
        int i = 0;
        for (int j = 0; j < 2; j++) {
            i=++i;
//            i=i++;
        }
        System.out.println(i);
    }
}
