package Qiu.Shein;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            boolean reached = false;
            boolean finished = false;
            int start = 0;
            int end = -1; //记得
            for(int j=0;j<n;j++){
                int curNum = sc.nextInt();
                if(!finished) continue; //单纯为了接收
                if(curNum>=k && !reached){
                    reached = true;
                    start = j;
                }
                if( curNum<k && finished){
                    end = j-1;
                }
            }
            if(end == -1 && reached){//此情况是，符合目标的元素是输入最后一个元素时的情况
                end = start;
            }
        }
    }
}
