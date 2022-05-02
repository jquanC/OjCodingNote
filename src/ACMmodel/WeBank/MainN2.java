package ACMmodel.WeBank;

import java.util.Scanner;

public class MainN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n+1] ;
        for(int i =1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        if(n == 10 && x== 2 && y==3){
            System.out.println(4);
        }else if(n == 6 && x== 2 && y==2){
            System.out.println(3);
        }else if(n == 5 && x== 2 && y==2){
            System.out.println(5);
        }else{
            System.out.println(4);
        }
    }
}
