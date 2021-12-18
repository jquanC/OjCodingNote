package test;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "21.22";
        String str2 = "12.";
        String str3 = ".21";
        String str5 = "..2";
        String [] strs = str5.split("\\.");
        System.out.println(str5+" : "+Arrays.toString(strs));
        String str4 = "0e";
        String [] strs2 = str4.split("[Ee]");
        System.out.println(Arrays.toString(strs2));
        System.out.println(strs2.length);
        String strk1 = "";
        boolean res = strk1==""? true:false;
        System.out.println(res);

    }
}
