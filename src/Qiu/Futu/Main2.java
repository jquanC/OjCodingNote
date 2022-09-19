package Qiu.Futu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            sc.nextLine();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double one =(double) 1.0*o1[1]/1.0*o1[0];
                double two =(double) 1.0*o2[1]/1.0*o2[0];
                if(two>one) return 1;
                else return -1;

            }
        });
        int cou = 0;
        int k=0;
        while(true){
            if(k<n&&m>arr[k][0]){
                int t = m/arr[k][0];
                cou += t*arr[k][1];
                m-=t*arr[k][0];
                k++;
            }else break;
        }
        System.out.println(cou);

    }
}
