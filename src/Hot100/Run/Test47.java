package Hot100.Run;

import Hot100.Medium.So47LongestConsecutiveSequence;

public class Test47 {
    public static void main(String args[]){
        So47LongestConsecutiveSequence so = new So47LongestConsecutiveSequence();
        int [] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(so.longestConsecutive(nums));
    }
}
