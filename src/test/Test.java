package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        System.out.println(testM());

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        List<? extends Number> intList = arrayList;//直接 List<? extends Number> intList  = new ArrayList<Integer>(); 无法存入
        Number firstNum = intList.get(0);
        System.out.println(firstNum);

        List<? super Number>  superList = new ArrayList<>();
        superList.add(2.9);
        superList.add(3);
        Number firNum = (Number) superList.get(0);
        Object secNum = superList.get(1);
        System.out.println(firNum);
        System.out.println(secNum);
        System.out.println("after reinstall");
    }

    public static int testM() {
        int i = 0;
        try {
            i = 6;
        } finally {
            i++;
            return i;
        }
    }
}
