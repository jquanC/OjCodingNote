package Qiu.MEIT;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       sc.nextLine();
       for(int i=0;i<T;i++){
           int a = sc.nextInt();
           int b = sc.nextInt();
           sc.nextLine();
           int ans = cal(a,b);
           System.out.println(ans);
       }
    }
    public static int cal(int aNum,int bNum){
        int maxBox = 0;
        long lNum = Math.min(aNum,bNum);
        long mNum = Math.max(aNum,bNum);
        //枚举boxNum
        boolean find = true;
        for(long boxNum = 1;boxNum<=lNum && find;boxNum++){
            //校验当前boxNum下，是否存在可分配解：枚举装lessPrond 1个数量的盒子
            find = false;
            for(long ln1 = boxNum;ln1>=1;ln1--){
                long ln2 = boxNum-ln1;
                long mn1 = ln2;
                long mn2 =ln1;
                if((ln1+2*ln2)<=lNum&&(mn1+2*mn2)<=mNum){
                    maxBox = (int)Math.max(maxBox,boxNum);
                    find = true;
                    break;
                }
            }
        }
        return maxBox;

    }
}
