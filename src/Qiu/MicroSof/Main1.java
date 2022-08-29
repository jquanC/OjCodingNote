package Qiu.MicroSof;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
    }
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(X);
        long fixRight = -1;
        int cou = 0;
        for(int i=0;i<X.length;i++){
            if(fixRight>=X[i]) continue;
            fixRight = X[i]+W;
            cou++;
        }
        return cou;
    }
}
