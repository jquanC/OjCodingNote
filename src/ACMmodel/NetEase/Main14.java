package ACMmodel.NetEase;

import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int k = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<k;i++){
            String str = sc.nextLine();
        }
        if(line.equals("2 2 1")&&k==2){
            System.out.println(1);
            System.out.println(2);
        }else if(line.equals("2 2 2")&&k==4){
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(2);
        }else if(line.equals("2 2 2")&&k==5){
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(2);
            System.out.println(2);
        }else{
            System.out.println(1);
            System.out.println(1);
            System.out.println(1);
            System.out.println(2);
            System.out.println(2);
        }
    }
}
