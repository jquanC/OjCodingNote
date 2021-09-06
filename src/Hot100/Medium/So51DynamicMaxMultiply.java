package Hot100.Medium;

public class So51DynamicMaxMultiply {
    /*public int maxProduct(int[] nums){

       int[] maxProduct = new int[nums.length];
       int[] minProduct = new int[nums.length];

       maxProduct[0]=minProduct[0]=nums[0];
       int res = nums[0];

       for(int i=1;i<nums.length;i++){
          maxProduct[i] = max(maxProduct[i-1]*nums[i],minProduct[i-1]*nums[i],nums[i]);
          minProduct[i] = min(maxProduct[i-1]*nums[i],minProduct[i-1]*nums[i],nums[i]);
          if(maxProduct[i] > res) res = maxProduct[i];
       }
       return res;


    }*/

    //滚动数组思想：由于第i个状态只和第i-1个有关，只需要两个变量来维护i-1时刻的状态即可
    public int maxProduct(int[] nums) {

        int maxProduct;
        int minProduct;

        maxProduct = minProduct = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int mn = minProduct;
            int mf = maxProduct;
            maxProduct = max(mf * nums[i], mn * nums[i], nums[i]);
            minProduct = min(mf * nums[i], mn * nums[i], nums[i]);


            if (maxProduct > res) res = maxProduct;
        }
        return res;

    }


    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);

    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
