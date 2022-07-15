package SwordOf.Redo;

import java.util.Arrays;
import java.util.Comparator;

public class SW45 {
}
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> com = new Comparator<String>(){

            public int compare(String o1,String o2){
                String str1 = o1+o2;
                String str2 = o2+o1;
                if(str1.compareTo(str2) <=0) return -1;//
                else return 1;
            }

        };
        Arrays.sort(strs,com);
        String ans = "";
        for(String e: strs){
            ans += e;
        }
        return ans;

    }
}