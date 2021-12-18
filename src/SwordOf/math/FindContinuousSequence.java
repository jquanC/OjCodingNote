package SwordOf.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left=1 ,right = 2;
        int windowSum = 3;
        List<int[]> resList = new ArrayList<>();
        while(right<target){
            if(windowSum == target){
                int[] oneRes = new int[right-left+1];
                for(int i=left;i<=right;i++) oneRes[i-left]=i;
                resList.add(oneRes);
                //找到一个解后指针右移一次
                right++;
                windowSum+=right;
            }
            if(windowSum < target){
                right++;
                windowSum+=right;
            }else{
                windowSum-=left;
                left++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
    @Test
    public void test(){
       int[][] res = findContinuousSequence(9);
        for(int[] e : res){
            System.out.println(Arrays.toString(e));
        }
    }
}
