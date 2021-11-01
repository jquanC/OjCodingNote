package SwordOf.Search.Array;

public class MissingNumber {
    /*依题意，数组长度至少是1*/
    public int missingNumber(int[] nums) {
        if(nums.length == 1) return nums[0]==0 ? 1 :0;
        int left = 0,right = nums.length-1,mid = 0;
        while(left<=right){
             mid = (left+right)/2;

            if(mid == right && left == nums.length-1){//来到数组最右边，前面都符合 nums[mid] = mid
                return nums[mid]+1;
            }else if(mid == left && right == 0){//来到数组最左边，前面都符合 nums[mid] = mid+1
                return 0;
            }else if(nums[mid]==mid && nums[mid+1]==mid+2){
                break;
            }else if(nums[mid] ==mid && nums[mid+1] == mid+1){
                left = mid+1;
            }
            else{//(nums[mid] == mid+1 && nums[mid+1]==mid+2)
                right = mid;//right = mid 不是 mid+1
            }
        }
         return nums[mid]+1;

    }
}

