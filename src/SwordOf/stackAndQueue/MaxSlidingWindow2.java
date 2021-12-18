package SwordOf.stackAndQueue;

import com.sun.corba.se.impl.ior.StubIORImpl;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class MaxSlidingWindow2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return new int[0];
        if (k == 1) return nums;

        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);

            while(i-deque.peekFirst()+1>k) deque.pollFirst();

            res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;

    }


    @Test
    public void test() {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int[] arr = new int[]{1, -1};
        int[] res = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
