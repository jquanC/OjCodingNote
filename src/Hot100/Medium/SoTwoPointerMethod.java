package Hot100.Medium;

public class SoTwoPointerMethod {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int currV=0,maxV=0;
        while(i<j){
            currV = (j-i)*minNum(height[i],height[j]);
            if(currV > maxV) maxV = currV;

            if(height[i]>=height[j]) j--;
            else i++;
        }

        return maxV;
    }
    public int minNum(int a ,int b){
        return a>=b ? b : a;
    }
}
