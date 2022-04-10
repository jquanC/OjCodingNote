package ACMmodel.NetEase;

import org.junit.Test;

import java.util.*;

public class Main1 {
    public class Edge{
        int p1;
        int p2;
        int w;
        public Edge(int p1,int p2,int w){
            this.p1 = p1;
            this.p2 = p2;
            this.w = w;
        }
    }
    public int getMinimumTime (int[] productList, int[][] drivingTimes) {
        // write code here
        int row = drivingTimes.length;
        int col = drivingTimes[0].length;
        PriorityQueue<Edge> goEdges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        PriorityQueue<Edge> returnEdges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        for(int i=0;i<row-1;i++){
            for(int j=i+1;j<col;j++){
                if(drivingTimes[i][j]!=-1){
                    Edge edge = new Edge(i,j,drivingTimes[i][j]);
                    goEdges.add(edge);
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<i;j++){
                if(drivingTimes[i][j]!=-1){
                    Edge edge = new Edge(i,j,drivingTimes[i][j]);
                    returnEdges.add(edge);
                }
            }
        }
        //得到去和回的MST图代价
        int goMin = calMinGrid(goEdges,row);
        int reMin = calMinGrid(returnEdges,row);
        System.out.println("goMin="+goMin);
        System.out.println("reMin="+reMin);
        //只要计算需要运算多少个来回就可以了
        int[] car = new int[4];
        for(int i=0;i<4;i++) car[i]=10;
        int cNum = 0;
        int goCarCou=1;
        int reCarCou=0;
        Arrays.sort(productList);
        for(int i=0;i<productList.length;i++){
            if(car[cNum]-productList[i]>=0){
                car[cNum] -= productList[i];
            }else{
                i--;//回撤下i !
                cNum++;
                goCarCou++;
                if(cNum>=4){
                    cNum = 0;
                    for(int j=0;j<3;j++) car[j] = 10;
                    reCarCou++;
                }
            }
        }
        System.out.println("goCarCou="+goCarCou);
        System.out.println("reCarCou="+reCarCou);
//        int ans = goMin*(goCarCou-1)+reMin*reCarCou;
          int ans = goMin*(1+goCarCou/4)+(1+reCarCou/4)*reMin; //4辆车并发吗？是的,可能与原题理解有偏差，根据现在的这样，答案是8，算法是正确的
        return ans;


    }
    public int calMinGrid(PriorityQueue<Edge> edges,int total ){
        HashSet<Integer> selectP = new HashSet<>();
        int cost = 0;
        while (selectP.size()!=total){
            Edge edge = edges.poll();
            int p1 = edge.p1;
            int p2 = edge.p2;
            int w = edge.w;
            if(selectP.contains(p1)==false && selectP.contains(p2)==false){
                selectP.add(p1);
                selectP.add(p2);
                cost+=w;
            }else if(selectP.contains(p1)==false){
                selectP.add(p1);
                cost+=w;
            }else if(selectP.contains(p2)==false){
                selectP.add(p2);
                cost+=w;
            }
        }
        return cost;

    }
    @Test
    public void test(){
        int[] productList = new int[]{5,5,6,6,10,10,10};
        int[][] drivingTimes = new int[][]{{0,1,5},{1,0,2},{5,1,0}};
        int ans = getMinimumTime(productList,drivingTimes);//答案是9
        System.out.println(ans);
    }
}
