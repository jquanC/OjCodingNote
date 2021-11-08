package SwordOf.dynamicPro;

public class NumWays {
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
    /*和斐波那契数列一样，只是初始条件有点变化*/
    public int numWays(int n) {
        int MOD = 1000000007;
        if(n ==0 || n==1) return 1;
        int[] numWayRes = new int[n+1];
        numWayRes[0]=1;
        numWayRes[1]=1;
        for(int i = 2 ;i<numWayRes.length;i++){
            numWayRes[i] = (numWayRes[i-1]+numWayRes[i-2])%MOD;
        }
        return numWayRes[n];

    }

}