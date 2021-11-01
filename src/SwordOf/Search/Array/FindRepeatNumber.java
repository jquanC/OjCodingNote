package SwordOf.Search.Array;

import java.util.HashSet;

public class FindRepeatNumber {
    /*循环移位做法*/
    public int findRepeatNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            else if (nums[nums[i]] == nums[i]) {
                ans = nums[i];
                break;
            } else {
                /*如果目的躺着的不是正确的函数，就一直发送给它;做法是和当前i位置的数交换
                * 终止挑战是 nums[i] = i ; nums[nums[i]] = nums[i]
                * for循环进入下一步*/
                while (nums[nums[i]] != nums[i]) {
                    int changeEle = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = changeEle;
                }
            }

        }
        return ans;
    }

    /*[2, 3, 1, 0, 2, 5, 3]*/
    /*Out：0 , Correct :2*/
    /*set做法*/
    /*public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e:nums){
            if(set.contains(e)){
                return e;
            }else set.add(e);
        }
    return 0;
    }*/
}
