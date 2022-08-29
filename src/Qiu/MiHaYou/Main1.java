package Qiu.MiHaYou;

import java.util.HashSet;

public class Main1 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring (String s) {
        HashSet<Character> set = new HashSet();
        int ans = 0;
        for(int i=0;i< s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                ans = Math.max(ans,set.size());
                continue;
            }
            int len = set.size();
            for(int j=i-len;j<i;j++){
                if(s.charAt(j)!=ch){
                    set.remove(s.charAt(j));
                    continue;
                }
                break;

            }
        }
        return ans;

    }
}
