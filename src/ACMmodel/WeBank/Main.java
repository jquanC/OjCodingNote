package ACMmodel.WeBank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //确定位数
        int k=1;
        while((int)Math.pow(16,k)<N){
            k++;
        }
        int cou=0;
        for(int j=k-1;j>=0;j--){
            int bitWeight = (int)Math.pow(16,j);
            int curVal = N/bitWeight;
            if(curVal >=10 ) cou++;
            N = N%bitWeight;
        }
        System.out.println(cou);
    }
}
