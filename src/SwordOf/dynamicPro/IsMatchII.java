package SwordOf.dynamicPro;

import org.junit.Test;

public class IsMatchII {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        return isMatchPattern(sarr,sarr.length-1,parr,parr.length-1);

    }

    private boolean isMatchPattern(char[] sarr,int si,char[]parr,int pi){
        //定义递归的终止条件
        if(si<0 && pi <0) return true;
        if(si>=0 && pi<0) return false;
        if(si<0 && pi>=0){
            if(parr[pi]=='*' && pi>=1) return isMatchPattern(sarr,si,parr,pi-2);
            else return false;
        }

        boolean state1 = false;
        boolean state2 = false;

        //状态转移方程 or 分类讨论
        if(parr[pi] == '*'){
            state1 = isMatchPattern(sarr,si-1,parr,pi)||isMatchPattern(sarr,si-1,parr,pi-2)||isMatchPattern(sarr,si,parr,pi-2);

        }else{
            state2 = isMatchTwoCh(sarr[si],parr[pi]) && isMatchPattern(sarr,si-1,parr,pi-1);
        }
        return state1||state2;

    }

    private boolean isMatchTwoCh(char ch1, char ch2){
        if(ch1 == ch2) return true;
        if(ch1 == '.'||ch2 == '.') return true;

        return false;
    }

    @Test
    public void test(){
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean res = isMatch(s,p);
        System.out.println(res);
    }
}
