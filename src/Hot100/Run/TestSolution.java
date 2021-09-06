package Hot1000.Run;

import Others.RSAKeyPairGenerator;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;

public class TestSolution {
    public static void main(String args[]) throws IOException, NoSuchAlgorithmException {

       /* String testSpeed = new String("E:\\Gitfolder\\TestData\\testSpeed.txt");
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(testSpeed)));

        int L = 1000;
        System.out.println(L);
        int[][] indices = new int[L][16];
        Random random = new Random();


        for (int i = 0; i < L; i++) {
            for (int j = 0; j < 16; j++) {
                indices[i][j] = random.nextInt(100000000);
                dout.writeInt(indices[i][j]);
            }
        }
        dout.close();


        DataInputStream din = new DataInputStream(new BufferedInputStream(
                new FileInputStream(testSpeed)));

        int[][] readIndices = new int[L + 1][16];
        int readCount = 0;
        int readIntNum = din.available() / 4;
        System.out.println("available=" + readIntNum);
        try {
            for (int i = 0; i < 102; i++) {
                for (int j = 0; j < 16; j++) {
                    if (readCount < readIntNum) {
                        readIndices[i][j] = din.readInt();
                        readCount++;
                    }

                }
            }

        } catch (EOFException e) {
            System.out.println("readCount= " + readCount);

        }

        System.out.println("---");*/
        //-------------
       /* List<Integer> res = new ArrayList<Integer>() {{ add(0); add(1);}};
        System.out.println(res.toString());

*/
        /*System.out.println(1<<10);
        byte [][] testMaxArr = new byte[1<<29][1<<4];*/

        BigInteger multi1000 = BigInteger.ONE;
        for (int i = 0; i < 1000; i++) {
            multi1000 = multi1000.add(BigInteger.ONE);
        }


        byte[][] genBigNum1 = new byte[1000][384];
        byte[][] genBigNum2 = new byte[1000][384];
        byte[][] genBigNum3 = new byte[1000][384];
        BigInteger[] bigNumArr1 = new BigInteger[1000];
        BigInteger[] bigNumArr2 = new BigInteger[1000];
        BigInteger[] bigNumArr3 = new BigInteger[1000];
        Random random1 = new Random();
        Random random2 = new Random(111);

        for (int i = 0; i < 1000; i++) {
            random1.nextBytes(genBigNum1[i]);
            bigNumArr1[i] = new BigInteger(genBigNum1[i]);

            random2.nextBytes(genBigNum2[i]);
            bigNumArr2[i] = new BigInteger(genBigNum2[i]);

            bigNumArr3[i] = bigNumArr2[i].multiply(multi1000);
        }

        long[] start = new long[6];
        long[] end = new long[6];
        byte[] n = new byte[385];
        random1.nextBytes(n);
        BigInteger N = new BigInteger(n);
        N = N.abs();
        N = N.nextProbablePrime();
        //test add
        BigInteger add;
        start[0] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            add = bigNumArr1[i].add(bigNumArr2[i]);
        }
        end[0] = System.nanoTime();

        //test multiple
        BigInteger multi;
        start[1] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            multi = bigNumArr1[i].multiply(bigNumArr2[i]);
        }
        end[1] = System.nanoTime();

        //test modPower 小
        BigInteger modPow;
        start[2] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i);
            modPow = bigNumArr1[i].modPow(bigNumArr2[i], N);
        }
        end[2] = System.nanoTime();

        //test modPower 大
        BigInteger modPowBig;
        start[3] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            modPowBig = bigNumArr1[i].modPow(bigNumArr3[i], N);
        }
        end[3] = System.nanoTime();

        //test equal(actual equal)
       boolean res;
        start[4] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            res = bigNumArr1[i].equals(bigNumArr1[i]);
        }
        end[4] = System.nanoTime();

        //test equal(actual no equal)
        boolean res2;
        start[5] = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            res2 = bigNumArr1[i].equals(bigNumArr2[i]);
        }
        end[5] = System.nanoTime();

        long[] resTime = new long[6];
        for (int i = 0; i < 6; i++) {
            resTime[i] = end[i] - start[i];
        }




        System.out.println("放大1000倍的差距：");
        System.out.println(" test add= " + resTime[0]);
        System.out.println(" test multi= " + resTime[1]);
        System.out.println(" test modPower= " + resTime[2]);
        System.out.println(" test modPower 大= " + resTime[3]);
        System.out.println(" test equal == " + resTime[4]);
        System.out.println(" test equal != " + resTime[5]);

    }

}
