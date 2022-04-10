package StringProblem;

import java.util.Scanner;

/**求最长公共子字符串
 * dp[i][j]: 表示  以StrA(i),StrB(j) 结尾的最长公共子字符串的 长度
 * */
public class LC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int maxLen = -0x3f3f3f3f;
        int markPos = 0;

        int alen = str1.length();
        int blen = str2.length();
        int[][] dp = new int[alen+1][blen+1];
        for(int i=1;i<=alen;i++){
            for(int j=1;j<=blen;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else dp[i][j] = 0;

                if(dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    markPos = i;
                }
            }
        }
        String ans = str1.substring(markPos-maxLen,markPos);
        System.out.println(ans);

    }
}
