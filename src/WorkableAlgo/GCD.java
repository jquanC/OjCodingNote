package WorkableAlgo;

public class GCD {
    /**CAL zui da gong yue shu*/
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
