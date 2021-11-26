package SwordOf.sort;

import org.junit.Test;

import java.util.Arrays;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;

    }

    public void quicksort(int[] arr, int left, int right) {
        if (left >= right) return;

        int start = left;
        int end = right;
        int sentinel = arr[start];
        while (left < right) {
            while (arr[right] >= sentinel && right > left) right--;
            arr[left] = arr[right];
            while (arr[left] <= sentinel && left < right) left++;
            arr[right] = arr[left];
        }
        //出来时，left=right,sentinel 的最终位置
        arr[left] = sentinel;
        quicksort(arr, start, left - 1);
        quicksort(arr, left + 1, end);
    }

    @Test
    public void test() {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
