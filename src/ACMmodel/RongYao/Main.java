package ACMmodel.RongYao;


import java.util.Scanner;

public class Main {
    static int ansCou = 0;
    static boolean backUse = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        go(0,n);
        System.out.println(ansCou);

    }
    public static void go(int step,int target){
        if(step <0 ) return;
        if(step == target){
            ansCou++;
            return;
        }
        if(step >target) return;

        go(step+1,target);
        go(step+2,target);
        if(backUse == false){
            //可用可不用
            backUse = true;
            go(step-1,target);
            backUse = false;
        }
    }

}
