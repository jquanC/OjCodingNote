package test;

import org.junit.Test;

public class CashOjTest {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] sArr = s.split(" ");
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i].equals("")) continue;//是"" 不是和" "哦
            else {
                sb.append(sArr[i]);
                if (i != 0) sb.append(" ");
            }
        }
        String res = sb.toString();
        return res;
    }
    @Test
    public void test(){
       String str =  "a good   example";
       String res = reverseWords(str);
        System.out.println(res);
    }
}
