package Hot100.Medium;

import java.util.Arrays;

public class ThreeNumSumSimilarToTarget08 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int minAbsDiffer = Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<nums.length-2;i++){
            if( i>0 && i<nums.length-2 && nums[i]==nums[i-1]) continue; //寻找不重复元素
            int remainSum = target - nums[i];
            int indexThird = nums.length-1;
            int j = i+1;
            while(j<indexThird){
                if(Math.abs(nums[j]+nums[indexThird]-remainSum)< minAbsDiffer){
                    res = nums[j]+nums[indexThird] +nums[i];
                    minAbsDiffer = Math.abs(res- target);
                }
              /*不同于三数之和的题目，a+b+c=0 ,在第二个for循环里面，b从最小开始增大，c从最大开始减少，固定b，找到一个c时，
              * 由于下一个值b‘>b，要使得和为0，c'一定小于c
              * 在本题中，是求最接近的值，且题目说了唯一；
              * 那么找到a+b+c=0，直接return j
              * 对于一对b,c值，通过判定是否更接近target，来觉得是否采纳这对b和c;
              * 不管接纳与否，如何寻找下一对b和c是这样的（本题双指针的移动逻辑）：
              * a+b+c > target ,c减少(indexC--) ;增加b无意义
              * a+b+c < target ,b增加
              * 每次移动b和c,都要做这样的判定；
              * 同样，这样的时间复杂度是o(n^2)；
              * */
                if(nums[i]+nums[j]+nums[indexThird]>target){
                    indexThird--;
                }else{
                    j++;
                }

            }
        }
        return res;
    }

}
