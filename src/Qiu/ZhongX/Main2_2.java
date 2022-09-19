package Qiu.ZhongX;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        HashMap<Integer,Integer> map = new HashMap();
        int maxNum=-0x3f3f3f3f;
        int minNum = 0x3f3f3f3f;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minNum) minNum = nums[i];
            if(nums[i]>maxNum) maxNum = nums[i];

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans = nums.length-map.get(maxNum)-map.get(minNum);
        ans = Math.max(0,ans);
        System.out.println(ans);


    }
}
