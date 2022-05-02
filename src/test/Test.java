package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        System.out.println(testM());
      
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m =sc.nextInt();
            sc.nextLine();
            int q = sc.nextInt();
            System.out.println(n);
            System.out.println(m);
            System.out.println(q);


    }
    public static int testM(){
        int i=0;
        try{
            i=6;
        }finally {
            i++;
            return i;
        }
    }
}
