package SwordOf.Search.Array;

public class Exchange {
    public int[] exchange(int[] nums) {
        if(nums ==null) return null;
        int left  = 0;
        int right = nums.length -1;
        while(left<right){
            //寻找当前最左偶数
            while(left<right && nums[left]%2!=0) left++;
            //寻找当前最右奇数
            while(left<right && nums[right]%2!=1) right--;
            //交换当前left和right所指的数
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;

    }

}
