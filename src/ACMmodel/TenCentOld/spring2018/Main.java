package ACMmodel.TenCentOld.spring2018;

import org.junit.Test;

import java.util.Scanner;

/*小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力

输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。

输出描述:
输出一个数表示小Q第一天最多能吃多少块巧克力。

输入例子1:
3 7
输出例子1:
4
* */
//26 13 7 4 2 1
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //二分思想查找解
        int start = 1, end = M;


        while (start <= end) {
            int mid = (start + end) / 2; //第一天吃mid 块巧克力
            int sum = calCoherentSum(mid, N);
            if (sum == M) {
                System.out.println(mid);
                return;
            } else if (sum < M) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(end);
    }

    public static int calCoherentSum(int a0, int N) {
        int sum = 0;
        while (N > 0) {
            sum += a0;
            N--;
            a0 = (a0+1)/2;//向上取整等价于 a0 = (a0+1)/2
        }
        return sum;
    }
    @Test
    public void test(){
        int a = 1;
        int b = (int)Math.ceil(a/2);
        System.out.println(b);
    }

}
