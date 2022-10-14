package ACMmodel.TenCent.re221013;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        Main2 so = new Main2();
        so.buildPrimeTable();
//        so.seePrimeTable(so.primeTable);
        int a[] = new int[]{3,1,1,4,5,6};
        int ans = so.getNumber(a);
        System.out.println(ans);



    }
    public int[] primeTable = new int[(int)1e5];//0-true 1-false

    public int getNumber(int[] nums) {
//        buildPrimeTable();
        int[] numsP = new int[nums.length];
        int bound = nums.length;
        int nextBound = 0;
        while(true){
            for(int i=0;i<bound;i++){
                if(primeTable[i+1]==0){
                    numsP[nextBound++] = nums[i];
                }
            }
            bound = nextBound;
            nextBound = 0;
            int[] t = numsP;
            numsP = nums;
            nums = t;
            if(bound == 1) break;//只剩下一个数了
        }
        return nums[0];


    }
    //检查一下
    public void buildPrimeTable(){
        int len = primeTable.length;
        primeTable[0] = 1;
        primeTable[1] = 1;
        for(int i=2;i<len/2;i++){
            for(int j=2;i*j<len;j++){
                primeTable[i*j] = 1;
            }
        }
    }
    public void seePrimeTable(int[] primeTable){
        int cou = 0;
        for(int i=0;i<1000;i++){
            if(primeTable[i]==0){
                cou++;
                System.out.print(i+" ");
                if(cou % 30 ==0) System.out.println();
            }
        }
    }

}
