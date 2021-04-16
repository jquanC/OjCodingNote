package Hot100.Easy;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            int x;//元素应该映射到的哈希表的 key

            for(int i =0 ;i<nums.length;i++){
                x = (nums[i]-1)%n; //x 是数nums[i] 该去的位置，逻辑上这里求余实际是没必要的，但不求余通过不了编译
                nums[x] = nums[x]+n ;//+n 的目的，为了标记该数出现，也方便还原数组
            }

            List<Integer> vanishNum = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=n) vanishNum.add(i+1);
                else nums[i] %= n; //还原nums[]
            }
            return vanishNum;

        }

}
