package ACMmodel.TenCent;

/*给一个数组，下标从1-n，每次淘汰下标非质数的数字，然后重新组成数组，问最后剩下的数字为何数*/
/*生成素数筛，直接模拟就好*/

import java.util.ArrayList;
import java.util.Arrays;

public class MainRedo2 {
    static int[] primTable = new int[(int) 1e5];

    public static void main(String[] args) {
        Arrays.fill(primTable,1);
        //默认都是素数，需要挑出不是素数的数； 默认都不是素数，则需要挑出是素数的数； 根据算法，我们选择初始化为1 默认都是素数
       primTable[1] = 0;

        int a[] = new int[]{3,1,1,4,5,6};
        MainRedo2 main = new MainRedo2();
        main.buildPrimTable();
        System.out.println(main.getNumber(a));
    }

    public int getNumber(int[] nums) {
        int cou = nums.length;
        int[] tARR = new int[nums.length];
        while(cou>1){
            int k=0;
            for(int i=1;i<=cou;i++){
                if(primTable[i] == 1){
                    tARR[k++] = nums[i-1];
                }
            }
            nums = tARR;
            cou = k;
        }
        return tARR[0];
    }

    public void buildPrimTable() {
        for (int i = 2; i < 1e5; i++) {
            if (primTable[i]==1) {
                int c = 2;
                while (i*c < 1e5) { //假设数最大范围是1e5
                    primTable[i * c] = 0;
                    c++;
                }
            }
        }
    }

    //无用函数
    public boolean isPrime(int x) {
        if (x == 1) return false;
        if (x == 2) return true;
        if (x == 3) return true;
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;

    }

}
