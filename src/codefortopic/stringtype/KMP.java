package codefortopic.stringtype;

/***kmp 算法
 * https://www.zhihu.com/question/21923021/answer/281346746
 *https://leetcode-cn.com/problems/implement-strstr/
 * */
public class KMP {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return  0;

        //建立next数组
        int[] next = getNext(needle);
        int i=0;
        int j=0;
        while(i<haystack.length() && j<needle.length()){
            if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j==needle.length()){
            return i-needle.length();
        }
        return -1;

    }
    public int[] getNext(String modelStr){
        int[] next = new int[modelStr.length()+1];
        next[0] = -1;
        int i=0;
        int j=-1;
        while(i<modelStr.length()){
            if(j==-1 ||modelStr.charAt(i)==modelStr.charAt(j)){
                j++;
                i++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;

    }
}
