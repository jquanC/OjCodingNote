package Hot100.Medium.Arrays;

public class findUnsortedSubarraySo {
    public int findUnsortedSubarray(int[] nums) {

        int right = -1;
        int left = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {

            /*在扫描的过程中，大于当前i后面的情况是未知的
            * 所求的，是当前已扫描的[0，i]中，right的值
            * 发现cur元素比前面扫描数组的最大值小，肯定要修改right，否则前面部分排序后，+上小的cur，就不是有序了；更新right的值（变大），是一个‘宽容’的过程
            * 发现cur元素比前面扫描数组的最大值大，那么前面确定好的right不用修改，right 确定的边界前面之前的元素排序后，最大值都小于right边界之后的元素
            * */
            if (nums[i] >= max) {
                max = nums[i];
            } else { //当前左边的元素最大值，比nums[i]小，
                right = i;
            }

            if (min >= nums[n - i - 1]) {
                min = nums[n - i - 1];
            } else {
                left = n - i - 1;
            }

        }
        return right == -1 ? 0 : right - left + 1;
    }
}
