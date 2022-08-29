package Qiu.QiAnX;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = str.substring(1,str.length()-1);
        String[] strs = str1.split(",");
        int[] arr = new int[strs.length];
        for(int i=0;i<arr.length;i++){
            arr[i]  = Integer.parseInt(strs[i].trim());
        }
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            ans = Math.max(ans,(right-left)*Math.min(arr[left],arr[right]));
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(ans);

    }
}
