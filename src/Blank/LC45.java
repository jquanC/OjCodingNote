package Blank;

import java.util.Arrays;
import java.util.Comparator;

public class LC45 {
    public String minNumber(int[] nums) {

        String [] srr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            srr[i] = ""+nums[i];
        }
        Arrays.sort(srr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String one = o1+o2;
                String two = o2+o1;
                if(one.compareTo(two)>0){
                    return  1;
                }else return -1;

            }
        });
        String ans = "";
        for(String e:srr){
            ans+=e;
        }
        return ans;
    }
}
