package SwordOf.DivideAndConquerAlgorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/8fe007e54fc04b5e82089aaa71ba3553
 * 来源：牛客网
 * <p>
 * 作为程序员的小Q，他的数列和其他人的不太一样，他有2^n2
 * n
 * 个数。
 * 老板问了小Q一共 m次，每次给出一个整数q_i (1 <= i <= m)q
 * i
 * ​
 * (1<=i<=m), 要求小Q把这些数每2^{q_i}2
 * q
 * i
 * ​
 * <p>
 * 分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
 * <p>
 * 例如:
 * 对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
 * 翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/8fe007e54fc04b5e82089aaa71ba3553
 * 来源：牛客网
 * <p>
 * 输入描述:
 * 第一行一个数n(0 \leq n \leq 20)n(0≤n≤20)
 * 第二行2^n2
 * n
 * 个数，表示初始的序列(1 \leq 初始序列 \leq 10^91≤初始序列≤10
 * 9
 * )
 * 第三行一个数m(1 \leq m \leq 10^6)m(1≤m≤10
 * 6
 * )
 * 第四行m个数表示q_i(0 \leq q_i \leq n)q
 * i
 * ​
 * (0≤q
 * i
 * ​
 * ≤n)
 * <p>
 * <p>
 * 输出描述:
 * m行每行一个数表示答案。
 * 示例1
 * 输入
 * 2
 * 2 1 4 3
 * 4
 * 1 2 0 2
 * 输出
 * 0
 * 6
 * 6
 * 0
 */
/*通过全部用例
运行时间
2353ms
占用内存
35732KB
*/
public class ReversePairsIVBoss {
    /*static int[] reorder;
    static int[] order;*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] reorder = new long[n+1];//reorder[i] 表示对数组以 2^i i={0,1,...,n}个为一组进行统计时逆序对数
        long[] order = new long[n+1];
        int len = (int) Math.pow(2, n);
        int[] arr = new int[len];
        int[] rearr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
            rearr[len - i - 1] = arr[i];
        }
        sc.nextLine();
        int m = sc.nextInt();
        int[] qrr = new int[m+1];
        for (int i = 1; i <=m; i++) {
            qrr[i] = sc.nextInt();
        }

//        reorder[n] = merge(arr, 0, arr.length-1, reorder);//求逆序对数量
        merge(arr, 0, arr.length-1, reorder);//求逆序对数量

//        order[n] = merge(rearr, 0, rearr.length-1, order);//求顺序对数量
        merge(rearr, 0, rearr.length-1, order);//求顺序对数量
     /*   System.out.println("init reorder" + Arrays.toString(reorder));
        System.out.println("init order" + Arrays.toString(order));*/
//        System.out.println("start : pairs total:" +(reorder[n]+order[n]));
//每组进行翻转，小Q想知道每次翻转后  整个序列中 的逆序对个数是多少呢？
        for(int i=1;i<qrr.length;i++){
            long ans = 0;
            for(int j=1;j<=qrr[i];j++){
                long temp = reorder[j];
                reorder[j] = order[j];
                order[j] = temp;
            }
            for(int t=1;t<=n;t++){
                ans+=reorder[t];
            }

        /*    int rotaBound = qrr[i];
            int diff = 0;
            for(int j=1;j<=rotaBound;j++){
                diff += reorder[j] - order[j];
                int temp = reorder[j];
                reorder[j] = order[j];
                order[j] = temp;
            }
            for(int j=rotaBound+1;j<=n;j++){
                reorder[j] -=diff;
                order[j] += diff;
            }*/
            /*int diff = reorder[qrr[i]] - order[qrr[i]];
            int temp = reorder[qrr[i]];
            reorder[qrr[i]] = order[qrr[i]];
            order[qrr[i]] = temp;
            //减少了多少顺序对就增加了多少逆序对，向上调整
            for(int adjust = qrr[i]+1;adjust<=n;adjust++){
                reorder[adjust] -=diff; // -=
                order[adjust] += diff; //+=
            }*/

          /*  System.out.println("init reorder" + Arrays.toString(reorder));
            System.out.println("init order" + Arrays.toString(order));*/
//            System.out.println("after "+i+" rotare,total paires:"+(reorder[n]+order[n]));
//            System.out.println(reorder[n]);
            System.out.println(ans);
        }
    }

    public static long merge(int[] arr, int start, int end, long[] reorder){

        if (start == end) return 0;
        int mid = (start + end) / 2;
        long subCou1 = merge(arr, start, mid, reorder);
        long subCou2 = merge(arr, mid + 1, end, reorder);


        long cou3 = 0;
        int p1 = mid;
        int p2 = end;
        int[] temp = new int[end - start + 1];
        int pt = temp.length - 1;
        while (p1 >= start && p2 >= mid + 1) {
            if (arr[p1] > arr[p2]) {
                temp[pt] = arr[p1];
                p1--;
                pt--;
                cou3 += p2 - mid;

            } else {
                temp[pt] = arr[p2];
                p2--;
                pt--;
            }
        }
        while (p1 < start && p2 >= mid + 1) {
            temp[pt] = arr[p2];
            p2--;
            pt--;
        }
        while (p1 >= start && p2 < mid + 1) {
            temp[pt] = arr[p1];
            p1--;
            pt--;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }

        //记录 reorder:
        int q_index = (int)( Math.log(end - start + 1)/Math.log(2)); //对应关系不是 mid - start
//        System.out.println("q_index="+q_index);
//        reorder[q_index] += (subCou1 + subCou2+cou3); //要+= 不然被覆盖
        reorder[q_index] += cou3;
        return subCou1 + subCou2 + cou3;

    }

    @Test
    public void test(){
        int a = 2;
        System.out.println(Math.log(2));
        System.out.println(Math.log(8)/Math.log(2));
    }
}
