package Hot100.Medium;

import java.util.*;
/*
 * 基本思路，递归(分解问题)+贪心(快速得到答案)
 * */

public class So48WordSplit {
    //方法一 基本思路，递归(分解问题)+贪心(快速得到答案)-但还是慢！重复求解子问题
    /*public boolean wordBreak(String s, List<String> wordDict){
        if(s.equals("") ) return true;// == 是内存比较；
        boolean ok = false;
        for (String e:wordDict
             ) {

            if(s.contains(e)){ //分割
                int pos = s.indexOf(e);//note+:lastIndexOf(int ch);
                String preStr = s.substring(0,pos);
                String rearStr = s.substring(pos+e.length());//second param s.length is redundant
                ok = wordBreak(preStr,wordDict) && wordBreak(rearStr,wordDict);
                if(ok == true) return true;

            }

        }
        return false;


    }*/
    //方法二 递归动态规划算法
    /*
     * d[i,j] 表示s的子串s[i,j]是否可以拆分, 0<=i<len-1,0<=j<=len-1,; 动态规划最后求解 d[0,len-1]是否可以拆分
     * 转移方程：如果s(i,k) 可以匹配，则 d[i,k] =1;  s[i,j] = s[i,k]+s[k,j], 只需递归查找s[k，j]
     * 要匹配，必须头部可以匹配
     *
     * 每次进入递归，先查表s(i,k) 如果没有则查找
     *
     *
     *
     *

    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] resArr = new int[s.length()][s.length() ];
        return dfsWordSplit(s, 0, s.length() - 1, wordDict, resArr);

    }


    public boolean dfsWordSplit(String s, int i, int j, List<String> wordDict, int[][] resArr) {
        if (i > j) return true;
        if (resArr[i][j] == 1) return true;

        boolean flag = false;
        for (int k = i; k <= j; k++) {

            if (wordDict.contains(s.substring(i, k + 1))) { //要全部单词匹配必须头部匹配能匹配；即使先找到中间子串匹配也没啥意义；关键：可行解(拆分)可根据头部子串构造
                resArr[i][k] = 1;
                //分割继续
                flag = dfsWordSplit(s, k + 1, s.length() - 1, wordDict, resArr);
                if (flag == true) return true;
            }
        }
        return false;

    }
*/
    //和方法一一样还是会超时;为什么呢？虽然 用resArr标记s的子串s(i,j)但这个加速效果是有局限的；避免重复的要求太严格了，是完全相同位置取出的子串；而不是基于子串内容；可以用哈希表来实现

    //方法三 动态规划，hashSet
    //dp[i]:表示 s的[0，i）子串是否可以被单词拆分

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);//根据wordDict 创建hashSet，为了实现下面O(1)的查找
        boolean[] dp = new boolean[s.length() + 1];//dp[0]表示true 做为边界条件，dp[i]表示 s[0,i]子串能否匹配
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j < i; j++) { // s(0,i)分 s(0,j) s(j,i)
                if (dp[j] && wordDictSet.contains(s.substring(j, i ))) {
                    dp[i] = true;
                    break;
                }
            }
        }
    return dp[s.length()];

    }


//main 测试函数
/*

    public static void main(String[] args) {
        String s = "catsandog";
        String[] arr = new String[]{"dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<>();
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        So48WordSplit wd = new So48WordSplit();
        boolean res = wd.wordBreak(s, wordDict);
        System.out.println(res);
    }
*/


}