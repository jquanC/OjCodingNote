package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }
    public boolean verify(int []postorder , int start, int end){
        if(start >= end) return true;

        int rootNum = postorder[end];
        boolean flag = false;
        int partitionPos = -1;

        for(int i=start;i<=end;i++){
            if(!flag && postorder[i]>rootNum){
                partitionPos = i;
                flag = true;
            }
            if(flag && postorder[i]<rootNum){
                return false;
            }
        }
        //到这，肯定是true; flag为false 说明 rootNum是最大的；否则，rootNum是最小的; 此两种情况处理方式统一
        if(flag && partitionPos!=-1){
            return verify(postorder,start,partitionPos-1) && verify(postorder,partitionPos,end-1);
        }else{
            return verify(postorder,start,end-1);
        }
    }
    @Test
    public void test(){
        int[] nums = new int[]{3,10,6,9,2};
        boolean res= verifyPostorder(nums);
        System.out.println(res);
    }
}
