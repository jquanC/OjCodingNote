package Hot100.Medium.CharacterString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口+双指针解法 解法
 */
public class FindAnagramsSoS2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n < m) return res;/*没有说s一定比p长*/

        int[] sCnt = new int[26];
        int[] pCnt = new int[26];


        for (int i = 0; i < m; i++) {
            char ch1 = p.charAt(i);
            pCnt[ch1 - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {

            int index = s.charAt(right) - 'a';
            sCnt[index]++;
            while (sCnt[index] > pCnt[index]){
                sCnt[s.charAt(left++)-'a']--;
            }
            if(right-left+1 == m) res.add(left);

        }
        return res;
    }
}
