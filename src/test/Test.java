package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(testM());
        byte [] bs  = new byte[5];
        String pkStr = Base64.getEncoder().encodeToString(bs);
        System.out.println(pkStr);

    }


}
