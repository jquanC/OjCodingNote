package EeacDay;

public class M0718 {
    public static void main(String[] args) {
        Solution0718 so = new Solution0718();
        String s =  "babad";
        String ans = so.longestPalindrome(s);
        System.out.println(ans);

    }
}
class Solution0718 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return null;

        int startPos=0;
        int maxLen=1;
        for(int i=0;i<s.length();i++){
            //以s(i)为对称中心
            int j=0;
            for(;i-j>=0 && i+j<s.length();j++){//j 是半径长度不包括中心
                if(s.charAt(i-j) == s.charAt(i+j)) continue;
                else break;//不加break j还是++到最大
            }
            if(2*(j-1)+1>maxLen){
                maxLen = 2*(j-1)+1;
                startPos = i-(j-1);
            }
            //以s(i) s(i+1) 为对称中心
            j=0;
            int l=i-j, r=i+j+1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                j++;
                l = i-j;
                r = i+1+j;

            }
            if(r-l-1>maxLen){
                maxLen = r-l-1;
                startPos = l+1;
            }
        }

        return s.substring(startPos,startPos+maxLen);

    }
}
