package Hot100.Medium.DataStruct;

import java.util.HashMap;
import java.util.List;

public class UnionAndFindSo {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*建立字符和id映射，并建立并查集*/
        int id = 0;
        HashMap<String, Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(equations.size() * 2);//最大长度，每个方程两个字符都不同的情况
        for (int i=0;i<equations.size();i++) {

            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);


            if (!map.containsKey(var1)) map.put(var1, id++);
            if (!map.containsKey(var2)) map.put(var2, id++);

            int x = map.get(var1);
            int y = map.get(var2);

            unionFind.union(x, y,values[i]);

        }

        //查询
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);
            Integer x = map.get(var1);
            Integer y = map.get(var2);

            if(x==null || y==null) res[i] = -1.0d;
            else{
                int rootX = unionFind.find(x);
                int rootY = unionFind.find(y);

                if(rootX != rootY) res[i] = -1.0d;
                else{
                    res[i] = unionFind.isConnected(x,y);
                }
            }

        }
        return res;
    }


    class UnionFind {

        int[] parent;
        double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         * value= x/y
         */
        public void union(int x, int y, double value) {
            int rootX = find(x); //带路径压缩
            int rootY = find(y);//带路径压缩
            if (rootX == rootY) return;
            else {

                parent[rootX] = rootY;
                weight[rootX] = weight[y] * value / weight[x];
            }
        }

        public int find(int x){
            if(x == parent[x]) return x;

            int origin = parent[x];
            parent[x] = find(parent[x]);
            weight[x] = weight[x]*weight[origin];
            return parent[x];
        }
        public double isConnected(int x,int y){
            return weight[x]/weight[y];
        }

    }
}
