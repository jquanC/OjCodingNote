package test.TestExample;

public class Child extends Parent{
    public static void main(String[] args) {
        Child child = new Child();
        int a = 0xFFFFFFF1;
        int b = ~a;
        System.out.println(b);
    }
    public Child(){
        System.out.println("i am child");
    }
}
