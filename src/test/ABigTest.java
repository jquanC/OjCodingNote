package test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;


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
    @Test
    public void test(){
        int[] arr = new int[10];
//        dfsPrint(arr,0);
//        System.out.println(Arrays.toString(arr));
        int a = 0;
        dfsPrintBasicNum(a,0);
        System.out.println(a);
    }
    public void dfsPrint(int[] arr,int step){
        if(step ==10) return;
        arr[step] = step;
        System.out.println("step="+step+","+Arrays.toString(arr));
        dfsPrint(arr,step+1);
        System.out.println("step="+step+",after dfs return,a="+Arrays.toString(arr));
    }
    public void dfsPrintBasicNum(int a,int step){
        if(step ==10) return;
        a = step;
        System.out.println("step="+step+","+a);
        dfsPrintBasicNum(a,step+1);
        System.out.println("step="+step+",after dfs return"+a);
    }
}
