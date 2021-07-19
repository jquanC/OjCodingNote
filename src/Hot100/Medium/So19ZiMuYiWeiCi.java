package Hot100.Medium;

import java.util.*;

public class So19ZiMuYiWeiCi {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] vis = new int[strs.length];
        List<String> oneCuster = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length - 1; i++) {
            if (vis[i] == 0) {
                oneCuster.add(strs[i]);
                vis[i] = 1;
            } else continue;
            for (int j = i + 1; j < strs.length; j++) {
                //判断是否已经归类
                if (vis[j] == 1) continue;
                else {  //判断是不是一类
                    if (isCuoWeiString(strs[i], strs[j])) {
                        oneCuster.add(strs[j]);
                        vis[j] = 1;
                    }

                }


            }
            ans.add(new ArrayList<>(oneCuster));
            oneCuster.clear();
        }
        if (vis[strs.length - 1] == 0) {
            oneCuster.add(strs[strs.length - 1]);
            ans.add(oneCuster);
        }
        return ans;
    }

    //自定义一个比较函数
    private boolean isCuoWeiString(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();//<K,v>
        for (int i = 0; i < str1.length(); i++) {
            char key = str1.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }

        }
        for (int i = 0; i < str2.length(); i++) {
            char com = str2.charAt(i);
            if (!map.containsKey(com)) {
                return false;
            } else {
                map.put(com, map.get(com) - 1);
            }
        }
        //Collection<Integer> values = map.values();
        List<Integer> resVal = new ArrayList<>(map.values());
        for (int e : resVal
        ) {
            if (e != 0) return false;
        }
        return true;
    }

}
