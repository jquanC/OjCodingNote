package Hot100.Medium;

import java.util.*;

public class So47LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
      /*  TreeSet<Integer> tSet = new TreeSet<>();*/
        HashSet<Integer> hSet = new HashSet<>();
        /*for (int i = 0; i < nums.length; i++) {
            tSet.add(nums[i]);// i 是不重要的; 同一个桶/key-nums[i],有多个指，只是说明有重复元素而已
        }*/
        for (int i = 0; i < nums.length; i++) {
            hSet.add(nums[i]);// i 是不重要的; 同一个桶/key-nums[i],有多个指，只是说明有重复元素而已
        }
        int countMax=1;
        for(int num:hSet){
            if(!hSet.contains(num -1)){
                int curNum = num;
                int count = 1;
                while(hSet.contains(curNum+1)){
                    curNum++;
                    count++;
                }
                countMax = Math.max(countMax,count);
            }
        }

       /* Iterator<Integer> it = tSet.iterator();
        int pre = it.next();
        int count = 1;
        int countMax = count;
        while (it.hasNext()) {
            int cur = it.next();
            if (pre+1 == cur) {
                count++;
            } else {

                if (count > countMax) countMax = count;
                count = 1;
            }
            pre = cur;
        }
        if(count>countMax) countMax = count;*/
        return countMax;

    }

}
