package ACMmodel.NetEase;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int len = n*2-1;
        char[][] arr = new  char[len+1][len+1];
        int lCou = 1;
        int rCou = 1;
        for(int i=1;i<=n-1;i++){
            //画左部分
            int j =1;
            while(j<n){
                if(j==1 || j==lCou){
                    arr[i][j] = '*';
                }
                j++;
            }
            lCou++;
            //画右部分
            j =n;
            while(j<=len){
                if(i==1){
                    arr[i][j] = '*';
                    j++;
                }else{
                    if(j==n ||j==len-rCou+1){
                        arr[i][j] = '*';
                    }
                    j++;
                }

            }
            rCou++;
        }
        //不变
        for(int j=1;j<=len;j++){
            arr[n][j] = '*';
        }
        for(int i=n+1;i<=len;i++){
            for(int j=1;j<=len;j++){
                arr[i][j] = arr[len+1-i][len+1-j];
            }
        }
        for(int i=1;i<=n-1;i++){
            for(int j=1;j<=len;j++){
                if(arr[i][j] == '*'){
                    System.out.print(arr[i][j]);
                    continue;
                }
                if(j<=len-i+1) System.out.print(" ");
            }
            System.out.println();
        }
        //
        for(int i=n;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(arr[i][j] == '*'){
                    System.out.print(arr[i][j]);
                }else{
                   System.out.print(" ");
                }
            }
            if(i!=len)System.out.println();
        }
    }
}
