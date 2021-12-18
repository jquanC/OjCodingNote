package SwordOf.simulation;

import org.junit.Test;

public class StrtoInt {
    public int strToInt(String str) {
        long res = 0;
        boolean sym = true;
        boolean symHaveCheck =false;
        boolean checkRes = true;

        boolean haveMeetFirstLeagal = false;

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(haveMeetFirstLeagal==false &&( ch=='+'||ch=='-'||(ch>='0' && ch<='9'))){
                haveMeetFirstLeagal = true;
            }
            //如果前导无效字符判定还没结束，且前导字符不合法，返回0
            if(haveMeetFirstLeagal==false){
                if(!preLegalChar(ch)) return 0;

            }else{
                if(symHaveCheck==false && (ch>='0'&&ch<='9')){
                    symHaveCheck = true;
                }
                if((ch=='+'||ch=='-') && symHaveCheck == false){
                    symHaveCheck = true;
                    if(ch=='-') sym = false;
                    continue;
                }
                if(ch>='0'&&ch<='9'){
                    res = res*10+ch-'0';
                    if(res>Integer.MAX_VALUE) break;
                }else{
                    break;
                }
            }

        }
        if(sym){
            if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int)res;
        }else{
            res = -res;
            if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int)(res);
        }
    }


    private boolean preLegalChar(char ch){
        if(ch==' ') return true;
        else return false;
    }
    @Test
    public void test(){
        String str = "9223372036854775808";//-9,223,372,036,854,775,808 ~9,223,372,036,854,775,807
        int res = strToInt(str);
        System.out.println(res);
    }
}
