package CSP;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入的第一行包含一个正整数 ，表示障碍物的数量。
 * 输入的第二行包括  个非负整数 ，表示每个障碍物的坐标。
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int N = (int)1e4+10;
        int[] obstacle = new int[N];//n个障碍物的坐标 a_1 , ..., a_i,...,a_n-1

        for (int i = 0; i < n; i++) {
            obstacle[i] = scanner.nextInt();
        }
        int[] f = new int[N];
        f[0] = 1;//0 的话就全是0了
        int M = (int) (1E5) + 100;
        HashSet<Integer>[] factor = new HashSet[M];

        //求 小于M 范围内所有数的不包括自己本身的约数 （后面的求解算法需要排除自己本身）
        for (int i = 1; i < M/2 ; i++) { //逐个枚举每个数作为约数
            for (int j = i * 2; j < M; j += i) {// 将i的倍数，添加i作为其约数 ； j从i*2开始，满足求所有数的不包括自己本身的约数
                if (factor[j] == null) {
                    factor[j] = new HashSet<Integer>();
                }
                factor[j].add(i);

            }
        }

        boolean[] st = new boolean[(int) M];//对于同一个i,枚举j时,前面cnt区间使用的约数后面不能再使用;

        for (int i = 1; i < n; i++) {
            Arrays.fill(st,false);//对于同一个i,枚举j时,前面cnt区间使用的约数后面不能再使用;
            for (int j = i - 1; j >= 0; j--) {
                int distance = obstacle[i]-obstacle[j];
                long cnt = 0;

                for ( int r: factor[distance]
                     ) {
                    if (st[r] != true) {
                        cnt++;
                        st[r] = true;
                    }
                }

                st[distance] = true; //还有distance这个约数在下一轮不能使用，需要手动添加

                f[i] =(int) (f[i] + f[j] * cnt) % ((int) 1E9 + 7);
            }
        }
        System.out.println(f[n - 1]);
    }


    @Test
    public void test(){
        int mod = (int)1E9 + 7;
        System.out.println((1E5) + 100);
    }

}
