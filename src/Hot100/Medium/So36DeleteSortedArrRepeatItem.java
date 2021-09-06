package Hot100.Medium;

public class So36DeleteSortedArrRepeatItem {
    public int removeDuplicates(int[] nums){
        //我的题解
       /* int i=1,j=1,count=1;//i:下一个被采纳元素应放置的位置。
        for(j=1;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){ //新的不同元素
                count=1;
                nums[i] = nums[j];
                i++;
            }else  if(nums[j]==nums[j-1] && count<2){ //采纳第二个重复元素
                count++;
                nums[i]=nums[j];
                i++;
            }else if(nums[j] == nums[j-1] && count>=2){
                count++;
            }
        }
        return i;*/

        //参考答案的实现，逻辑更清晰

        int slow =2;
        int fast=2;
        for(;fast<nums.length;fast++){
            if(nums[fast] != nums[slow-2] ){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
