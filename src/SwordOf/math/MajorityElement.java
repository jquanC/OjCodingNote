package SwordOf.math;

import org.junit.Test;

import java.util.Random;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        //解法一 用基于快排的随机快速选择，选择中位数
        int k = nums.length/2;
        return quickSelectKpos(nums,0,nums.length-1,k);


    }
    public int quickSelectKpos(int[]nums,int start,int end,int k){
        int partiPos = randomPartition(nums,start,end);
        if(partiPos == k) return nums[k];
        else if(partiPos <k ){
            return quickSelectKpos(nums,partiPos+1,end,k);
        }else return quickSelectKpos(nums,start,partiPos-1,k);
    }
    public int randomPartition(int[] nums,int start,int end){
        if(start>=end) return start;

        Random random = new Random();
        int exchangePos = start + random.nextInt(end-start+1);
        int sentinel = nums[exchangePos];
        int tem = nums[start];
        nums[start] = nums[exchangePos];
        nums[exchangePos] = tem;

        int left = start;
        int right = end;
        while(left<right){
            while(nums[right]>=sentinel && left<right) right--;
            nums[left] = nums[right];
            while(nums[left]<= sentinel && left<right) left++;
            nums[right] = nums[left];
        }
        //最后这里忘记放置哨兵了
        nums[left] = sentinel;
        return left;
    }
    @Test
    public void test(){
        int[] nums = new int[]{3,2,3};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    @Test public void test2(){
        Random random = new Random();
        for(int i =0;i<20;i++){
            int pos = 0+random.nextInt(2-0+1);
            System.out.println(pos);
        }



    }
}

