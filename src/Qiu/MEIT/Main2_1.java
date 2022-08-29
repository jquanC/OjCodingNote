package Qiu.MEIT;


import java.util.Scanner;

public class Main2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        int[] pre = new int[n+2];//表示第1个..第i个数字中，异常的数据个数
        int[] post = new int[n+2];//表示第n..第j个数字中，异常的数据个数
        for(int i=1;i<=n;i++){
            if(arr[i-1]>=0){
                pre[i] = pre[i-1]+1;
            }else pre[i] = pre[i-1];
        }
        for(int i=n;i>=1;i--){
            if(arr[i-1]<=0){
                post[i] = post[i+1]+1;
            }else post[i] = post[i+1];
        }
        int ans = 0x3f3f3f3f;
        for(int i=1;i<=n-1;i++){
            if(pre[i]+post[i+1]<ans) ans  = pre[i] + post[i+1];
        }
        System.out.println(ans);


    }


}
