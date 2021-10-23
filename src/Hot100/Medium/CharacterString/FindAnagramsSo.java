package Hot100.Medium.CharacterString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAnagramsSo {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int id = 0;
        int[] pInfoArr = new int[p.length()];

        for (int i = 0; i < p.length(); i++) {
            Character ch = p.charAt(i);
            if (!map.containsKey(ch)) {
                pInfoArr[id]++;
                map.put(ch, id++);
            } else {
                int index = map.get(ch);
                pInfoArr[index]++;
            }
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int start = i;
            int end = i + p.length() - 1;
            int scan = start;
            int[] compare = new int[p.length()];
            while (scan <= end) {
                Character sch = s.charAt(scan);
                int sid = map.getOrDefault(sch, -1);
                if (sid != -1) {
                    if (compare[sid] >= pInfoArr[sid]) {
                        break;
                    } else {
                        compare[sid]++;
                        scan++;
                    }
                } else {
                    i = scan; //滑动
                    break;
                }
            }
            if (scan == end + 1) ans.add(start);

        }

        return ans;
    }
}
