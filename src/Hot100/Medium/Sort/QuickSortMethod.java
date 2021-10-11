package Hot100.Medium.Sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortMethod {

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, 0, pos-1);
            quickSort(nums, pos + 1, right);
        }
    }

    /**
     * quickSort 和
     * partition 均接受的的是nums 有效下标
     */
    private int partition(int[] nums, int left, int right) {

        int scanLeft = left - 1;
        int x = nums[right];
        for (int scanRight = left; scanRight < right; scanRight++) {
            if (nums[scanRight] <= x) {
                scanLeft++;
                swap(nums, scanLeft, scanRight);
            }
        }
        swap(nums, scanLeft + 1, right);

        return scanLeft + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    @Test
    public void test(){
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};
        quickSort(nums,0,nums.length -1);
        System.out.println(Arrays.toString(nums));

    }
}
