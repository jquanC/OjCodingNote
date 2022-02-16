package test.ClassLoaderTest;


public class ClassLoaderDemo {
    static class School{
        static{
            System.out.println("School 静态代码块");
        }
    }
    static class Teacher extends School{
        static {
            System.out.println("Teacher 静态代码块");
        }
        public static String name = "Tony";
        public Teacher() {
            System.out.println("I'm Teacher");
        }
    }
    static class Student extends Teacher{
        static {
            System.out.println("Student 静态代码块");
        }
        public Student() {
            System.out.println("I'm Student");
        }

    }
    static class InitializationDemo{
        public static void main(String[] args) {
            System.out.println("Teachers name is"+Student.name);
        }
    }
}
