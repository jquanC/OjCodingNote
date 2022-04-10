package ACMmodel.Ali;

import java.util.Scanner;
/**
 * horse   ros 3
 * intention execution 5*/
public class StringDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        //定义dp[i][j]: 将s1(1,i)修改为s2(1,j)所需的操作数
        int[][] dp = new int[len1+1][len2+1];

        //填充非法边界
        for(int i=0;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=len2;j++){
            dp[0][j] = j;
        }


        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int c1 = dp[i-1][j]+1;
                int c2 = dp[i][j-1]+1;

                int c3 = dp[i-1][j-1] + (str1.charAt(i-1) == str2.charAt(j-1) ? 0 :1);//要加括号不然就是先+

                dp[i][j] = Math.min(Math.min(c1,c2),c3);
            }
        }
        System.out.println(dp[len1][len2]);

    }
}
