package ACMmodel.NetEase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge{
    int p1;
    int p2;
    long w;
    public Edge(int p1,int p2,long w){
        this.p1 = p1;
        this.p2 = p2;
        this.w = w;
    }
}
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();sc.nextLine();
        long[] pw = new long[n+1];
        for(int i=1;i<=n;i++){
            pw[i] = sc.nextLong();
        }
        PriorityQueue<Edge> que = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.w > o2.w) return 1;
                else if(o1.w < o2.w) return -1;
                else return 0;
            }
        });
        long  ans = 0;
        for(int i=0;i<m;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = cal0(pw[v1]*pw[v2]);
            Edge cueE = new Edge(v1,v2,w);
            ans+=w;
            que.add(cueE);
        }
        //构造MST,ans 减去 选到的边w
        HashSet<Integer> set = new HashSet<>();
        while(set.size()!=n){
            Edge ed = que.poll();
            ans-=ed.w;
            set.add(ed.p1);
            set.add(ed.p2);
        }
        System.out.println(ans);

    }
    public static int cal0(long x){

        int mod = 10;
        int ans = 0;
        while(x % mod ==0){
            mod*=10;
            ans++;
        }
        return ans;
    }
}
