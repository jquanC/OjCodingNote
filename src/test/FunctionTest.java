package test;

import org.junit.Test;

public class FunctionTest {
    public void print(int m){
        System.out.println(m);
    }
    @Test
    public void test(){
        String test1 = new String("xxxxxx\n"+"yyyyy");
        String test2 = new String("xxxxxx\\n"+"yyyyy");

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test1+"\n"+test2);
    }
}
