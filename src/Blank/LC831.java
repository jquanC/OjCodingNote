package Blank;

import java.util.Arrays;

public class LC831 {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        int r = len - 1;
        int l = 0;
        int ans = 0;
        Arrays.sort(people);
        boolean[] use = new boolean[len];

        while (r >= 0) {
            if (!use[r]) { //找配对
                boolean find = false;
                l = 0;
                int markL = -1;
                while (l < r && people[r] + people[l] <= limit) {
                    if (use[l] == false) {
                        markL = l;
//                        l++;
                        find = true;
                    }
                    l++;
                }
                if (find) {
                    use[markL] = true;
                }
                ans++;
                use[r] = true;
            }
            r--;

        }
        return ans;
    }
}
