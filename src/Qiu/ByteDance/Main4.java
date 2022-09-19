package Qiu.ByteDance;

import java.util.HashSet;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();
        HashSet<Integer>[] useSet = new HashSet[N];
        for(int i=0;i<N;i++){
            int n = sc.nextInt();
            useSet[i] = new HashSet<Integer>();
            for(int j=0;j<n;j++){
                useSet[i].add(sc.nextInt());
            }
            sc.nextLine();
        }
        for(int i=0;i<Q;i++){
            int t = sc.nextInt();
            boolean find = true;
            int[] seq = new int[t];
            for(int j=0;j<t;j++){
                seq[j] = sc.nextInt();
            }
            int cou = cal(seq,useSet);
            System.out.println(cou);

        }
    }

    public static  int cal(int[]seq,HashSet<Integer>[] useSet){
        int cou = 0;
        for(int i=0;i<useSet.length;i++){
            HashSet<Integer> curUser = useSet[i];
            boolean find = true;
            for(int j=0;j<seq.length;j++){
                if(seq[j]>0){
                    if(curUser.contains(seq[j])) continue;
                    else find = false;

                }else{
                    if(!curUser.contains(Math.abs(seq[j]))) continue;
                    else find = false;
                }
            }
            if(!find) continue;
            cou++;

        }
        return cou;
    }
}
