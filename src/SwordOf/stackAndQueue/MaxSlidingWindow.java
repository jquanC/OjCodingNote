package SwordOf.stackAndQueue;

import org.junit.Test;

import java.util.Arrays;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k; i++) {
            res[i] = maxHeadp(nums, i, i + k - 1);
        }
        return res;

    }

    private int maxHeadp(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] temArr = new int[len];
        for (int i = start; i <= end; i++) temArr[i - start] = nums[i];
        //堆化
        for (int i = len / 2-1; i >= 0; i--) {
            int lc = i * 2 + 1, rc = i * 2 + 2;
            //需要考虑有没有孩子左右孩子
            if (lc < len) {
                if (temArr[lc] > temArr[i]) {
                    int temp = temArr[i];
                    temArr[i] = temArr[lc];
                    temArr[lc] = temp;

                }
            }
            if (rc < len) {
                if (temArr[rc] > temArr[i]) {
                    int temp = temArr[i];
                    temArr[i] = temArr[rc];
                    temArr[rc] = temp;
                }
            }
        }
        return temArr[0];
    }
    @Test
    public void test () {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
