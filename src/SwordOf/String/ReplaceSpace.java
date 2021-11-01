package SwordOf.String;

import org.junit.Test;

/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。*/
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb =  new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch ==' '){
                sb.append("%20");
            }else sb.append(ch);
        }
        return  sb.toString();
    }

    @Test
    public void test(){
        String str = "we are happy.";
        String s = replaceSpace(str);
        System.out.println(s);
    }
}
