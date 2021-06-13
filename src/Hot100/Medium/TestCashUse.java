package Hot100.Medium;

import Hot100.Medium.Sort.SortMethod01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestCashUse {
    public static void main(String args[]){
        /*char [] arr = new char[5];//默认初值是 ‘\u0000’ 看起来像空格，实际是一个Unicode字符
        for(int i=0;i<5;i++) System.out.println(arr[i]);*/
        /*System.out.println(Integer.MAX_VALUE);
        System.out.println((-1)*Integer.MIN_VALUE);*/
        //
        /*int[] test = new int[]{1,2,5,6,36,7,7,122,34,3};
        SortMethod01 sortMethod = new SortMethod01();
        sortMethod.quickSort(test,0,test.length-1);
        System.out.println(Arrays.toString(test));*/
        //
        List<String>[] dp = new ArrayList[3];
        System.out.println("test:");
        //dp[2].add("ssss");
        List<String> li = new ArrayList<>();
        li.add("sss");
        dp[2] = li;
        dp[2].add("xxxx");
        System.out.println(Arrays.toString(dp[2].toArray()));

    }
}
