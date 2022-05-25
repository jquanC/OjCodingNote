package ACMmodel.TenCent.re;

import ACMmodel.TenCent.MainRedo2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给一个数组，下标从1-n，每次淘汰下标非质数的数字，然后重新组成数组，问最后剩下的数字为何数？
 * [2,1,3,5,6,7]
 * [1,2,3,4,5,6]
 */
public class Main2 {
    public static int[] primeTable;//0 不是素数 1 不是素数

    public static void main(String[] args) {
        int a[] = new int[]{3, 1, 1, 4, 5, 6};// 3 1 1 5 // 3 1 1
        Main2 main2 = new Main2();
        int len = a.length + 10;
        primeTable = new int[len];
        Arrays.fill(primeTable, 1);
        main2.buildPrimeTable(primeTable);
        System.out.println(main2.getNumber(a));
    }

    public int getNumber(int[] nums) {

        buildPrimeTable(primeTable);
        int validCou = nums.length;

        while (validCou != 1) {
            int p1 = 0;
            int p2 = 0;
            while(p2<validCou){
                if(isPrime(p2+1)){
                    nums[p1] = nums[p2];
                    p1++;
                    p2++;
                }else p2++;
            }
            validCou = p1;
        }

        return nums[0];
    }


    //朴素方法：从小到大枚举素数，它们倍数就不是素数
    public void buildPrimeTable(int[] primeTable) {
        primeTable[1] = 0;
        int len = primeTable.length;
        for (int i = 2; i <= len / 2 + 1; i++) {
            for (int j = 2; j <= len / 2 + 1; j++) {
                if (i * j < len) {
                    primeTable[i * j] = 0;
                }
            }
        }

    }

    //构建好表后，查表就最快
    public boolean isPrime(int index) {
        if (primeTable[index] == 1) return true;
        else return false;
    }
}
