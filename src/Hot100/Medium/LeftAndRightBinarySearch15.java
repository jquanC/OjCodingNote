package Hot100.Medium;

public class LeftAndRightBinarySearch15 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binaryLeftSearch(nums,target);
        int rightIndex = binaryRightSearch(nums,target);
        return new int[]{leftIndex,rightIndex};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { //(1)<:[left,left),出while循环后要多检查nums[left]这个值   (2)<=:[left,right] ,left>right
            int mid = (left + right) / 2;

            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    public int binarySearchV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) { //[left,left),出循环时left = right
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        if (nums[left] == target) return left;
        else return -1;

    }

    public int binaryLeftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) { //[left,left),出循环时left = right
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                right = mid;
                left = left; //缩小区间继续找[left不变包括左边可能有的元素, right缩小到mid至少有解]
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        if (nums[left] == target) return left;
        else return -1;

    }



    public int binaryRightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) { //[left,left),出循环时left = right
            int mid = (left + right) / 2 +1; // 相比较于寻找最左Index,这里要向右取整，否则会死循环, e.g. L=3,R=4 ,nums[L]=nums[R]=target  情况

            if (target == nums[mid]) {
                left = mid;
                right = right; //缩小区间继续找[left不变包括左边可能有的元素, right缩小到mid至少有解]
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        if (nums[right] == target) return right;
        else return -1;
    }

}
