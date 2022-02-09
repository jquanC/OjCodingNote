package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;



public class ReversePairs {

    public int reversePairs(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        return reverseProcess(nums,0,nums.length-1);
    }

    private int reverseProcess(int[] nums,int start,int end){
        if(start == end) return 0;
        int mid = (start+end)/2;
        int left = start,right=mid+1;//分为[left,mid][mid+1,end]
        int res = reverseProcess(nums,start,mid)+reverseProcess(nums,mid+1,end);

        int[] temArr = new int[end-start+1];
        int ptr=0,reverseContribute=0;
        while(left<=mid && right<=end){
            if(nums[right]<nums[left]){
                reverseContribute = mid-left+1;
                res+= reverseContribute;
                temArr[ptr++] = nums[right++];
            }else if(nums[right]>nums[left]){
                temArr[ptr++] = nums[left++];
            }else{
                temArr[ptr++] = nums[left++];
            }
        }

        while(left <= mid) temArr[ptr++] = nums[left++];
        while(right<= end) temArr[ptr++] = nums[right++];

        for(int i=start;i<=end;i++){
            nums[i] = temArr[i-start];
        }
        return res;

    }

    @Test
    public void test(){
        int[] nums = new int[]{7,6,5,4};
        int res = reversePairs(nums);
        System.out.println(res);
    }
}
