package Hot100.Medium.BFS;

import java.lang.reflect.Array;
import java.util.*;

/**
 * BFS实现
 * *你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class canFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] edgesCou = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites
        ) {
            //
            edges.get(info[1]).add(info[0]);
            edgesCou[info[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();//？
        for (int i = 0; i < numCourses; i++) {
            if (edgesCou[i] == 0) que.offer(i);
        }

        int visited = 0;
        while (!que.isEmpty()) {
            int out = que.poll();
            ++visited;
            for (int e : edges.get(out)) {
                edgesCou[e]--;
                if (edgesCou[e] == 0) que.offer(e);
            }
        }

        return visited == numCourses;
    }

}
