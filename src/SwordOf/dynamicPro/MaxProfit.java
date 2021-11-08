package SwordOf.dynamicPro;


/*动态规划：
* max[i]：表示前[i]能得到的最大利润
* minValue：表示前面股票出现的最低价格
* 动态转移方程： max[i] = 今天价格-前面的最低价格 是否大于 前i-1可以求得的最大利润？ */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length ==0 || prices == null) return 0;

        int[] max = new int[prices.length];
        max[0]=0;
        int minValue= prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]<minValue) minValue = prices[i];

            max[i] = prices[i] - minValue > max[i-1] ? prices[i] - minValue : max[i-1];
        }
        return max[prices.length-1];
    }
}
