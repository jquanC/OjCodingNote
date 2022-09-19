package Qiu.ShengXF;

public class Main2 {
    public static void main(String[] args) {
        Main2 so = new Main2();
        int ans = so.nucleicAcidTestWay(5);
        System.out.println(ans);
    }
    public int nucleicAcidTestWay (int n) {
        // write code here
        if(n==1) return 1;
        if(n==2) return 2;
        return nucleicAcidTestWay(n-1)+nucleicAcidTestWay(n-2);

    }
}
