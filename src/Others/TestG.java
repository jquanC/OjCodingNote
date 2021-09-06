package Others;

import jdk.internal.org.objectweb.asm.tree.FrameNode;

import java.math.BigInteger;
import java.util.Random;

public class TestG {
    public static void main(String args[]) {

        BigInteger N = new BigInteger(3080, new Random(1111));
        //BigInteger prime = BigInteger.probablePrime(128, new Random(2222));
        BigInteger prime =  new BigInteger(128, new Random(2222));

        int bitLen = 10;
        int count = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        while ((count < 1 << 16) && flag1 && flag2) {
            prime = prime.nextProbablePrime();
            count++;
            if (N.gcd(prime).equals(BigInteger.ONE)) {
                if (N.gcd(prime.subtract(BigInteger.ONE.add(BigInteger.ONE))).equals(BigInteger.ONE)) {
                    flag1 = false;
                } else if (N.gcd(prime.add(BigInteger.ONE.add(BigInteger.ONE))).equals(BigInteger.ONE)) {
                    flag2 = false;
                }

            }


        }
        BigInteger prime2;
        if (flag1 == false) {
            System.out.println("from sub");
            prime2 = prime.subtract(BigInteger.ONE.add(BigInteger.ONE));
            //verify again
            if (N.gcd(prime).equals(BigInteger.ONE) && N.gcd(prime2).equals(BigInteger.ONE)) {
                System.out.println("verify pass");
            }
        }
        if (flag2 == false) {
            System.out.println("from add");
            prime2 = prime.add(BigInteger.ONE.add(BigInteger.ONE));
            if (N.gcd(prime).equals(BigInteger.ONE) && N.gcd(prime2).equals(BigInteger.ONE)) {
                System.out.println("verify pass");
            }

            System.out.println("flag1 = " + flag1 + " flag2= " + flag2);

        }
        System.out.println("prime len:"+ prime.toByteArray().length);
    }
}
