package Qiu.Q360;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
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
        Arrays.sort(testScore);
        HashMap<Integer,Integer> originMap =new HashMap();
        int original = 100;
        for(int i = n-1;i>=0;i--){
            if(originMap.containsKey(testScore[i])) continue;
            if(original == 0) originMap.put(testScore[i],0);
            else originMap.put(testScore[i],original--);
        }
        int cou = 0;
        for(int i = 0;i<n;i++){
            if((testScore[i]*q+originMap.get(testScore[i])*p)/100 >=60) cou++;
        }
        System.out.println(cou);


    }
}
