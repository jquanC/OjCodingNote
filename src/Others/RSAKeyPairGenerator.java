package Others;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

public class RSAKeyPairGenerator {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;
    private BigInteger field;
    RSAKeyPairGenerator() throws NoSuchAlgorithmException {

        KeyPairGenerator keyGen =  KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(3072);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = (RSAPrivateKey)pair.getPrivate();
        this.publicKey = (RSAPublicKey)pair.getPublic();



    }
    public RSAPrivateKey getPrivateKey(){
        return privateKey;
    }
    public RSAPublicKey getPublicKey(){
        return publicKey;
    }

    private static BigInteger findFactor(BigInteger e, BigInteger d, BigInteger n) {
        BigInteger edMinus1 = e.multiply(d).subtract(BigInteger.ONE);
        int s = edMinus1.getLowestSetBit();
        BigInteger t = edMinus1.shiftRight(s);

        for (int aInt = 2; true; aInt++) {
            BigInteger aPow = BigInteger.valueOf(aInt).modPow(t, n);
            for (int i = 1; i <= s; i++) {
                if (aPow.equals(BigInteger.ONE)) {
                    break;
                }
                if (aPow.equals(n.subtract(BigInteger.ONE))) {
                    break;
                }
                BigInteger aPowSquared = aPow.multiply(aPow).mod(n);
                if (aPowSquared.equals(BigInteger.ONE)) {
                    return aPow.subtract(BigInteger.ONE).gcd(n);
                }
                aPow = aPowSquared;
            }
        }

    }


    public RSAPrivateCrtKey createRsaPrivateCryKey(RSAPublicKey rsaPub, RSAPrivateKey rsaPriv) throws InvalidKeySpecException, NoSuchAlgorithmException {

        BigInteger e = rsaPub.getPublicExponent();
        BigInteger d = rsaPriv.getPrivateExponent();
        BigInteger n = rsaPub.getModulus();
        BigInteger p = findFactor(e, d, n);
        BigInteger q = n.divide(p);
        if (p.compareTo(q) > 0) {
            BigInteger t = p;
            p = q;
            q = t;
        }
        BigInteger exp1 = d.mod(p.subtract(BigInteger.ONE));
        BigInteger exp2 = d.mod(q.subtract(BigInteger.ONE));
        BigInteger coeff = q.modInverse(p);
        RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(n, e, d, p, q, exp1, exp2, coeff);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPrivateCrtKey) kf.generatePrivate(keySpec);

    }


}
