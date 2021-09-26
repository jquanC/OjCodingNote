package Hot100.Medium.DFS;

/*
* DFS应用-拓扑排序
*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class canFinish {
    boolean valid  = true;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];//0 - 未来访问 1-访问中 2-访问完毕

        Stack<Integer> stack = new Stack<>();

        /*建立存储图的数据结构，出边表*/
        /*用List<List>存储，节点num 就是 第一个List的index, 每个节点的出边存在第二个list中*/
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) edges.add(new ArrayList<>());//初始化

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]); //point
        }

        for (int i=0;i<numCourses && valid;i++){
            if(visited[i] == 0){
                dfs(i,edges);
            }
        }

        return valid;
    }
    public void dfs(int s,List<List<Integer>> edges){
        visited[s]=1;
        for(int e: edges.get(s)){
            if(visited[e] == 0){
                dfs(e,edges);
                if(!valid) return;

            }else if(visited[e]==1){ // point:形成环
                valid = false;
                return ;
            }

        }
        visited[s] = 2;//压栈，如果要输出拓扑序列的顺序的话
    }
}
