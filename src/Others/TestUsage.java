package Others;

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

public class    TestUsage {
    public static void main(String args[]) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        //RSA key pair test
        RSAKeyPairGenerator rsa = new RSAKeyPairGenerator();
        RSAPrivateKey privateKey = rsa.getPrivateKey();
        RSAPublicKey publicKey = rsa.getPublicKey();
        BigInteger f1= privateKey.getModulus();
        byte[] skByte = privateKey.getEncoded();
        byte[] pkByte = publicKey.getEncoded();
        System.out.println("skByte[] length "+skByte.length);
        System.out.println("pkByte[] length "+pkByte.length);
        BigInteger f2 = publicKey.getModulus();
        System.out.println("modulus byte[] length "+f1.toByteArray().length);
        System.out.println("sk "+privateKey);
        System.out.println("pk "+publicKey);
        System.out.println("f1 "+f1);
        System.out.println("f2 "+f2);

        final BigInteger e = publicKey.getPublicExponent(); // treat as 'g'
        final BigInteger d =  privateKey.getPrivateExponent();



        System.out.println("public e byte[] length "+e.toByteArray().length);
        System.out.println("private d byte[] length "+d.toByteArray().length);


        RSAPrivateCrtKey rskSK = rsa.createRsaPrivateCryKey(publicKey,privateKey );
        BigInteger primeP = rskSK.getPrimeP();//n 素因子
        BigInteger primeQ = rskSK.getPrimeQ();//n 素因子
        System.out.println("prime p len="+primeP.toByteArray().length);
        System.out.println("prime q len="+primeQ.toByteArray().length);

        BigInteger e2 = rskSK.getPublicExponent();//公共指数因子
        BigInteger d2 = rskSK.getPrivateExponent();
        System.out.println(e2.equals(e));
        System.out.println(d2.equals(d));


        //大整数相等测试
        /*BigInteger one = new BigInteger("123456789");
        BigInteger two = new BigInteger("123456789");
        System.out.println(one.equals(two));*/



    }

}
