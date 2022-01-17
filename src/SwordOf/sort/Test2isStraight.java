package SwordOf.sort;

import org.junit.Test;

public class Test2isStraight {
    public boolean isStraight(int[] nums) {
        quickSort(nums,0,4);

        int couZero =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                couZero++;
                continue;
            }

            if(nums[i]+1==nums[i+1]){
                continue;
            }else if(nums[i] == nums[i+1]){
                return false;
            }else if(couZero >= nums[i+1]-nums[i]-1){
                couZero -= nums[i+1] - nums[i]-1;
            }else return false;

        }
        return true;

    }
    private void quickSort(int[] nums,int start,int end){
        if(start>=end) return;
        int left = start,right = end;
        int sentinel = nums[start];
        while(left<right){
            while(nums[right]>=sentinel && left<right) right--;
            nums[left] = nums[right];
            while(nums[left]<=sentinel && left<right) left++;
            nums[right] = nums[left];
        }
        nums[left] = sentinel;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);

    }

    @Test
    public void test(){
        int [] nums = new int[]{0,0,8,5,4};
        System.out.println(isStraight(nums));
    }

}
