package Hot100.Run;

public class TestUseClass {
    public void testMethod(int x){
        int x1 = x;
        test(x1);
        System.out.println(x1);


    }
    private void test(int x){
        int x2 = x+1;
    }
}
