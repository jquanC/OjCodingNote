package Hot100.Medium;

import org.junit.Test;

public class FindReaptedNum {
    public int findDuplicate(int[] nums) {
        int slow =0,fast=0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast); //index 才是 结点的标识

        slow=0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;// 注意：是slow 不是 nums[slow]

    }

    @Test
    public void test(){
        int [] nums = new int[]{1,3,4,2,2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
}
