package Hot100.Medium.CharacterString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * 滑动窗口+比较数组 解法*/
public class FindAnagramsSoS1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(n<m) return res;/*没有说s一定比p长*/

        int[]sCnt = new int[26];
        int[]pCnt = new int[26];


        for(int i=0;i<m;i++){
            char  ch1 = p.charAt(i);
            char ch2 = s.charAt(i);
            pCnt[ch1-'a']++;
            sCnt[ch2-'a']++;
        }
        if(Arrays.equals(sCnt,pCnt)) res.add(0);

        for(int i=m;i<n;i++){
            sCnt[s.charAt(i-m)-'a']--;
            sCnt[s.charAt(i)-'a']++;
            if(Arrays.equals(sCnt,pCnt)) res.add(i-m+1);
        }
       return res;
    }
}
