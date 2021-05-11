package Hot100.Medium;

import Hot100.Easy.ListNode;

import java.util.HashSet;
import java.util.Set;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/
/*
* 求每个字符开头的最长不重复字串的长度，记录最大值
* 高效的方式是滑动窗口。有两个指针，均不回溯
* 判断当前窗口内有无重复字符，采用 HashSet 作为数据结构
* */
public class SoLengthOfLongestSubstring02 {
    public int lengthOfLongestSubstring(String s){

        int start =0 , end=0, len=0,res=0;
        Set<Character> window = new HashSet<>();
        while(start<s.length()&&end<s.length()){
            if(window.contains(s.charAt(end))){
                window.remove(s.charAt(start));//逐个移动start
                start+=1;
            }else{
                window.add(s.charAt(end));
                len = end-start+1;
                if(len > res) res = len;
                end+=1;
            }
        }
        return res;
    }

}
