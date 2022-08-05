package Qiu.BAIDU;

public class Main1 {
    /* 反转字符串，保持中间空格数量一直*/

    public static void main(String[] args) {
//        String str = new String("Hello      World!");
        String str = new String("  Hello      World!  baidu    keji!*&     20220730  ");
        String ans = revertStr(str);
        System.out.println(ans);

    }

    /**
     * 简单把字符串内容分成2种，空格，和非空格
     */
    public static String revertStr(String str) {
        if(str.length() ==0 || str ==null) return "";
        String ans = "";
        //下面这段代码可以简洁一下
        if (str.charAt(0) != ' ') {
            int i = 0;
            String curSegment = "";
            while (i<str.length() && str.charAt(i) != ' ') {
                curSegment += str.charAt(i);
                i++;
            }
            ans = revertStr(str.substring(i));
            return ans + curSegment;

        } else {
            int i = 0;
            String curSegment = "";
            while(i<str.length() && str.charAt(i)==' '){
                curSegment += ' ';
                i++;
            }
            ans = revertStr(str.substring(i));
            return ans + curSegment;

        }
    }
}
