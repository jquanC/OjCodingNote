package SwordOf.sort.QuickSort;

import org.junit.Test;

import java.util.Arrays;
/*随机化快排，只不过在选择哨兵时，随机选择一个元素，和nums[begin]或者nums[end]交换以下即可*/
public class QuickSortImpl {

    public int[] sort(int[] nums,int begin,int end){
        quickSort(nums,begin,end);
        return nums;
    }
    public void quickSort(int[] nums,int begin,int end){
        if(begin >= end) return ;
//        int pos = positionMethod1(nums,begin,end);
        int pos = positionMethod2(nums,begin,end);
        quickSort(nums,begin,pos-1);
        quickSort(nums,pos+1,end);


    }
    /*一次position 的过程，确定一个主元最终位置并放置好的过程。*/
    public int positionMethod1(int[]nums,int begin,int end){
        int left = begin;
        int right = end;
        int sentinel=nums[begin];
        while(left<right){
            while(nums[right]>=sentinel && right>left) right--;
            nums[left] = nums[right];
            while(nums[left]<=sentinel && left < right) left++;
            nums[right]=nums[left];
        }
        nums[left] = sentinel;
        //出来时 left = right,是sentinel的位置
        return left;
    }
    /*算法导论中提及的解法，方法返回主元的位置*/
    public int positionMethod2(int[]nums,int begin,int end){
        int left = begin-1; //left指向“小于sentinel区间”的最后一个元素
        int right; //right向“大于等于sentinel区间”的最后一个元素
        int sentinel = nums[end]; // 主元是 nums[edn], 寻找Position的过程就是确认主元最终位置的过程
        for(right=begin;right<end;right++){
            if(nums[right]<=sentinel){
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left+1];
        nums[left+1] = nums[right];
        nums[right] = temp;

        return left+1;
    }
    @Test
    public void test(){
        int[] nums1 = new int[]{1,2,4,12,15};
        int[] nums2 = new int[]{18,14,12,4,2,1};
        int[] nums3 = new int[]{4, 5, 1, 6, 6,2, 7, 3, 8};
        System.out.println(Arrays.toString(sort(nums1,0,nums1.length-1)) );
        System.out.println(Arrays.toString(sort(nums2,0,nums2.length-1)) );
        System.out.println(Arrays.toString(sort(nums3,0,nums3.length-1)) );
    }
}
