package comp.sf;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * "1->1,1->3,2->6,3->4,3->5,3->6,4->5,4->6"
 *输出 f
 *预期 t
 * 漏了自环
 * */
public class main03 {
    ArrayList<Integer>[] inEdges = new ArrayList[100 + 1];
    ArrayList<Integer>[] outEdges = new ArrayList[100 + 1];

    HashSet<Integer> validPoint = new HashSet<>();
    boolean existSelfCycle = false;

    public static void main(String[] args) {
//        String str = "1->2,2->3,3->1";
        String str ="1->1,1->3,2->6,3->4,3->5,3->6,4->5,4->6";
        main03 test = new main03();
        boolean ans =  test.hasCycle(str);
        System.out.println(ans);
    }

    public boolean hasCycle(String graph) {
        String[] strs = graph.split(",");
        buildEdges(strs);
        //统计入度为0的店，即搜索起点
        HashSet<Integer> searchStart = new HashSet<>();
        for (int i = 1; i < inEdges.length; i++) {
            if (validPoint.contains(i) && inEdges[i] == null) {
                searchStart.add(i);
            }
        }
        if(searchStart.size()==0) return true;
        if(existSelfCycle) return true;
        boolean ans = false;
        for (int e : searchStart) {
            ans = ans || dfs(e, new HashSet<>());
        }

        return ans;
    }

    public void buildEdges(String[] strs) {
        for (String str : strs) {
            String[] nums = str.split("->");
            int num1 = Integer.valueOf(nums[0]);
            int num2 = Integer.valueOf(nums[1]);
            validPoint.add(num1);
            validPoint.add(num2);
            if (outEdges[num1] == null) outEdges[num1] = new ArrayList<>();
            if (inEdges[num2] == null) inEdges[num2] = new ArrayList<>();

            outEdges[num1].add(num2);
            inEdges[num2].add(num1);
            if(num1 == num2) existSelfCycle = true;
        }
//        System.out.println("");
    }

    public boolean dfs(int cur, HashSet<Integer> path) {
        boolean ans = false;
        if (path.contains(cur)) {
            ans = true;
            return ans;
        } else {
            path.add(cur);
            if (outEdges[cur] != null) {
                for (int e : outEdges[cur]) {
                    ans =  ans ||dfs(e,path);
                }
            }
            path.remove(cur);
        }
        return  ans;
    }

}
