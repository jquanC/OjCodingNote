package SwordOf.bitAlgo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] bitcou = new int[32];
        for(int i=0;i<nums.length;i++){
            int check = 1;
            for(int j=0;j<31;j++){ //实际符号位不表示；
                if( (nums[i] & check) !=0 ) bitcou[j]++;
                check = check << 1;
            }
        }
        int factor = 1;
        int res=0;
        for(int i=0;i<31;i++){
            if(i!=0) factor*=2;
            if(bitcou[i] %3 == 1) res = res+factor;
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums = new int[]{3,4,3,3};
        int res = singleNumber(nums);
        System.out.println(res);
    }
    @Test
    public void testList(){
        List<int[]> res1 = new ArrayList<>();
        List<int[]> res2 = new LinkedList<>();
        int [] arr1 = new int[]{1,2,3};
        int [] arr2 = new int[]{2,3,4};

        res1.add(arr1);
        res1.add(arr2);

        res2.add(arr1);
        res2.add(arr2);

        int[][] tar1 = res1.toArray(new int[res1.size()][]);
        int[][] tar2 = res2.toArray(new int[res2.size()][]);


    }
    public int lastRemaining(int n, int m) {

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++) list.addLast(i);

        int index = 0;
        for(int i=1;i<=n-1;i++){
            int len = list.size();
            index = (index+((m % len) -1+len))%len;
            list.remove(index);
            index = index % list.size();

        }
        return list.getFirst();

    }
    @Test
    public void testRemain(){
        int res = lastRemaining(5,3);

    }
}
