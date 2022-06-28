package comp.sf;

import java.util.Arrays;

public class main02 {
    public int findMaxCI(int[] nums) {
        int maxLen = 1;
        int curLen = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                curLen++;
                if(curLen>maxLen) maxLen = curLen;
            }else{
                curLen = 1;
            }
        }
        return maxLen;
    }

}
