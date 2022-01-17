package test;

import org.junit.Test;

public class FunctionTest {
    public void print(int m){
        System.out.println(m);
    }
    @Test
    public void test(){
        int index =1 ;
        print(index+1);
        print(index+1);
        print(index+1);
    }
}
