package SwordOf.dynamicPro;

import org.junit.Test;

public class DicesProbabilityII {

    private int g_max = 6;
    public double[] dicesProbability(int n) {
        if(n==0) return null;
        double[][] pArr = new double[2][n*6+1];

        int flag = 0;
        for(int i=1;i<=g_max;i++){ //第一颗筛子
            pArr[flag][i] = 1.0/6.0;
        }
        //第2-n颗筛子
        for(int k=2;k<=n;k++){

            //k颗筛子点数和范围【k,6K】
            for(int j=0;j<k;j++) pArr[1-flag][j] = 0;

            for(int j=k;j<=g_max*k;j++){
                //求概率
                pArr[1-flag][j]=0;
                for(int i=1;(j-i)>=0 && i<=g_max;i++){
                    pArr[1-flag][j]+= pArr[flag][j-i]*(1.0/6.0);
                }
            }
            flag = 1-flag;
        }
        double[] res = new double[n*g_max-n+1];
        for(int i=0;i<res.length;i++){
            res[i] = pArr[flag][n+i];
        }
        return res;

    }
    @Test
    public void  test(){
        double[] res = dicesProbability(1);
        System.out.println(res);
    }
}
