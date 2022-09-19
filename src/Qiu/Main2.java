package Qiu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        //第一遍遍历，贪心的处理使用踏前斩的情况
        long mpUsed = 0;
        for(int i=0;i<n;i++){
            while(i+2<n && arr[i]>=1 && arr[i+1]>=2&&arr[i+2]>=3){
                mpUsed+=5;
                arr[i]-=1;
                arr[i+1]-=2;
                arr[i+2]-=3;
            }
            mpUsed+=arr[i];
        }
        /*
        for(int i=0;i<n;i++){
            mpUsed += arr[i];
        }*/
        System.out.println(mpUsed);
    }
}
