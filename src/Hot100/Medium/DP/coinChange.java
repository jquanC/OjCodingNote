package Hot100.Medium.DP;

import java.util.Arrays;

public class coinChange {


    public int coinChange(int[] coins,int amount){
        int[] f = new int[amount+1];

        Arrays.fill(f,amount+1);
        f[0]=0;//f[i] 表示 amount = i 时，最少硬币数
        int bestSubRes = Integer.MAX_VALUE;
        //自底向上
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }

            }

        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
