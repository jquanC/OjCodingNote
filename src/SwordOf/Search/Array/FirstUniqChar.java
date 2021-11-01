package SwordOf.Search.Array;

import org.junit.Test;

public class FirstUniqChar {
/*输出原串第一个唯一字符
* 不是输出最小的原串唯一字符*/
    public char firstUniqChar(String s){
        int[] sMap = new int[27];
        int[] time = new int[27];
        int timeCou=0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            sMap[ch-'a']++;
            time[ch-'a'] = timeCou++;
        }
        int timeMin = Integer.MAX_VALUE;
        char resChar = ' ';
        for(int i=0;i<sMap.length;i++){
            if(sMap[i]==1 && time[i]<timeMin){
                resChar = (char)('a'+i);
                timeMin = time[i];
            }
        }
        return resChar;
    }

    @Test
    public void test(){
        String s = "leetcode";
        char res = firstUniqChar(s);
        System.out.println(res);
    }
}
