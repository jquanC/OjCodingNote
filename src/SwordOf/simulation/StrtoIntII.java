package SwordOf.simulation;

import org.junit.Test;

public class StrtoIntII {
    public int strToInt(String str) {

        int flag = 0;
        long res=0;
        boolean meetValid = false;
        boolean meetNum = false;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == ' ' && !meetValid) continue;
            if( (ch == '+'||ch == '-') && !meetValid){
                meetValid = true;
                if(ch == '+') flag = 0;
                else flag = 1;
                continue;
            }
            if( ch>='0' && ch<='9'){
                if(meetValid == false) meetValid = !meetValid;
                res= res*10 + (ch-'0');
                meetNum = true;
//                continue;
            }
            if( (ch<'0' || ch>'9') && meetValid) break;
            if( (ch<'0' || ch>'9')  && !meetValid) return 0;
            if(flag ==0 && res>=Integer.MAX_VALUE) return  Integer.MAX_VALUE;
            if(flag == 1 && res>=Integer.MAX_VALUE+1) return Integer.MIN_VALUE;

        }
        if(meetNum) return flag==0? (int)res : -(int)res;
        else return 0;

    }

    @Test
    public void test(){
        String str = "-91283472332";//-9,223,372,036,854,775,808 ~9,223,372,036,854,775,807
        int res = strToInt(str);
        System.out.println(res);
    }
}
