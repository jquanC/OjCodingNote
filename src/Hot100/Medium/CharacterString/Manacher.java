package Hot100.Medium.CharacterString;

import java.io.StringBufferInputStream;

public class Manacher {
    //f[i]:以i为中心的最大回文半径
    //im: 可达最右端点的回文字符串的中心
    //rm: 前面全部回文字符串可达的最右端点
    //il: 最长回文串的半径
    public String longestPalindrome(String s) {
        //字符串处理,插入边界并统一奇偶
        StringBuilder sb = new StringBuilder();
        sb.append("!#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");

        //manacher 算法 初始： i的起始最大回文半径 = min{f[2*im-i], rm-i+1}
        int irm = 0,rm = 0;
        int il=0;//记录具有最长半径的回文串中心
        int[] f = new int[sb.length()];
        for(int i=1;i<sb.length();i++){ //小细节，1开始可避免0的判断，存在越界情况
            //初始化, 精髓，不再盲目拓展而是利用前面的结果
            f[i] = i<=rm ? Math.min(f[2*irm-i],rm-i+1) : 1;

            //再开始中心拓展-- 实际上不需要做越界判断，这就是为什么开头结尾加了$ ! 处理的原因
            while(i+f[i]<sb.length() && i-f[i]>=0 && sb.charAt(i+f[i]) == sb.charAt(i-f[i])){
                f[i]++;
            }

            //动态维护 f[i] im rm
            if(i+f[i] -1 >rm){
                rm = f[i]+i-1;
                irm = i;
            }
            //记录最优解
            if(f[i]>=f[il]){
                il = i;
            }

        }
        StringBuilder ans = new StringBuilder();
        for(int i= il-f[il]+1;i<=il+f[il]-1;i++){
            if(sb.charAt(i)!='#' && sb.charAt(i)!='!'&& sb.charAt(i)!='$')
            ans.append(sb.charAt(i));
        }
        return ans.toString();

    }
}
