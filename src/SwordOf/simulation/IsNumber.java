package SwordOf.simulation;

import org.junit.Test;

public class IsNumber {
    public boolean isNumber(String s) {
        String str = s.trim();
        if(str.equals("")) return false;
        boolean haveEe = str.contains("e")||str.contains("E");
        String [] strs = str.split("[Ee]");
        if(strs.length == 0) return false; //只输入 “E” 或者 "e"的情况

        boolean flagFirstPart = true;
        boolean haveSecondPart = false;
        boolean result = true;
        for(String strcheck : strs){
            if(strcheck!=""){
                if(flagFirstPart == true && result){
                    result = result && (isInteger(strcheck)||isDigital(strcheck));
                    flagFirstPart = false;
                    continue;
                }
                if(flagFirstPart == false && result){
                    haveSecondPart = true;
                    result = result && isInteger(strcheck);
                }
            }
        }
        if(haveEe) result = result && haveSecondPart;
        return result ;

    }
    private boolean isInteger(String str){
        if(str.equals("")) return false;

        boolean res = true;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+'||ch=='-') continue;
            if(ch<'0' || ch >'9' ) return false;
        }
        return true;
    }

    /**需要考虑小数构成的3种情况 */
    private boolean isDigital(String str){
        if(str.equals("")) return false;

        String[] strs = str.split("\\.");
        if(strs.length == 0 ) return false; //只输入 . 的情况
        if(str.length()-strs.length>=2) return false;//只能有一个.

        boolean res = true;

        int cou=0;
        for(String strSplit : strs){
            if(strSplit.equals("") && cou!=0) return false;
            if(!strSplit.equals("")){
                res = res && isInteger(strSplit);
            }
            cou++;
        }
        return res;
    }
    @Test
    public void test(){
        String str = "0..";
        boolean res =isNumber(str);
        System.out.println(res);
    }
}
