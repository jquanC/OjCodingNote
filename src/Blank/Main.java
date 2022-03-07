package Blank;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        sc.nextLine();
        int[] arr = new int[set.size()];
        int index = 0;
        for (int e : set) {
            arr[index++] = e;
        }
        Arrays.sort(arr);
        if (arr.length == 1) {
            System.out.println(1);
            return;
        }
        if (arr.length == 2) {
            if (arr[1] - arr[0] > 1) System.out.println(2);
            else System.out.println(1);
            return;
        }

        boolean[] choose = new boolean[set.size()];
        int cou1 = 1;
        //count arr[0];
        choose[0] = true;
        for (int i = 1; i < arr.length; i++) {
            if (choose[i - 1] == false) {
                cou1++;
                choose[i] = true;
            } else {
                if (arr[i] - arr[i - 1] > 1) {
                    cou1++;
                    choose[i] = true;
                }
            }
        }
        //not count arr[0],count arr[1]
        boolean[] choose2 = new boolean[set.size()];
        int cou2 = 1;
        choose2[0] = false;
        choose2[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (choose2[i - 1] == false) {
                cou2++;
                choose2[i] = true;
            } else {
                if (arr[i] - arr[i - 1] > 1) {
                    cou2++;
                    choose2[i] = true;
                }
            }
        }
        if (cou1 > cou2) System.out.println(cou1);
        else System.out.println(cou2);
    }


}
