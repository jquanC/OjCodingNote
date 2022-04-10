package ACMmodel.RongYao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        int[] parr = new int[M + 100];
        //构造素数表，0表示是素数，1表示不是
        for (int i = 2; i < parr.length / 2 + 10; i++) {
            int k = 2;
            int index = i * k;
            while (index < parr.length) {
                parr[index] = 1;
                k++;
                index = i * k;
            }
        }
        int offset = 0;
        int start = M / 2;
        boolean find = false;

        int num1 = start + offset;
        int num2 = start - offset;
        while (num1 < M && num2>=1){
            if(parr[num1]==0 && parr[num2]==0){
                find = true;
                break;
            }
            offset++;
            num1 = start+offset;
            num2 = start-offset;
        }
        if(find) System.out.println(num2+" "+num1);
        else System.out.println(0);


    }
}
