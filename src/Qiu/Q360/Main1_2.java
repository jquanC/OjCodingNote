package Qiu.Q360;

import java.util.Arrays;
import java.util.Scanner;

public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[] testScore = new int[n];
        for(int i=0;i<n;i++){
            testScore[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("p="+p);
        System.out.println("q="+q);
        Arrays.sort(testScore);
        int original = 100;
        int cou=0;
        for(int i = n-1;i>=0;i--){
            if(i==n-1){
                int f = (testScore[i]*q+original*p)/100;
                if(f>=60) cou++;
                System.out.println("testScore="+testScore[i]+"original="+original);
                continue;

            }
            if(testScore[i] == testScore[i+1]){
                int f = (testScore[i]*q+original*p)/100;
                if(f>=60) cou++;
                System.out.println("testScore="+testScore[i]+"original="+original);

            }else{
                original--;
                int f = (testScore[i]*q+original*p)/100;
                if(f>=60) cou++;
                System.out.println("testScore="+testScore[i]+"original="+original);
            }

        }

        System.out.println(cou);


    }
}
