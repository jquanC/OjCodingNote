package Hot100.Run;

import Hot100.Medium.So36DeleteSortedArrRepeatItem;

public class Test36 {
    public static void main(String args[]){
        So36DeleteSortedArrRepeatItem so = new So36DeleteSortedArrRepeatItem();
        int[] nums = new int[]{2,5,6,0,0,1,2};
        int len = so.removeDuplicates(nums);
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
