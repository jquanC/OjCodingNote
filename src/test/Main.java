package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();

//        int[] arr = new int[]{1,2,3,4};
//        int[] arr = new int[]{1,1,1,2,2,2};
        int[] arr = new int[]{1,2,2,2};
        List<List<Integer>> ans =  find(arr);
        for(List<Integer> e:ans){
            System.out.println(e);
        }
    }
//a+b = c
    public static List<List<Integer>> find(int[] nums){
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){ //枚举c
            int t = nums.length-1;
            for(int j = 0;j<t;j++){ // 枚举a
                while(t>j){ //枚举 b
                    if(nums[j]+nums[t] == nums[i] && i!=j && i!=t){
                        List<Integer> oneAns = new ArrayList();
                        oneAns.add(nums[i]);
                        oneAns.add(nums[j]);
                        oneAns.add(nums[t]);
                        ans.add(oneAns);
                        break;
                    }
                    if(nums[j]+nums[t] < nums[i]){
                        break;
                    }
                    //>的情况
                    t--;
                }



            }
        }

        return ans;
    }
}
