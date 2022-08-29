package Qiu.JD;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        char[] srr = line.toCharArray();
        for(int i=0;i<n;i++){
            if(i<k){
                srr[i] = Character.toUpperCase(srr[i]);
            }else{
                srr[i] = Character.toLowerCase(srr[i]);
            }
        }
        System.out.println(String.valueOf(srr));
    }
}
