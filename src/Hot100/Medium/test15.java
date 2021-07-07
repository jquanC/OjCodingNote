package Hot100.Medium;

import java.util.Arrays;

public class test15 {
    public static void main(String atgs[]){
        LeftAndRightBinarySearch15 LRSearch = new LeftAndRightBinarySearch15();
        int[] nums={1,2,3,4,4,4,6,7,7,8,10,13,13,14,15};
        System.out.println("Search num x，its index is "+LRSearch.binarySearchV2(nums,4));
       // System.out.println("Search num x，its index is "+LRSearch.binaryLeftSearch(nums,4));
        System.out.println("Search num x，its index is "+LRSearch.binaryRightSearch(nums,4));
        System.out.println("Search num x range is "+ Arrays.toString(LRSearch.searchRange(nums,4)));
    }
}
