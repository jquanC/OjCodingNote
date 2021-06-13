package Hot100.Medium;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import java.sql.ResultSet;
import java.util.*;
/*回溯法
 * 递归过程中的截止条件
 * 左括号数量还小于n，可以添加左括号
 * 右括号数量小于左括号，可以添加右括号
 * 利用这两性质，判定-截止；与回溯-搜索所有可能的解
 * 复习：想想，什么是回溯？从某个状态出发，往下一个状态时，有多种可能，在递归构造状态树的过程中，一次枚举所有状态，每次假设一种状态之后，需要回溯，再前进到另一种状态
 * */

public class SoGeneParenthesis10 {
    public List<String> SoGenerateParenthesis(int n) {
        List<String> ansList = new ArrayList<>();
        backTrackGen(n, new StringBuilder(), 0, 0, ansList);
        return ansList;

    }

    private void backTrackGen(int max, StringBuilder strBuilder, int leftPa, int rightPa, List<String> ansList) {
        if (leftPa == max && rightPa == max) {
            ansList.add(strBuilder.toString());
        }
        if (leftPa < max) {
            strBuilder.append("(");
            backTrackGen(max, strBuilder, leftPa + 1, rightPa, ansList);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
        if (rightPa < leftPa) {
            strBuilder.append(")");
            backTrackGen(max, strBuilder, leftPa, rightPa + 1, ansList);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    /*动态规划解-自底向上版本
    数据结构：ArrayList<String>[] dp;
    dp[i] 表示 i 个括号的所有可能解
    dp[i] = dp[m]+dp[k]
    m+k=i-1
    构造解："("+dp[m]+")"+dp[k]; 具体构造时，又需要2个for循环

    * */
   /* public String SoGenerateParenthesisDp(int n){
        List<String> dp = new ArrayList<>();
        dp.add(""); //边界条件 dp[0]
        for(int i=1;i<=n;i++){ //求解dp[i]
            StringBuilder str = new StringBuilder();
            for(int m=0;m<i;m++){
                int k=i-1-m;
                str.append("("+dp.get(m)+")"+dp.get(k));
            }
            dp.add(str.toString());

        }
        return dp.get(n);
    }*/
    public List<String> SoGenerateParenthesisDp(int n) {
        List<String>[] dp = new ArrayList[n + 1];
        //动态规划表的边界
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp[0] = dp0;
        //开始填表，同时也是求解过程
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int m = 0; m <= i - 1; m++) {
                int k = i - 1 - m;
                List<String> dpm = dp[m];
                List<String> dpk = dp[k];
                //构造 i 个括号组合的解。也即使动态规划方程（动态规划思想），原问题的解可由最优子问题来求得

                for (String str1 : dpm) {
                    for (String str2 : dpk) {
                        cur.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp[i] = cur;
        }
        return dp[n];
    }

    public List<String> DpRecur(int n) {
        if (n == 0) {
            List<String> dp0 = new ArrayList<>();
            dp0.add("");
            return dp0;
        }
        List<String> dpn = new ArrayList<>();
        for (int m = 0; m < n; m++) { //求解所有解
            int k = n - m - 1;
            List<String> dpm = DpRecur(m);
            List<String> dpk = DpRecur(k);
            //构造解并添加
            for (String str1 : dpm) {
                for (String str2 : dpk) {
                    dpn.add("(" + str1 + ")" + str2);
                }
            }
        }
        return dpn;
    }
}
