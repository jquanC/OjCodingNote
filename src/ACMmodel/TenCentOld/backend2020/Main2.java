package ACMmodel.TenCentOld.backend2020;

import java.util.Arrays;
import java.util.Stack;

public class Main2 {

    public int[] findBuilding (int[] heights) {
        // write code here
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                ans[i]+=0;
                stack.push(heights[i]);
                continue;
            }
            ans[i]+=stack.size();
            while(!stack.isEmpty() && stack.peek()<=heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i]+=0;
                stack.push(heights[i]);
                continue;
            }
            ans[i]+=stack.size();
            while(!stack.isEmpty() && stack.peek()<=heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);
        }
        return ans;
    }

}
