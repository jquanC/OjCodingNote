package Others.ClassAttributrTest;

public class Benchmark {
    public static void main(String[] args) {
        Father fs = new Son();
        fs.eat();
        Son son = new Son();
        son.eat(1);
        son.play();
    }
}
