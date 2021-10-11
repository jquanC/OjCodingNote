package Hot100.Medium.Sort;

import com.sun.media.sound.RIFFInvalidDataException;
import org.junit.Test;

import java.util.Random;

/**
 * 快速排序寻找第k大元素
 * ！！ 1<=k<= length
 * 理解第k大： 2233445556： 6是第1大元素，5是第二大元素，第三大元素还是5 ，4是第5大元素，第6大元素还是4
 * 基本版本
 */
public class FindKeleSo1 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    /**
     * find -pos;
     */
    public int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) return nums[left];

            int pos = partition(nums, left, right);
            int len = right - pos+1;

            if (len == k)
                return nums[pos];
            else if(k < len) return quickSelect(nums,pos+1,right,k);
            else return quickSelect(nums,left,pos-1,k-len);
    }

    /**
     * quickSort 和
     * partition 均接受的的是nums 有效下标
     */
    private int partition(int[] nums, int left, int right) {

        int scanLeft = left - 1;
        Random random = new Random();
//      int x = nums[right];
        int xRandom = left + random.nextInt(right - left + 1);
        swap(nums, xRandom, right);
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

    /*[3,2,1,5,6,4]*/
    @Test
    public void test() {

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int ele = findKthLargest(nums, 2);
        System.out.println(ele);

    }

}
