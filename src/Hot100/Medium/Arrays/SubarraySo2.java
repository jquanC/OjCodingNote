package Hot100.Medium.Arrays;

import java.util.HashMap;

public class SubarraySo2 {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();//map<sum02i,cont>, 显然sum02i可能是重复的

        int sum02i = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum02i += nums[i];
            if(sum02i == k) res++;//[0,i]恰好是 k 的情况
            /*此时map的累加和考虑的范围是[0，i-1]*/
            res += map.getOrDefault(sum02i - k,0);
            map.put(sum02i, map.getOrDefault(sum02i, 0) + 1);
        }
        return res;
    }
}
