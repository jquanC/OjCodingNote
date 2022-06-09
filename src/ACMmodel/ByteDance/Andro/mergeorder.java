package ACMmodel.ByteDance.Andro;


import java.util.Arrays;

/**
 * [1,5,8,12, , , ]
 * [2,9,10]
 * */
public class mergeorder {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,5,8,12,0,0,0};
        int[] a2 = new int[]{2,9,10};
        int m = 4;
        int n = 3;
        int pCur = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        while(p1>=0&&p2>=0){
            if(a1[p1]>=a2[p2]){
                a1[pCur] = a1[p1];
                p1--;
            }else{
                a1[pCur] = a2[p2];
                p2--;
            }
            pCur--;
        }
        while(p2>=0){
            a1[pCur] = a2[p2];
            pCur--;
            p2--;
        }
        System.out.println(Arrays.toString(a1));

    }
}
