package Hot100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoFourNumSum09 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //寻找不一样的i
            while (i > 0 && i<nums.length - 3 && nums[i] == nums[i - 1]) i++; // && i<nums.length - 3 为了数组元素都一样时，判定时数组下标越界
            for (int j = i + 1; j < nums.length - 2; j++) {
                //寻找不一样的j
                while (j > i + 1 && j<nums.length-2 && nums[j] == nums[j - 1]) j++; //&& j<nums.length-3 为了数组元素都一样时，判定时数组下标越界

                int index_t = nums.length - 1;
                for (int k = j + 1; k < index_t; k++) {
                    //寻找不一样的K
                    while (k > j + 1 && k<index_t &&  nums[k] == nums[k - 1]) k++;

                    int z = index_t;
                    while( z>k){
                        if (nums[i] + nums[j] + nums[k] + nums[z] == target) {
                            List<Integer> ans = new ArrayList<>();
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[k]);
                            ans.add(nums[z]);
                            ansList.add(ans);
                            index_t = z-1;
                            break;
                        }
                        z--;
                    }

                }
            }
        }
        return ansList;

    }
}
