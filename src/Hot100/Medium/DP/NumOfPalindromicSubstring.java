package Hot100.Medium.DP;

public class NumOfPalindromicSubstring {
    public int countSubstrings(String s){
        int l = s.length();
        int cou=0;
        for(int i=0;i<2*l-1;i++){
            int left = i/2;
            int right = i/2+i%2;
            while(left>=0 && right<l && s.charAt(left)==s.charAt(right)){
                cou++;
                left--;
                right++;
            }
        }
     return cou;
    }
}
