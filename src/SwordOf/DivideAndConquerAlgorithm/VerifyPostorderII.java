package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

public class VerifyPostorderII {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorderRecurse(postorder,0,postorder.length-1);
    }
    public boolean verifyPostorderRecurse(int[] postorder,int start, int end){
        if(start>=end) return true;

        int rootVal = postorder[end];
        int i=start;
        while(i<=end && postorder[i]< rootVal){
            i++;
        }
        if(isMeet(postorder,start,i-1,rootVal,0) && isMeet(postorder,i,end-1,rootVal,1)){
            return verifyPostorderRecurse(postorder,start,i-1) &&  verifyPostorderRecurse(postorder,i,end-1);
        }else return false;


    }
    boolean isMeet(int[]postorder,int start,int end, int rootVal, int flag){
        if(flag == 0){
            int i = start;
            while(i<=end){
                if(postorder[i]>= rootVal) return false;
                i++;
            }
            return true;
        }else{
            int i = start;
            while(i<=end){
                if(postorder[i]<= rootVal) return false;
                i++;
            }
            return true;

        }

    }

    @Test
    public void test(){
        int[] nums = new int[]{3,10,6,9,2};
        boolean res= verifyPostorder(nums);
        System.out.println(res);
    }
}
