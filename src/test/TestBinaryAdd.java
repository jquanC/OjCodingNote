package test;

import org.junit.Test;

public class TestBinaryAdd {


    public int add(int a, int b) {
        int ci = 0;
        int res[] = new int[32];

        if(a<0 && b<0 || a<0 && Math.abs(a)>b || b<0 && Math.abs(b)>a)res[31]=1;

        for (int i = 0; i < 31; i++) {

            res[i] = (a & 0x01) ^ (b & 0x01) ^ ci;

            if (((a & 0x01) + (b & 0x01) + ci) >= 2) ci = 1;
            else ci = 0;

            a = a >> 1;
            b = b >> 1;
        }



        int ans = 0;
        int factor = 1;
        for (int i = 0; i < 31; i++) {
            if (i != 0) factor *= 2;

            if(res[31]==1) res[i] = (~res[i])+1;

            if(res[i] == 1) ans+=factor;
        }
        return res[31]==1? -ans:ans;
    }
    @Test
    public void test(){
        int res = add(1,-2);
        System.out.println(res);

    }
    @Test
    public void test2(){
        int a = -4;
        int b = 3;
        int c = a & b;

    }
    @Test
    public void test3(){
        int a = -4;
        int b =3;

        int c = a<<1;
        int d = b<<1;

        int f = a>>>1;
        int e = b>>>1;


    }
}
