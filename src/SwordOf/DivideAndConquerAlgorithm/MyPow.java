package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

public class MyPow {
    public double myPow(double x, int n) {
        boolean divideF = false;
        double result = 1;

        if (n == 0) return 1;
        else if(n == Integer.MIN_VALUE){
            return (1/x)*myPow(x,n+1);//处理n=-2147483648时
        }
        else {
            if (n < 0) {
                divideF = true;
                n = -n;//如果前面不特别处理n=-2147483648时,会溢出
            }

            if (n == 1) {
                result = x;
            } else if (n % 2 == 0) {
                double res = myPow(x, n / 2);
                result = res * res;
            } else {
                double res = myPow(x, (n - 1) / 2);
                result = res * res * x;
            }
            if (divideF) return 1 / result;
            else return result;
        }
    }

    @Test
    public void test(){
        double res = myPow(2.00000,-2147483648);
        System.out.println(res);
    }
}
