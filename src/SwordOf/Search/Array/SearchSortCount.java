package SwordOf.Search.Array;

import org.junit.Test;

public class SearchSortCount {
    /*统计一个数字在排序数组中出现的次数。*/

    /*3-方法2在最坏情况还是可能是O（n）
     * 最优解就是 用一次最左二分+一次最右二分*/
    public int search(int[] nums, int target) {
        int leftBound = leftMaxBinarySearch(nums,target);
        int rightBound = rightMaxBinarySearch(nums,target);
        if(leftBound == -1 || rightBound == -1) return 0;
        return rightBound-leftBound+1;
    }

    public int rightMaxBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = -1;
        while (left < right) {
            mid = (left + right) / 2 + 1;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //不管while有没有进去，这里都符合
        mid = (left + right) / 2;//实际上，nums[left] = nums[right],因为出循环 left =right
        return nums[mid] == target ? mid : -1;

    }

    /*返回index*/
    public int leftMaxBinarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //不管while有没有进去，这里都符合
        mid = (left + right) / 2;//实际上，nums[left] = nums[right],因为出循环 left =right
        return nums[mid] == target ? mid : -1;//在接收端通过mid是不是-1来判断是否有没有target元素

    }

    /*2-最左二分,修改条件，不要一找到就返回*//*

    public int search(int[] nums, int target) {
        if(nums.length ==0) return 0;

        int left = 0,right = nums.length-1;
        int mid = 0 ;
        while(left<right){
            mid = (left+right)/2;//寻找最左目标，向下取整；寻找最右目标，要向上取整；
            if(target == nums[mid]){
                right = mid;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        */
    /*经过while有哪些情况呢？
     * 有target，找到最左元素
     * 有target,但没进入过while，数组只有1个元素时
     * 无target,但没进入过while*//*

        //以上2种可以统一得到mid下班
        mid = (left+right)/2;
        int cou=0;
        while(mid+cou<nums.length &&nums[mid+cou] == target){
            cou++;
        }
        return  cou;

    }
*/

    /*1-基本二分*/
   /* public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(index == -1) return  0 ;//找不到

        int total = 1;
        int stepLen = 1;
        while (index - stepLen >= 0 || index + stepLen < nums.length) {
            if (index + stepLen < nums.length && nums[index + stepLen] == nums[index])
                total++;
            if (index - stepLen >= 0  && nums[index - stepLen] == nums[index])
                total++;

            stepLen++;
        }
        return total;
    }*/

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 3, 3, 4, 5};
        int res1 = leftMaxBinarySearch(arr, 3);
        System.out.println(res1);
        int res2 = rightMaxBinarySearch(arr, 3);
        System.out.println(res2);
    }
}
