package Hot100.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SoSumIsZero06 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        System.out.println("sorted:"+Arrays.toString(nums));
      //  Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int resSum= 0 - nums[i];
            int indexC = nums.length-1;
            for(int j=i+1;j<indexC;j++){ //细节1
                //确定indexC,初始为
              //  if(nums[indexC]+nums[j]< resSum && indexC>j) continue;
                while(nums[indexC]+nums[j]>resSum && indexC>j)  indexC--;
                if(nums[indexC]+nums[j] == resSum && indexC>j){ //细节2：注意判断 indexC>j ;从循环出来，一定要注意可能的取值
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[indexC]);
                    if(!resList.contains(list)){
                        resList.add(list);
                    }

                }
            }
        }
        return resList;

    }
    //复习一下快排，顺便和使用Arrays.sort()的性能对比一下，嘿嘿
    public void quickSort(int[] nums,int l,int r){
        if(r<=l) return ;
        int i=l,j=r;
        int temp=nums[i];
        while(i<j){
            while(i<j && nums[j]>=temp) j--; //nums[j]>=temp 必须带等号，否则对于有重复数组的情况，可能会死循环。e.g.nums{1,2,5,6,36,7,7,122,34,3},nums[5]=nums[6]=1，会一直停留在i=5,j=6
            nums[i]=nums[j];
            while(i<j && nums[i]<=temp) i++;
            nums[j]=nums[i];
        }
        nums[i]=temp;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
}
