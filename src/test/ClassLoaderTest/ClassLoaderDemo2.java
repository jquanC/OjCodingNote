package test.ClassLoaderTest;


public class ClassLoaderDemo2 {
    static class School{
        static{
            System.out.println("School 静态代码块");
        }
        public School() {
            System.out.println("I'm School");
        }
    }
    static class Teacher extends School{
        static {
            System.out.println("Teacher 静态代码块");
        }
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
            new Student();
        }
    }
}
