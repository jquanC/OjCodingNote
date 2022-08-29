package Qiu.DJI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1{

    public int cal(int[] nums){
        int len = nums.length;
        int[] get =new int[len+1];
        int[] noget = new int[len+1];
        get[1] = nums[0];
        noget[1] = 0;

        for(int i=2;i<=len;i++){
//            get[i] = Math.max(noget[i-1],get[i-2]+nums[i-1]);
            get[i] = Math.max(noget[i-1],get[i-2])+nums[i-1];
            noget[i] = Math.max(noget[i-1],get[i-1]);
        }
        return Math.max(get[len],noget[len]);

    }
}
