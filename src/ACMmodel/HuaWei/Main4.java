package ACMmodel.HuaWei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] carr = str.toCharArray();

        HashSet<Character> set = new HashSet<>(); //动态维护最长连续无重复字符的集
        int maxLen = 0;
        for(int i=0;i< carr.length;i++){
            //无重复，添加
            if(!set.contains(carr[i])){
                set.add(carr[i]);
                int curSize = set.size();
                if(curSize>maxLen) maxLen = curSize;
                continue;
            }
            //是一个重复字符，需要将前一段无重复字符串中，开始到重复字符那一段舍弃
            int start = i-set.size();//start 左指针
            for(int j=start;j<i;j++){
                if(carr[j] != carr[i]){
                    set.remove(carr[j]);
                    continue;
                }
                break;
            }
        }
        System.out.println(maxLen);
    }

}
