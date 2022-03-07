package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] original = new int[]{1,2,4,5,52,51,566,12};
        int[] copyArr = Arrays.copyOfRange(original,0,original.length);
        System.out.println(Arrays.toString(copyArr));
    }
}
