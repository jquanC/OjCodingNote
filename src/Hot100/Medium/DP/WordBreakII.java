package Hot100.Medium.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    List<String> ans;
    HashSet<String> wordDictSet;
    public List<String> wordBreak(String s, List<String> wordDict) {

        ans = new ArrayList<String>();
        wordDictSet = new HashSet<String>(wordDict);

        backtrace(s,wordDictSet,ans,new StringBuilder());

        return ans;


    }
    /**能匹配 一定是有前缀能匹配 */
    private boolean canBreakWord(String s,HashSet<String> wordDictSet){
        boolean[] dp = new boolean[s.length()+1]; //dp[i]: 表示 s[0，i）是否可以匹配
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            //s[0,i]分为 s[0,j),s[j,i);
            for(int j=0;j<i;j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
    private void backtrace(String s, HashSet<String> wordDictSet, List<String> ans, StringBuilder sb){
        if(s.equals("")){
            sb.delete(sb.length()-1,sb.length());
            ans.add(sb.toString());
            sb.append(" ");//统一处理
            return ;
        }

        if(canBreakWord(s,wordDictSet)){
            for(int j=1;j<=s.length();j++){
                if(wordDictSet.contains(s.substring(0,j))){
                    sb.append(s.substring(0,j));
                    sb.append(" ");
                    backtrace(s.substring(j,s.length()),wordDictSet,ans,sb);
                    sb.delete(sb.length()-1,sb.length());
                    sb.delete(sb.length()-j,sb.length());
                }
            }

        }
        return ;
    }
}
