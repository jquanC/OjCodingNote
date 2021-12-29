package SwordOf.dynamicPro;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.util.Arrays;

public class DicesProbability {

    private int MAX_VALUE = 6;
    public double[] dicesProbability(int n) {
        if(n <1) return null;

        int[][] count = new int[2][MAX_VALUE*n+1];

        int flag=0;//flag 用来控制 交替读写 点数统计数组count
        //抛第一个筛子
        for(int i=1;i<=MAX_VALUE;i++) count[0][i] = 1;

        //抛剩下的骰子
        for(int k=2;k<=n;k++){
            for(int i=0;i<k;i++) count[1-flag][i]=0;//待写数组清0

            for(int i=k;i<=MAX_VALUE*k;i++){ //rang(i):本轮摇完色子需更新的点数范围；
                count[1-flag][i]=0; //同样是为了待写数组清0；
                for(int j=1;j<=i && j<=MAX_VALUE;j++){ //j<=i 做越界控制
                    count[1-flag][i] += count[flag][i-j];//点数和x出现的次数等于上一轮x-1，x-2,..,x-j,...,x-6出现的点数之和
                }
            }
            flag = 1-flag;
        }
        //用古典概型求概率，先计算抛n个骰子共多少种排列(可以理解为共多少种可能情况，count最后的结果可以看作是某种可能次数)
        double total = Math.pow(MAX_VALUE,n);
        double[] res = new double[(MAX_VALUE-1)*n+1];
        for(int i=n;i<count[flag].length;i++){
            res[i-n] = count[flag][i]/total;
        }
        return res;

    }
}
