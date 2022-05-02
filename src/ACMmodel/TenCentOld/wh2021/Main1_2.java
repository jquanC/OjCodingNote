package ACMmodel.TenCentOld.wh2021;

import java.util.HashMap;
import java.util.Scanner;


public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] ans = new int[T];
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            UnionFind uf = new UnionFind();
            sc.nextLine();
            for (int t = 0; t < n; t++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                uf.union(x, y);
            }
            ans[i] = 0;
            for(int j =0;j<uf.personsNum.length;j++){
                ans[i] = Math.max(ans[i],uf.personsNum[j]);
            }
        }
        for (int i = 0; i < T; i++) {
            System.out.println(ans[i]);
        }
    }
}

class UnionFind {
    int[] parent;
    int[] personsNum;

    public UnionFind() {
        parent = new int[100000 + 10];
        personsNum = new int[100000 + 10];
        for(int i=0;i<100000+10;i++){
            personsNum[i] = 1;
            parent[i] = i;
        }

    }

    /*并查集 union 的时候，一定要修改的是一个群主，指向另外一个群主*/
    public void union(int x, int y) { //1 , 6
        int rootY = find(y);
        int rootX = find(x);
        if(rootX == rootY) return;
        parent[rootY] = rootX;
        personsNum[rootX] += personsNum[rootY];
    }

    public int find(int x) {
       if(parent[x] == x) return x;
       parent[x] = find(parent[x]);
       return parent[x];
    }

    /*public int calMaxQNum() {
        HashMap<Integer,Integer> cal = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0 ) continue;
            if(arr[i] == -1) cal.put(i,cal.getOrDefault(i,0)+1);
            else{
                int l = find(i);
                cal.put( l,cal.getOrDefault(l,0)+1);
            }
        }
        int max=0;
        for(int e : cal.values()){
            if(e>max) max = e;
        }
        return max;

    }*/
}
