package Qiu.MiHaYou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Main2 so = new Main2();
//        int[] nums = new int[]{3,1,4};
        int[] nums = new int[]{1,2,3,5,1,2,3,4,2,1};
        int[] ans = so.temperatures(nums);
        System.out.println(Arrays.toString(ans));


    }
    //单调栈，存下标
    public int[] temperatures (int[] dailyTemperatures) {
        int len = dailyTemperatures.length;
        int[] nextHigh = new int[len];
        nextHigh[len-1]=0;
        Stack<Integer> stack = new Stack();
        stack.push(len-1);
        for(int i=len-2;i>=0;i--){//empty()

            if(dailyTemperatures[i]<dailyTemperatures[stack.peek()]){
                nextHigh[i] = stack.peek()-i;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && dailyTemperatures[i]>=dailyTemperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextHigh[i] = stack.peek()-i;
                stack.push(i);
            }else{
                stack.push(i);
                nextHigh[i] = 0;
            }
        }
        return nextHigh;


    }
}
