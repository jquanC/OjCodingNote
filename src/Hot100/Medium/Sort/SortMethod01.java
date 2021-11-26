package Hot100.Medium.Sort;

import org.junit.Test;

import java.util.Arrays;

public class SortMethod01 {
    //复习一下快排，顺便和使用Arrays.sort()的性能对比一下，嘿嘿

    public void quickSort(int[] nums,int l,int r){
        if(r<=l) return ;
        int i=l,j=r;
        int temp=nums[i];
        while(i<j){
            while(i<j && nums[j]>=temp) j--; //nums[j]>=temp 必须带等号，否则对于有重复数组的情况，可能会死循环。e.g.nums{1,2,5,6,36,7,7,122,34,3},nums[5]=nums[6]=1，会一直停留在i=5,j=6
            nums[i]=nums[j];
            while(i<j && nums[i]<=temp) i++;
            nums[j]=nums[i];
        }
        nums[i]=temp;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
    @Test
    public void test() {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
