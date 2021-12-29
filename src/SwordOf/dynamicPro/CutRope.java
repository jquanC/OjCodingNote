package SwordOf.dynamicPro;

public class CutRope {

    public int cuttingRope(int n) {
        int[] maxProduct = new int[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        maxProduct[1] = 1;
        maxProduct[2] = 2;//注意，现在2可以单独成段
        maxProduct[3] = 3;//注意，现在3可以单独成段
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int curProduct = maxProduct[j] * maxProduct[i - j];
                if (curProduct > max) max = curProduct;
            }
            maxProduct[i] = max;
        }
        return maxProduct[n];
    }


}
