package ACMmodel.RongYao;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            sc.nextLine();
            int[] record = new int[n];
            for(int j=0;j<n;j++){
                record[j] = sc.nextInt();
            }
            sc.nextLine();
            //调用函数求解
            slove(record);
        }
    }
    public static void slove(int[] record){
        int max = 0;
        int len = record.length;
        int life = 0;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(record[j] == record[i]) continue;
                if(record[j]<record[i]) life++;
                else {
                    life--;
                }
            }
            if(life > max) max = life;
        }
        System.out.println(max+" "+life);
    }
}
