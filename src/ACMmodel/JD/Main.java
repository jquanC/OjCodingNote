package ACMmodel.JD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b,c,d;
        a = scan.nextInt(); //初始坦克数
        b = scan.nextInt(); //碉堡初始生命值
        c = scan.nextInt(); // 碉堡攻击力，每次消灭c量坦克 const
        d = scan.nextInt(); // 初始碉堡数
        scan.nextLine();

        //最佳的策略就是每次攻击要尽可能减少碉堡数量，几种力量攻击一个碉堡
        System.out.println(game(a,b,c,d));

    }
    public static int game(int a,int b,int c,int d){
        int lastLife = b;

        int index = 1;//接下来要攻击的碉堡编号
        int count = 0;
        while(index<=d && a>=0){
            //小七攻击
            // 1 预减 lastLife 碉堡
            // 2 可消灭整数个的碉堡
            // 3 更新lastLife
            int curPow = a;
            if(curPow<lastLife){
                break;
            }
            curPow -= lastLife;
            index++;
            int n = curPow/b;
            lastLife = b-curPow%b;
            index = index + n;

            //碉堡攻击
            a -= (d-index+1)*c;

            //一回合结束
            count++;
        }
        if(index > d){
            return count;
        }
        return -1;
    }
}
