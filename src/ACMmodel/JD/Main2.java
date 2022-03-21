package ACMmodel.JD;

import java.util.*;

public class Main2 {
    static class Edge{
        int p1;
        int p2;
        int weight;
        public Edge(int p1,int p2,int w){
            this.p1 = p1;
            this.p2 = p2;
            this.weight = w;
        }
    }
    public static void main(String[] args) {
        int n,m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        scan.nextLine();
        Edge[] edgeArr = new Edge[m];
        for(int i = 0;i<m;i++){
            int p1 = scan.nextInt();
            int p2= scan.nextInt();
            int w = scan.nextInt();
            edgeArr[i] = new Edge(p1,p2,w);
            scan.nextLine();
        }
        HashSet<Integer> jointPoint = new HashSet<>();
        Queue<Edge> bigHeap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.weight-o1.weight;
            }
        });
        for(Edge e : edgeArr) bigHeap.add(e);
        int minEdgeW = Integer.MAX_VALUE;
        while(jointPoint.size()<n){
            Edge curEdge = bigHeap.poll();
            if(jointPoint.contains(curEdge.p1)&&jointPoint.contains(curEdge.p2)){
             continue;
            }
            if(!jointPoint.contains(curEdge.p1)) jointPoint.add(curEdge.p1);
            if(!jointPoint.contains(curEdge.p2)) jointPoint.add(curEdge.p2);
            if(minEdgeW>curEdge.weight) minEdgeW = curEdge.weight;
        }
        System.out.println(minEdgeW);

    }
}
