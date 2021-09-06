package Hot100.Medium;

public class So37SearchMatrixII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1 && target != nums[0]) return false;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                /*对于有重复元素，可能有nums[l]=nums[mid]=nums[r],这种情况下，下面利用
                “有序旋转数组二分时必有一半是有序区间”的性质来缩小二分查找区间无法直接观察出来，解决小段是缩小l 和 r  */
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                //说明区间 [left , mid]有序，利用有序区间，确定下一个二分查找区间;这个地方必须带等号，如果左半部分是有序的区间，那么一定是包含nums[mid]的
                if (target >= nums[left] && target <= nums[mid]) { //target 在区间内
                    right = mid - 1; //为什么动right ,因为left 已经是有序区间的界了呀
                } else {
                    left = mid + 1;
                }
            } else { // 说明区间[mid,right]有序； 对于旋转区间，总有一半区间是有序的
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return false;
    }
}
