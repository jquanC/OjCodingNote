package Hot100.Medium;

import java.util.Objects;

public class SoAoitFunction04 {
    public int myAtoi(String s) {


        if(Objects.equals("",s)) return 0;

        int strLen = s.length();
        int p=0,start=0,end=0;
        char currChar = s.charAt(0);
        boolean sign = true; //默认值是 true , 不存在时默认为+

        while(Objects.equals(currChar,' ')){
            p++;
            if(p>strLen-1) return 0;
            currChar = s.charAt(p);
        }

//符号处理
        if(Objects.equals('+',currChar)){
            sign = true;
            p++;
        }
        if(Objects.equals('-',currChar)){
            sign = false;
            p++;
        }

        if(p>strLen-1) return 0;
        currChar = s.charAt(p);

//处理 '0' 的情况
        while(Objects.equals('0',currChar)){
            p++;
            if(p>strLen-1) return 0;
            currChar = s.charAt(p);
        }

        if(currChar < '1' || currChar > '9'){
            return 0;
        }

        start = p;
        end = p+1; //[,)
        while(currChar >= '0' && currChar <= '9'){ //排除开头是0的情况，后面需要包括0
            p++;
            if(p>strLen-1) break;
            currChar = s.charAt(p);
        }
        end = p;

        String resStr = s.substring(start,end);
        if(resStr.length()>10){ //肯定超出表示整型表示范围内,提前处理；且避免Long.parseLong(resStr)出现错误(比如上百个字符长度数字)
            return sign == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long ansL = Long.parseLong(resStr);
        if(sign == true && ansL > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(sign == false && (-1)*ansL < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;

        }
        int ans = (int)ansL;
        return sign == true ? ans : (-1)*ans;

    }
}
