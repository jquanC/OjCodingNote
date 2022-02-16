package test.ClassLoaderTest;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class ClassLoaderDemo3 {
    static class Teacher {
        public static void main(String[] args) {
            staticFunction();
        }
        static Teacher teacher = new Teacher();
        static {
            System.out.println("teacher 静态代码块");
        }
        {
            System.out.println("teacher普通代码块");
        }
        Teacher() {
            System.out.println("teacher 构造方法");
            System.out.println("age= " + age + ",name= " + name);
        }
        public static void staticFunction() {
            System.out.println("teacher 静态方法");
        }
        int age = 24;
        static String name = "Tony";
    }
    @Test
    public void test6(){
        List<Integer> list = new ArrayList<>();
        String a = "asv";
        char b = 'b';
        System.out.println(a+b);

    }


}
