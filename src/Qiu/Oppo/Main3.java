package Qiu.Oppo;

public class Main3 {
    public static void main(String[] args) {

    }
    public long tourismRoutePlanning (int scenicspot) {
        // write code here
        if(scenicspot == 1) return 1;
        if(scenicspot == 2) return 2;
        return tourismRoutePlanning(scenicspot-1)+tourismRoutePlanning(scenicspot-2);
    }
}
