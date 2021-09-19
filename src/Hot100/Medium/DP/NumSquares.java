package Hot100.Medium.DP;

import java.util.Map;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquares {


    public int numSquares(int n) {
        int[] f = new int[n+1];
        f[0] = 0;

        for(int i=1;i<=n;i++){
           int min = Integer.MAX_VALUE;
            for(int j=1;j<=Math.sqrt(i);j++){
               min = Math.min(min ,f[i-j*j]);
           }
           f[i] = min+1;

        }
        return f[n];
    }


}
