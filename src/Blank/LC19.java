package Blank;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.junit.Test;

public class LC19 {
    @Test
    public void test() {

        System.out.println(isMatch("mississippi","mis*is*p*."));
    }


    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        char[] srr = s.toCharArray();
        char[] prr = p.toCharArray();
        return isMatchSup(srr, prr, len1 - 1, len2 - 1);

    }

    public boolean isMatchSup(char[] srr, char[] prr, int indexs, int indexp) {
        if (indexp == -1 && indexs == -1) return true;
        if (indexs >= 0 && indexp < 0) return false;
        if (indexs < 0 && indexp >= 0) {
            if (prr[indexp] == '*' && indexp >= 1) {
                return isMatchSup(srr, prr, indexs, indexp - 2);
            } else return false;

        }
        //indexs >=0 indexp >=0
        if (prr[indexp] == '*') {
            boolean state1 = false;
            boolean state2 = false;
            if(isMathCh(srr[indexs],prr[indexp-1])){
                state1 = isMatchSup(srr, prr, indexs - 1, indexp - 2) ||
                        isMatchSup(srr, prr, indexs, indexp - 2) ||
                        isMatchSup(srr, prr, indexs - 1, indexp);
            }else{
                state2 = isMatchSup(srr,prr,indexs,indexp-2);
            }
            return  state1||state2;

        } else {
            if (isMathCh(srr[indexs], prr[indexp])) {
                return isMatchSup(srr, prr, indexs - 1, indexp - 1);
            }else return false;
        }


    }

    public boolean isMathCh(char c1, char c2) {
        if (c2 == '.') return true;
        if (c1 == c2) return true;
        else return false;
    }


}
