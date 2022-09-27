package Qiu.BLIbli;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        String line = sc.nextLine();
        int RposMax = 0;
        int RposMin = Integer.MAX_VALUE;
        int RnegMax = Integer.MIN_VALUE;
        int RnegMin = -1;
        int BposMax = -1;
        int BposMin = Integer.MAX_VALUE;
        int BnegMax = Integer.MIN_VALUE;
        int BnegMin = -1;
        for(int i=0;i<n;i++){
            if(line.charAt(i)=='B'){
                if(arr[i]>=0){
                    BposMax = Math.max(BposMax,arr[i]);
                    BposMin = Math.min(BposMin,arr[i]);

                }else{
                    BnegMax = Math.max(BnegMax,arr[i]);
                    BnegMin = Math.min(BnegMin,arr[i]);
                }
            }else{
                if(arr[i]>=0){
                    RposMax = Math.max(RposMax,arr[i]);
                    RposMin = Math.min(RposMin,arr[i]);

                }else{
                    RnegMax = Math.max(RnegMax,arr[i]);
                    RnegMin = Math.min(RnegMin,arr[i]);
                }
            }
        }
        int a1 = RposMax*BposMax;
        int a2 = RnegMin*BnegMin;
        int a3 = RposMin*BnegMax;
        int a4 = RposMax*RnegMin;
        System.out.println(Math.max(Math.max(Math.max(a1,a2),a3),a4));

    }
}
