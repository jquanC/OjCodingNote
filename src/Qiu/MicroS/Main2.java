package Qiu.MicroS;


import java.util.Arrays;


public class Main2 {

    public static void main(String[] args) {


    }
    long ans = 0;
    public int solution(int[] X, int[] Y) {
        // write your code in Java 8 (Java SE 8)
        double[] nx = new double[X.length];
//        double[] ny = new double[Y.length];
        double fenMu = Y[0];
        for (int i = 1; i < Y.length; i++) {
            fenMu = calMinBeiShu(fenMu, Y[i]);
        }
        for (int i = 0; i < X.length; i++) {
            nx[i] =(fenMu/Y[i])*X[i];
//            ny[i] = fenMu;
        }
        cal(nx,0,0,fenMu);
        return (int) ans;


    }
    //每个数有选和不选

    public void cal(double[] nx,int index,double curSum,double target){
        if(curSum == target){
            ans++;
            if(ans>1000000007){
                ans %= 1000000007;
            }
            return ;
        }
        if(curSum > target) return;
        if(index >= nx.length) return;

        cal(nx,index+1,curSum+nx[index],target);
        cal(nx,index+1,curSum,target);
    }

    public double calMinBeiShu(double a, double b) {
        if (a < b) {
            double t = a;
            a = b;
            b = t;
        }
        while (b != 0) {
            if (a == b) {
                return a;
            }
            double k = a % b;
            a = b;
            b = k;
        }
        return a;
    }

}
