package SwordOf.math;

import org.junit.Test;

import java.util.Random;

public class MajorityElement2 {

    public int majorityElement(int[] nums) {
        int compareCurNum = nums[0];
        int curNumCou = 1;
        for(int i=1;i<nums.length;i++){
            if(curNumCou == 0){
                compareCurNum = nums[i];
                curNumCou++;
            }else{
                if(nums[i]==compareCurNum) curNumCou++;
                else{
                    curNumCou--;
                }
            }

        }
        return compareCurNum;
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

