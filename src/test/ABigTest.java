package test;

import org.junit.Test;

import java.lang.reflect.Field;


public class ABigTest {
    @Test
    public void test01() throws NoSuchFieldException, IllegalAccessException {
        String a = "aaa";
        String b = "bbb";
        swap(a,b);
        System.out.println("out swap a:"+a);
        System.out.println("out swap b:"+b);

    }

    /** 反射修改String类 的实际值
     * 要知道
     * String 类的成员对象有
     * private final char[] value;
     * private final int offset;
     * private final int count;*/
    public void swap(String a,String b) throws NoSuchFieldException, IllegalAccessException {

        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        /**Object get(Object obj)
         返回该所表示的字段的值 Field ，指定的对象上 */
        char[] valueA = (char[]) valueField.get(a);
        valueA[0]='b';
        valueA[1]='b';
        valueA[2]='b';

        char[] valueB =(char[]) valueField.get(b);
        valueB[0]='a';
        valueB[1]='a';
        valueB[2]='a';
        System.out.println("in swap a:"+a);
        System.out.println("in swap b:"+b);
    }
}
