package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;


public class ReversePairsII {

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length ==0) return 0;

        return mergesort(nums,0,nums.length-1);
    }

    public int mergesort(int[]nums,int start, int end){

        if(start >= end) return 0 ;

        int mid = start+(end-start)/2; //细心，（end-start）/2 is len not mid
        int leftCou = mergesort(nums,start,mid);
        int rightCou = mergesort(nums,mid+1,end);

        //merge and count; note: sub array has sorted

        int[] subArr = new int[end-start+1];
        int mergeCou=0, pleft = mid, pright = end,psub= subArr.length-1;

        while(pleft>=start && pright >=mid+1){
            if(nums[pleft]>nums[pright]){
                mergeCou += pright-mid;
                subArr[psub] = nums[pleft];
                psub--;
                pleft--;
            }else{ // < =
                subArr[psub] = nums[pright];
                psub--;
                pright--;
            }
        }
        while(pleft >= start) subArr[psub--] = nums[pleft--];
        while(pright>=mid+1) subArr[psub--] = nums[pright--];

        int i=0;
        while(i<subArr.length){
            nums[start+i] = subArr[i];
            i++;
        }
        return mergeCou + leftCou + rightCou;

    }


    @Test
    public void test(){
        int[] nums = new int[]{7,6,5,4};
        int res = reversePairs(nums);
        System.out.println(res);
    }
}
