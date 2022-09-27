package Qiu.Ant;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<q;i++){
            int op = sc.nextInt();
            int idx = sc.nextInt();
            int num = sc.nextInt();
            sc.nextLine();
            if(op==1){
                arr[idx] = num;
                continue;
            }
            int cou = 0;
            for(int j=1;j<=idx;j++){
                if(arr[j]==num) cou++;
            }
            ans.add(cou);

        }
        for(Integer e: ans) System.out.println(e);
    }
}
