package Others;

import jdk.internal.org.objectweb.asm.tree.FrameNode;

import java.math.BigInteger;
import java.util.Random;

public class TestPrimeCalculation {
    public static void main(String[] args) {
        BigInteger ex11 = new BigInteger(40, new Random(11));
        BigInteger ex12 = new BigInteger(40, new Random(12));
        BigInteger ex13 = new BigInteger(40, new Random(13));

        BigInteger ex21 = new BigInteger(40, new Random(21));
        BigInteger ex22 = new BigInteger(40, new Random(22));
        BigInteger ex23 = new BigInteger(40, new Random(23));

        BigInteger ex31 = new BigInteger(40, new Random(31));
        BigInteger ex32 = new BigInteger(40, new Random(32));
        BigInteger ex33 = new BigInteger(40, new Random(33));

        BigInteger N = BigInteger.probablePrime(3080, new Random(100));
        //BigInteger N = new BigInteger(200, new Random(66));
        //BigInteger g = new BigInteger(3070, new Random(80));
        BigInteger g = BigInteger.probablePrime(3070, new Random(80));
        System.out.println("N： " + N.isProbablePrime(200));
        System.out.println("g： " + g.isProbablePrime(200));


        BigInteger[] poi = new BigInteger[3];
        for (int i = 0; i < 3; i++) {
            poi[i] = BigInteger.ZERO;
        }
        poi[0] = poi[0].add(ex11);
        poi[0] = poi[0].add(ex12);
        poi[0] = poi[0].add(ex13);
        poi[0] = g.modPow(poi[0],N);

        poi[1] = poi[1].add(ex21);
        poi[1] = poi[1].add(ex22);
        poi[1] = poi[1].add(ex23);
        poi[1] = g.modPow(poi[1],N);

        poi[2] = poi[2].add(ex31);
        poi[2] = poi[2].add(ex32);
        poi[2] = poi[2].add(ex33);
        poi[2] = g.modPow(poi[2],N);

        BigInteger R = ((poi[0].multiply(poi[1])).multiply(poi[2])).mod(N);

        BigInteger index = ex11.add(ex12).add(ex13).add(ex21).add(ex22).add(ex23).add(ex31).add(ex32).add(ex33);


        BigInteger RCheck = g.modPow(index, N);

        System.out.println(R.equals(RCheck));

    }

}
