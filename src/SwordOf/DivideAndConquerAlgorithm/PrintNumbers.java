package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

import javax.print.attribute.standard.NumberUp;

public class PrintNumbers {
    /*考虑大数的情况*/
    /*方法1：字符串模拟加法的做法*/
    /*方法2：转换成全排列来做*/
    /*因为考虑大数的情况，将数字转化在字符串数组,所以打印/存储的时候，需要去掉前导0*/
    private String[] res;
    private int cou = 0;

    public String[] printNumbers(int n) {
        char[] number = new char[n];
        res = new String[(int) Math.pow(10, n) - 1];
        allPermutation(number, 0, n);
        return res;

    }

    private void allPermutation(char[] number, int index, int n) {
        if (index == n) {
            printNum(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            allPermutation(number, index + 1, n);
        }
    }

    private void printNum(char[] number) {
        StringBuilder sb = new StringBuilder();
        boolean allZero = true;
        boolean invalidZeroIgnore = true;
        for (int i = 0; i < number.length; i++) {
            if (invalidZeroIgnore && number[i] != '0') {
                invalidZeroIgnore = false;
                sb.append(number[i]);
                allZero = false;
                continue;
            }
            if(!invalidZeroIgnore)  sb.append(number[i]);
        }
        if (allZero == false) {
            res[cou] = sb.toString();
            cou++;
        }else return;
    }

    @Test
    public void test() {
        int n = 2;
        String[] res = printNumbers(n);
        for (String e : res
             ) {
            System.out.println(e);
        }
    }

}
