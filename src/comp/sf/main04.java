package comp.sf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*https://wenku.baidu.com/view/27e7bfd17f1cfad6195f312b3169a4517723e567.html*/
/***
 * 此题基本思路是对要判定的点，作水平左射线法来判定
 * 需要依次判断和每条线段的情况：
 *      点 是否是顶点
 *      点 是否在线段y区间范围上
 *          点是否在线段x区间范围内
 *              点是否在线段上，考虑线段3种情况：平行y轴，平行x轴，斜线段
 *          点水平左射线是否穿过：p.x <= Math.min(p1.x, p2.x) ？ 不穿 ： 穿
 * */
/**
 * x=1,y=3
 * coords=[0,0,0,4,4,4,2,2,4,0,0,0]
 * */
public class main04 {
    public static void main(String[] args) {
        main04 test = new main04();
        double[] coords = new double[]{0,0,0,4,4,4,2,2,4,0,0,0};
        boolean ans = test.isPointInPolygon(1,3,coords);
        System.out.println(ans);
    }
    class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    public boolean isPointInPolygon(double x, double y, double[] coords) {
        List<Point> pList = new ArrayList<>();
        for (int i = 0; i < coords.length; i++) {
            pList.add(new Point(coords[i], coords[++i]));//++i
        }
        return isIn(pList, new Point(x, y));

    }


    public Boolean isIn(List<Point> pList, Point point) {
        Boolean flag = true;
        Point p, p1, p2;
        Integer through = 0;
        double threshold = 2e-10; //误差阈值
        p = point;

        for (int i = 0; i < pList.size(); i++) {
            p1 = pList.get(i);
            int j = (i + 1) >= pList.size() ? 0 : (i + 1);
            p2 = pList.get(j);
            //1 判断是否在点上
            if (pointCom(p, p1) || pointCom(p, p2)) { //p是多边形上的顶点的情况
                return flag;
            }
            //2 该点是否在两个端点之间
            if (p.y <= Math.max(p1.y, p2.y) && p.y >= Math.min(p1.y, p2.y)) { // 点在此边的y轴距之间
                //3 判断该点是否在两点连成的线段上
                if (p.x <= Math.max(p1.x, p2.x) && p.x >= Math.min(p1.x, p2.x)) {// 点在此边的x轴距之间
                    //该线段是水平线
                    if (p1.y == p2.y) { //此多边形边平行于x轴
                        if (p.y == p1.y) {  //点在边上
                            return flag;
                        }
                    }
                    //该线段是垂直线
                    if (p1.x == p2.x) { //此多边形边平行于y轴
                        if (p.x == p1.x) { //点在边上
                            return flag;
                        }
                    }
                    //该线段是斜线
                    double xianShangY = p1.y + (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x); //
                    if (Math.abs(xianShangY - p.y) < threshold) {
                        return flag;   // 在线上
                    }
                }
                //判断两个端点是否越过该点（因为是左水平射线）
                if (p.x <= Math.min(p1.x, p2.x)) {
                    continue;
                }
                /**
                 * 该点位于两个端点之间，判断是否穿过顶点；穿过顶点时，顶点按照在射线上部处理
                 * 穿过顶点时，只有两个端点在射线两侧的才按照穿越处理
                 * */
                if (p1.y != p2.y && p.y != Math.min(p1.y, p2.y)) {
                    through++;
                }
            }
        }
        if (through % 2 == 0) {
            return !flag;      // 偶数，在外部
        }
        return flag;
    }

    public boolean pointCom(Point one, Point two) {
        if (one.x == two.x && one.y == two.y) return true;
        else return false;
    }
}


