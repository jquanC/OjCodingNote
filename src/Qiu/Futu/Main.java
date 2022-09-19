package Qiu.Futu;

import java.util.ArrayList;
import java.util.Scanner;
/*
2
4
1101
3
101

* */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer>[] ans = new ArrayList[T];
        for (int i = 0; i < T; i++) {
            ans[i] = new ArrayList();
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int rZero = -1;
            int rOne = -1;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    ans[i].add(-1);
//                    System.out.print("-1 ");
                    if (str.charAt(j) == '1') {
                        rOne = j+1;
                    }else rZero = j+1;
                    continue;
                }
                if(str.charAt(j)=='1'){
                    ans[i].add(rZero);
//                    System.out.print(rZero+" ");
                    rOne  = j+1;
                    continue;
                }
                ans[i].add(rOne);
//                System.out.print(rOne+" ");
                rZero = j+1;
            }
//            System.out.println();
        }
        for(ArrayList<Integer> e:ans){
            for(int i=0;i<e.size();i++){
                if(i!=e.size()-1){
                    System.out.print(e.get(i)+" ");
                }else{
                    System.out.print(e.get(i));
                }
            }
            System.out.println();
        }

    }
}
