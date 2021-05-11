package Hot100.Medium;

public class SoHuiWengCuan {
        public String longestPalindrome(String s) {
            int strlen = s.length();
            if (strlen < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[strlen][strlen];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < strlen; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int subL = 2; subL <= strlen; subL++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < strlen; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = subL + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= strlen) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) { // 边界情况：既 aba，aa，a 情况；
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

}
