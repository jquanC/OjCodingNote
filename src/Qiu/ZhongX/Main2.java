package Qiu.ZhongX;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(nums);
        int pl = 0;
        int pr = nums.length-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                pl = i;
                break;
            }
        }
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]!=nums[i+1]){
                pr = i;
                break;
            }
        }
        if(pr<pl) System.out.println(0);
        else System.out.println(pr-pl+1);
    }
}
