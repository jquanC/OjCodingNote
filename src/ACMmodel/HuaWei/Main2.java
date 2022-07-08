package ACMmodel.HuaWei;

import java.util.HashSet;
import java.util.Scanner;


public class Main2 {

    public static int ansCou = 0;
    public static int distance = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        sc.nextLine();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        sc.nextLine();
        int obs = sc.nextInt();
        int[][] g = new int[row][col];
        for (int i = 0; i < obs; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x][y] = 1;//表示障碍物
            sc.nextLine();
        }

        HashSet<String> path = new HashSet<>();
        dfs(g, path, startX, startY, endX, endY);
        distance--;
        System.out.println(ansCou+" "+distance);

    }

    public static void dfs(int[][] g, HashSet<String> path, int curX, int curY, int endX, int endY) {
        //check 合法性
        int row = g.length-1;
        int col = g[0].length-1;
        if(curX<0 || curY <0 ||curX>row||curY>col) return;
        if(g[curX][curY]==1) return;
        String point = String.valueOf(curX)+String.valueOf(curY);//其实这么做不严谨(12,1) 和（1，21）是两个坐标，在这里变成1个了
        if(path.contains(point)) return;

        //判断是否到终点
        if(curX == endX && curY == endY){
            path.add(point);
            int curDistance = path.size();
            if(curDistance <distance){
                distance = curDistance;
                ansCou = 1;
            }else if(curDistance == distance){
                ansCou++;
            }
            path.remove(point);
            return;
        }

        //记录并搜索
        path.add(point);
        dfs(g,path,curX+1,curY,endX,endY);
        dfs(g,path,curX-1,curY,endX,endY);
        dfs(g,path,curX,curY+1,endX,endY);
        dfs(g,path,curX,curY-1,endX,endY);
        path.remove(point);

    }
}
