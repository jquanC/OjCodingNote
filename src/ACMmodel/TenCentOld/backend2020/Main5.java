package ACMmodel.TenCentOld.backend2020;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main5 {
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
//        Point[] prr = new Point[n];
        PriorityQueue<Point> que = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x-o2.x;
            }
        });
        for(int i=0;i<n;i++){
            Point curP =  new Point(sc.nextInt(),sc.nextInt());
            que.add(curP);
            sc.nextLine();
        }
        int xp=0;
        int ans = 0;
        while(xp<L && que.size()>0){
            if(que.peek().x<=xp){
                Point candidate = que.poll();
                int maxContribute = candidate.y-xp;
                while(!que.isEmpty() && que.peek().x<=xp){
                    Point temp = que.poll();
                    if(temp.y-xp > maxContribute ){
                        maxContribute = temp.y-xp;
                        candidate = temp;
                    }
                }
                ans++;
                xp = candidate.y;
            }else{
                break;
            }
        }
        if(xp>=L) System.out.println(ans);
        else System.out.println(-1);

    }



}
