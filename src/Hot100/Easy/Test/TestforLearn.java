package Hot100.Easy.Test;

public class TestforLearn {
    public static void main(String args[]){
        TestClass testClass1 = new TestClass(1,2);
        changeNum(testClass1);
        System.out.println("here1:"+testClass1.i);
        System.out.println("here2:"+testClass1.j);

    }
    public static void changeNum(TestClass testClass2){
        testClass2.i = 3;
        TestClass testClass3 = testClass2;
        testClass3.j = 5;
    }
}