package Qiu.MeiD;

import java.util.ArrayList;

 class Point {
   int x;
   int y;
   public Point(int x, int y) {
     this.x = x;
    this.y = y;
    }
  }
public class Main2 {

    public int maxPointsNum (Point[] points) {
        // write code here
        int max = 2;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                Point one = points[i];
                Point two = points[j];
                int ans = cal(one,two,i,j,points);
                if(ans>max) max = ans;
            }
        }
        return max;
    }
    public int cal(Point one,Point two, int p1,int p2,Point[] points){
        int cou = 0;
        for(int i=0;i<points.length;i++){
            if(i==p1 || i==p2) continue;

            if(two.y==one.y){
                if(points[i].y==one.y){
                    cou++;
                    continue;
                }
            }
            if(two.x==one.x){
                if(points[i].x==one.x){
                    cou++;
                    continue;
                }
            }

            double left = (double) (points[i].y-one.y)*1.0/(double) (two.y-one.y)*1.0;
            double right = (double) (points[i].x-one.x)*1.0/(double)(two.x-one.x)*1.0;
            if(left==right)cou++;
        }
        return cou+2;

    }

}
