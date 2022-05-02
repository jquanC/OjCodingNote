package ACMmodel.TenCentOld.fall2021;

import org.junit.Test;

import java.util.Scanner;

/**
 *1005 9854
 *29529.76 正确答案
 * 29529.77
 * */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt(); //细节！
        double m = sc.nextInt();
        sc.nextLine();
        double cost = 0;
        while(m!=0){
            double A = n/(n+m);//细节！
            double B = m/(n+m);
            cost += (A/B)*1+1*2;
            m--;
        }
//        System.out.println(cost);
//        String strAns = new DecimalFormat("###.###").format(cost);
//        System.out.println(strAns);

        System.out.printf("%.2f\n",cost);

    }
    @Test
    public void test(){
        float fnum = 0.1054f;
        System.out.printf("%.2f\n",fnum);
        System.out.printf("%.2f%n",fnum);
        System.out.printf("%s \n", new Integer(1212));
        System.out.printf("%s%n", "end line");
        System.out.printf("%s = %s%n", "Name", "Zhangsan");
        System.out.printf("%S = %s%n", "Name", "Zhangsan");
        Double dObj = 45.6d;
        System.out.printf("%f; %f; %f%n", -756.403f, 7464.232641d, dObj);
        System.out.printf("%.1f; %.3f; %f%n", -756.403f, 7464.232641d, dObj);
        System.out.println("***");
    }
}
