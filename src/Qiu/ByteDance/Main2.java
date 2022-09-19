package Qiu.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<String> ans = new ArrayList();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                set.add(arr[j]);
            }
            sc.nextLine();
            //计算当前组的解
            boolean find = false;
            Arrays.sort(arr);
            //ai aj ak

            for (int idi = 0; idi < n - 3 + 1 && !find; idi++) {

                if (idi != 0) {
                    if(arr[idi]==arr[idi-1]) continue;
                }
                long ai = arr[idi];//确定idi
//
                for (int idj = idi + 1; idj < n - 3 + 2 && !find; idj++) {
                    //不是第一次，需要选不重
                    if (idj != idi + 1) {
                        if (arr[idj] == arr[idj - 1]) continue;
                    }
                    long aj = arr[idj];
                    for (int idk = idj + 1; idk < n - 3 + 3 && !find; idk++) {
                        if (idk != idj + 1) {
                            if (arr[idk] == arr[idk - 1]) continue;
                        }
                        long ak = arr[idk];
                        int tSum = (int)(ai+ak+aj);
                        if (set.contains(tSum)) {
                            ans.add("YES");
//                            System.out.println("ai="+ai+"aj="+aj+"ak="+ak);
                            find = true;
                            break;
                        }
                    }
                }
            }
            if(!find) ans.add("NO");
        }
        for(String e:ans){
            System.out.println(e);
        }
    }
}
