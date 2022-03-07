package ACMmodel.ByteDance;

public class TestClass {
    public static void main(String[] args) {
        Point p = new Point(1,2);
        System.out.println(p.x+" "+p.y);

    }
    static class Point{
        int x;
        int y;
        public  Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
