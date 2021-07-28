package Hot100.Medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class So29SimplifyLinuxPath {
    public String simplifyPath(String path) {
        Deque<String> pathQue = new LinkedList<>();
        String[] pathArr = path.split("/");


        for (String e : pathArr) {
            if (e.equals("") || e.equals(".")) continue;
            else if (e.equals("..")) {
                if (!pathQue.isEmpty()) {
                    pathQue.poll();
                }
            } else pathQue.offer(e);
        }

        return "/" + String.join("/", pathQue);
    }
}
