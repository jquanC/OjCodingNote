package Hot100.Medium.DP;

public class LongestHuiWengCuan {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2) return s;

        char[] sChar = s.toCharArray();
        boolean dp[][] = new boolean[len][len];

        //初始化,另外一个边界条件不需要刻意初始化
        for(int i=0;i<len;i++) dp[i][i]=true;

        int maxLen = 1,beginFlag=0;
        for(int sublen=2;sublen<=len;sublen++){//从2开始循环，1已求解
            //枚举所有左端点
            for(int left=0;left<len;left++){//左端点的上限可以宽松
                //左端点确定，长度确定，确定右端点
                int right = left+sublen-1; //记得减一
                if(right >=len) break;

                if(sChar[right] != sChar[left]) dp[left][right]=false;
                else{
                    if(right-left<3){
                        dp[left][right] = true;
                    }else{
                        dp[left][right] = dp[left+1][right-1];
                    }


                }

                if(dp[left][right] && right-left+1 > maxLen){
                    maxLen = right-left+1;
                    beginFlag = left;
                }


            }
        }
        return s.substring(beginFlag,beginFlag+maxLen);
    }
}
