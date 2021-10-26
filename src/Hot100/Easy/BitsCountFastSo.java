package Hot100.Easy;

import org.junit.Test;

public class BitsCountFastSo {
    /**该方法的思想：
     * 动态规划：bitCou[i] = bitCou[i-比i小的最大2的整数次幂] + bitCou[比i小的最大2的整数次幂]
     *                   = bitCou[i-比i小的最大2的整数次幂] + 1
     *
     *动态更新 i-比i小的最大2的整数次幂的数，查表即可              */

    public int[] countBits(int n) {
        int[] bitCou = new int[n + 1];
        int higBit = 0;
        for(int i =1;i<=n;i++){ //i必须从0开始，i=0时，算法不满足
            if((i&(i-1))==0){ //这个地方一定要用括号包裹：(i&(i-1)) ，否则报错，有点不解，期待大佬解答
                higBit = i; //i是2^整数次方,更新当前的最高有效位
            }
            bitCou[i] = bitCou[i-higBit]+1;
        }
        return bitCou;
    }

    @Test
    public void test(){
        int i=5;
        int x = i & (i-1);
        System.out.println(x);
        int y = (i & (i-1));
        System.out.println(y);
    }
}
