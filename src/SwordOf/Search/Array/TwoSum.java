package SwordOf.Search.Array;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;

        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
                //                return res;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = new int[]{2,7,11,15};
        int[] res =twoSum(arr,9);
        System.out.println(Arrays.toString(res));
    }
}
