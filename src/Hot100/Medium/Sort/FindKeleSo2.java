package Hot100.Medium.Sort;

import com.sun.javaws.security.AppContextUtil;
import org.junit.Test;

import java.util.Random;

/**
 * 堆排序寻找第k大元素
 * 基本版本
 */
public class FindKeleSo2 {
    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(nums, nums.length-1);
        heap.heapify();
        int ele=-1;
        for (int i = 0; i < k; i++) {
            ele = heap.maxElement();
        }
        return ele;
    }


    /*[3,2,1,5,6,4]*/
    @Test
    public void test() {

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int ele = findKthLargest(nums, 2);
        System.out.println(ele);

    }

    class Heap {
        int[] nums;
        int maxPos;

        public Heap(int[] nums, int len) {
            this.nums = nums;
            this.maxPos = len;
        }

        public void heapify() {

            for (int i = (maxPos - 1) / 2; i >= 0; i--) {
                int left = i * 2 + 1 <= maxPos ? i * 2 + 1 : -1;
                int right = i * 2 + 2 <= maxPos ? i * 2 + 2 : -1;

                if (left != -1 && nums[left] > nums[i]) {
                    exchange(left, i);
                }
                if (right != -1 && nums[right] > nums[i]) {
                    exchange(right, i);
                }

            }
        }

        public int maxElement() {
            int ele = nums[0];
            exchange(0, maxPos);
            maxPos--;
            heapify();
            return ele;

        }

        private void exchange(int a, int b) {
            int temp = nums[b];
            nums[b] = nums[a];
            nums[a] = temp;
        }
    }
}
